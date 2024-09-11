package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.SBlockEntities.LivingStructureBlocks;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Utility.InfectionTendril;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class Mound extends Organoid {
    private static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(Mound.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COUNTER = SynchedEntityData.defineId(Mound.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MAX_AGE = SynchedEntityData.defineId(Mound.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> STRUCTURE = SynchedEntityData.defineId(Mound.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LINKED = SynchedEntityData.defineId(Mound.class, EntityDataSerializers.BOOLEAN);
    public int maxCounter =  SConfig.SERVER.mound_cooldown.get();
    private int attack_counter = 0;
    public Mound(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 30;
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return this.getLinked() && this.getMaxAge() <= 2;
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.mound_loot.get();
    }
    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0){
            if (this.isAlive() && entityData.get(AGE) < entityData.get(MAX_AGE)){
                this.getPersistentData().putInt("age", 1 + this.getPersistentData().getInt("age"));
                if (this.getPersistentData().getInt("age") >= SConfig.SERVER.mound_age.get()) {
                    this.getPersistentData().putInt("age",0);
                    entityData.set(AGE,entityData.get(AGE) + 1);
                }
            }
            if (entityData.get(COUNTER) < maxCounter){
                this.setCounter(this.getCounter() + 1);
            }
            if (this.isAlive() && this.getCounter() >= maxCounter && !level().isClientSide){
                Spread(this , this.level());
                this.setCounter(0);
                if (this.random.nextInt(10) == 0 && entityData.get(AGE) >= 3 && checkForExtraTendrils(this,this.level())){
                    SpreadKin(this,this.level());
                }
            }
            if (this.getCounter() > (maxCounter - 2) && this.getCounter() < maxCounter && this.level() instanceof ServerLevel serverLevel){
                double x0 = this.getX() - (random.nextFloat() - 0.2) * 0.2D;
                double y0 = this.getY() + (random.nextFloat() - 0.5) * 0.5D * 10;
                double z0 = this.getZ() + (random.nextFloat() - 0.2) * 0.2D;
                serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(), x0, y0, z0, 9,0, 0, 0,1);
            }
            if (this.getCounter() == (maxCounter - 2)){
                this.playSound(Ssounds.PUFF.get());
            }
        }
        if (this.isAlive() && attack_counter > 0){
            attack_counter = attack_counter - 1;
        }

    }
    public int getAge(){
        return entityData.get(AGE);
    }
    public void setAge(int e){entityData.set(AGE,e);}

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("age",entityData.get(AGE));
        tag.putInt("counter",entityData.get(COUNTER));
        tag.putInt("max_age",entityData.get(MAX_AGE));
        tag.putBoolean("structure",entityData.get(STRUCTURE));
        tag.putBoolean("linked",entityData.get(LINKED));
    }

    public int getAgeCounter(){
        return this.getPersistentData().getInt("age");
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(AGE, tag.getInt("age"));
        entityData.set(COUNTER, tag.getInt("counter"));
        entityData.set(MAX_AGE, tag.getInt("max_age"));
        entityData.set(STRUCTURE, tag.getBoolean("structure"));
        entityData.set(LINKED, tag.getBoolean("linked"));
    }

    public void setCounter(int counter) {
        this.entityData.set(COUNTER,counter);
    }

    public int getCounter() {
        return this.entityData.get(COUNTER);
    }
    public int getMaxCounter() {
        return this.maxCounter;
    }
    public void setMaxAge(int maxAge){
        entityData.set(MAX_AGE,maxAge);
    }

    public  int getMaxAge(){
        return entityData.get(MAX_AGE);
    }

    public void setLinked(boolean value){
        this.entityData.set(LINKED,value);
    }

    public boolean getLinked(){
        return this.entityData.get(LINKED);
    }
    private void Spread(Entity entity , LevelAccessor level) {
        double range;
        if (entityData.get(AGE) == 2){
            range = SConfig.SERVER.mound_range_age2.get();
        } else if (entityData.get(AGE) == 3){
            range = SConfig.SERVER.mound_range_age3.get();
        }else if (entityData.get(AGE) == 4){
            range = SConfig.SERVER.mound_range_age4.get();
        } else {
            range = SConfig.SERVER.mound_range_default.get();
        }

        BlockState block1 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:ground_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block2 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:roof_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block3 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:wall_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block4 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:block_st")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block5 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:underwater_blocks")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.WATER)).defaultBlockState();

        AABB aabb = entity.getBoundingBox().inflate(range);
        if (SConfig.SERVER.mound_foliage.get()){
            for(int i = 0; i <= 2*range; ++i) {
                for(int j = 0; j <= 2*range; ++j) {
                    for(int k = 0; k <= 2*range; ++k) {
                        double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                        if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                            if (distance<range+(0.5)){
                                BlockPos blockpos = this.getOnPos().offset( i-(int)range,j-(int)range,k-(int)range);

            BlockState nord = level.getBlockState(blockpos.north());
            BlockState south = level.getBlockState(blockpos.south());
            BlockState west = level.getBlockState(blockpos.west());
            BlockState east = level.getBlockState(blockpos.east());
            BlockState above = level.getBlockState(blockpos.above());
            BlockState below = level.getBlockState(blockpos.below());
            boolean nordT = !nord.isSolidRender(level,blockpos.north());
            boolean southT = !south.isSolidRender(level,blockpos.south());
            boolean westT = !west.isSolidRender(level,blockpos.west());
            boolean eastT = !east.isSolidRender(level,blockpos.east());
            boolean aboveT = !above.isSolidRender(level,blockpos.above());
            boolean belowT = !below.isSolidRender(level,blockpos.below());

            BlockState blockstate = level.getBlockState(blockpos);

            if (Math.random() < 0.02 && blockstate.isSolidRender(level,blockpos)
                    && (nordT || southT || westT || eastT || aboveT || belowT)){
                for (String str : SConfig.DATAGEN.block_infection.get()){
                    String[] string = str.split("\\|" );
                    ItemStack stack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0])));
                    if (stack != ItemStack.EMPTY && blockstate.getBlock().asItem() == stack.getItem()){
                        ItemStack itemStack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1])));
                        if (itemStack != ItemStack.EMPTY && itemStack.getItem() instanceof BlockItem blockItem){
                            level.setBlock(blockpos,blockItem.getBlock().defaultBlockState(),3);
                        }
                    }
                }
            }



            if (blockstate.is(BlockTags.LOGS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
                BlockState _bs = Sblocks.ROTTEN_LOG.get().defaultBlockState();
                for (Map.Entry<Property<?>, Comparable<?>> entry : blockstate.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null)
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception e) {
                        }
                }
                level.setBlock(blockpos, _bs, 3);
            }
            if (blockstate.is(BlockTags.WOODEN_STAIRS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
                    BlockState _bs = Sblocks.ROTTEN_STAIR.get().defaultBlockState();
                    for (Map.Entry<Property<?>, Comparable<?>> entry : blockstate.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null)
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception e) {
                            }
                    }
                    level.setBlock(blockpos, _bs, 3);
            }
            if (blockstate.is(BlockTags.PLANKS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
                    BlockState _bs = Sblocks.ROTTEN_PLANKS.get().defaultBlockState();
                    level.setBlock(blockpos, _bs, 3);
            }


            if (blockstate.isSolidRender(level,blockpos ) && (above.getFluidState().is(Fluids.WATER) || above.getFluidState().is(Fluids.FLOWING_WATER)) && Math.random() < 0.01){
                if (block5.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty property){
                    level.setBlock(blockpos.above(),block5.setValue(property, true),3);
                }else {
                    level.setBlock(blockpos.above(),block5,3);
                }

            }


            if (above.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01){level.setBlock(blockpos.above(),block1,3);}
            if (above.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01 && entityData.get(STRUCTURE) && entityData.get(AGE) >= entityData.get(MAX_AGE) && this.distanceToSqr(blockpos.getX(),blockpos.getY(),blockpos.getZ()) > 80){
                level.setBlock(blockpos.above(),block4,3);
                entityData.set(STRUCTURE,false);
            }
            if (below.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01){
                if (block2.getBlock().getStateDefinition().getProperty("hanging") instanceof BooleanProperty property){
                    level.setBlock(blockpos.below(),block2.setValue(property, true),3);
                }else {
                    level.setBlock(blockpos.below(),block2,3);}}


            if (blockstate.isSolidRender(level , blockpos) && (nordT || southT || westT || eastT || aboveT || belowT)){
                Direction direction = Direction.NORTH;
                Direction direction2 = Direction.SOUTH;
                Direction direction3 = Direction.EAST;
                Direction direction4 = Direction.WEST;
                Property<?> property = block3.getBlock().getStateDefinition().getProperty("facing");
                if (property instanceof DirectionProperty directionProperty && Math.random() < 0.01) {
                    if (nord.isAir()){
                        level.setBlock(blockpos.north(),block3.setValue(directionProperty,direction),3);
                    }
                    if (south.isAir()){
                        level.setBlock(blockpos.south(),block3.setValue(directionProperty,direction2),3);
                    }
                    if (west.isAir()){
                        level.setBlock(blockpos.west(),block3.setValue(directionProperty,direction4),3);
                    }
                    if (east.isAir()){
                        level.setBlock(blockpos.east(),block3.setValue(directionProperty,direction3),3);
                    }
                }
            }
            }}}}}
        }else{
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = level.getBlockState(blockpos);
                BlockState above = level.getBlockState(blockpos.above());
                if (above.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01 && entityData.get(STRUCTURE) && entityData.get(AGE) >= entityData.get(MAX_AGE) && this.distanceToSqr(blockpos.getX(),blockpos.getY(),blockpos.getZ()) > 80){
                    level.setBlock(blockpos.above(),block4,3);
                    entityData.set(STRUCTURE,false);
                }
            }
            List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, aabb);
            for (LivingEntity en : entities) {
                if (!(en instanceof Infected || en instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) || en.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.GAS_MASK.get())){
                    en.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,1));
                }
            }
        }
    }


    private void SpreadKin(Entity entity , Level level) {
        AABB aabb = entity.getBoundingBox().inflate(SConfig.SERVER.mound_tendril_checker.get());
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockState = level.getBlockState(blockpos);

            if (isStructureBlock(blockpos) || isChestWithFood(blockpos) || blockState.is(Sblocks.REMAINS.get()) || blockState.is(Blocks.SPAWNER)){
                InfectionTendril tendril = new InfectionTendril(Sentities.TENDRIL.get(),level);
                tendril.setAgeM(this.getMaxAge() -1);
                tendril.setSearchArea(blockpos);
                tendril.setPos(this.getX(),this.getY()+0.5D,this.getZ());
                level.addFreshEntity(tendril);
                break;
            }
        }
    }

    private boolean isChestWithFood(BlockPos pos){
        BlockEntity blockEntity = this.level().getBlockEntity(pos);
        if (blockEntity instanceof Container container){
            return container.hasAnyMatching((ItemStack::isEdible));
        }
        return false;
    }
    private boolean isStructureBlock(BlockPos pos){
        BlockEntity blockEntity = this.level().getBlockEntity(pos);
        return blockEntity instanceof LivingStructureBlocks;
    }


    private boolean checkForExtraTendrils(Entity entity , Level level){
        AABB aabb = entity.getBoundingBox().inflate(SConfig.SERVER.mound_tendril_checker.get());
        List<InfectionTendril> entities = level.getEntitiesOfClass(InfectionTendril.class, aabb);
        return entities.size() <= 4;
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        if (attack_counter == 0){
            LivingEntity entity = this;
            if (!entity.level().isClientSide) {
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(entity.level(), entity.getX(), entity.getY(), entity.getZ());
                areaeffectcloud.setOwner(entity);
                areaeffectcloud.setRadius(2.0F);
                areaeffectcloud.setDuration(300);
                areaeffectcloud.setRadiusPerTick(((1.5F * entityData.get(AGE)) - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
                areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 200, 1));
                entity.level().addFreshEntity(areaeffectcloud);
                this.playSound(Ssounds.PUFF.get() ,0.5f ,0.5f);
                attack_counter = 300;
            }
        }
        return super.hurt(p_21016_, p_21017_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(AGE, 1);
        this.entityData.define(COUNTER, 0);
        this.entityData.define(MAX_AGE, 4);
        this.entityData.define(STRUCTURE, true);
        this.entityData.define(LINKED, false);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        double health = SConfig.SERVER.mound_hp.get() * entityData.get(AGE) * SConfig.SERVER.global_health.get();
        double armor = SConfig.SERVER.mound_armor.get() * entityData.get(AGE) * SConfig.SERVER.global_armor.get();
        if (AGE.equals(dataAccessor)){
            AttributeInstance hp = this.getAttribute(Attributes.MAX_HEALTH);
            AttributeInstance def = this.getAttribute(Attributes.ARMOR);
            if (hp != null){
                hp.setBaseValue(health);
            }
            if (def != null){
                def.setBaseValue(armor);
            }
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(2, new HurtTargetGoal(this, (en -> {
            return !(SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) || en instanceof UtilityEntity || en instanceof Infected);
        }), Infected.class).setAlertOthers(Infected.class));
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(this.getAge() >= 1 ? (1.0F * this.getAge()) : 1.0F);
    }

    @Override
    public void die(DamageSource source) {
        if(this.getLinked() && this.getAge() > 3 && source.getEntity() != null){
            if (this.isInPowderSnow || this.Cold() || (this.getLastDamageSource() != null && this.getLastDamageSource().is(DamageTypes.FREEZE))){
                return;
            } else
            {
            AABB searchbox = this.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
            List<Proto> entities = this.level().getEntitiesOfClass(Proto.class,searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Proto proto : entities) {
                int y = source.getDirectEntity() != null ? (int)  source.getDirectEntity().getY() :(int)  this.getY();
                proto.setSignal(true);
                proto.setPlace(new BlockPos((int) this.getX(),y,(int) this.getZ()));
                break;
                }
            }
        }
        for (int i = 0;i <= this.getAge(); i++){
            super.die(source);
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
       this.setDefaultLinkage(this.level());
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public void setDefaultLinkage(Level level){
        if (level instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            if (data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get()){
                this.setLinked(true);
            }
        }
    }
    @Override
    public int getEmerge_tick() {
        return 40;
    }
}
