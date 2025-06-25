package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.Signal;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.VigilVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class Vigil extends Organoid implements TraceableEntity, VariantKeeper {
    private static final EntityDataAccessor<Integer> TRIGGER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> WAVE_SIZE = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Vigil.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Busser.class, EntityDataSerializers.INT);
    private int summon_counter;
    @Nullable
    private Mob proto;
    public Vigil(EntityType<? extends UtilityEntity> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.vigil_loot.get();
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WAVE_SIZE, 0);
        this.entityData.define(TIMER, 0);
        this.entityData.define(TRIGGER, 0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public int getEmerge_tick(){
        return isStalker() ? 90 : 180;
    }

    @Override
    public int getBorrow_tick() {
        return isStalker() ? 100 : 200;
    }

    @Override
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > this.getBorrow_tick()) {
            burrowing = -1;
            if (this.isStalker() && this.getTarget() != null){
                this.ReEmerge();
            }else{
                if (getVariant() == VigilVariants.TROLL && level() instanceof ServerLevel serverLevel){
                    if (getLastAttacker() instanceof Player || this.getTarget() instanceof Player){
                        this.pickAndPlaceMessage(serverLevel,this.getOnPos().above());
                    }
                }
                this.discard();
                this.TimeToLeave();
            }
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    public boolean isStalker(){return getVariant() == VigilVariants.STALKER;}
    public int getTrigger(){
        return entityData.get(TRIGGER);
    }
    public void setTrigger(int i){
        entityData.set(TRIGGER,i);
    }
    public int getWaveSize(){
        return entityData.get(WAVE_SIZE);
    }
    public void setWaveSize(int i){
        entityData.set(WAVE_SIZE,i);
    }
    public int getTimer(){return entityData.get(TIMER);}

    @Nullable
    public void setProto(Mob entity){
        this.proto = entity;
    }
    @Override
    public boolean isNoAi() {
        return this.isBurrowing() || this.isEmerging();
    }

    @Override
    public void tick() {
        if (this.getTarget() == null && this.entityData.get(TIMER) < 6000){
            if (this.entityData.get(TIMER) % 300 == 0){
                this.setTrigger(0);
                this.setWaveSize(0);
            }
            this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
        }else if (this.entityData.get(TIMER) >= 6000){
            escape();
        }
        if (this.getTarget() != null && this.distanceToSqr(this.getTarget()) < 300 || this.getTrigger() >= 4){
            this.setTrigger(this.getTrigger() <= 0 ? 1:this.getTrigger());
            escape();
        }
        super.tick();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("trigger",entityData.get(TRIGGER));
        tag.putInt("timer",entityData.get(TIMER));
        tag.putInt("wave_size",entityData.get(WAVE_SIZE));
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TRIGGER, tag.getInt("trigger"));
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(WAVE_SIZE, tag.getInt("wave_size"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    public void ReEmerge(){
        entityData.set(TIMER,0);
        this.randomTeleport(this.getX()+random.nextInt(-30,30),this.getY(),this.getZ()+random.nextInt(-30,30),false);
        tickEmerging();
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        if (this.isEmerging()){
            return false;
        }
        this.escape();
        return super.hurt(p_21016_, p_21017_);
    }

    public void escape(){
        if (this.onGround()){
            this.tickBurrowing();
        }
    }
    boolean checkForScents(){
        AABB aabb = this.getBoundingBox().inflate(16);
        List<ScentEntity> entities = this.level().getEntitiesOfClass(ScentEntity.class, aabb);
        return entities.size() < SConfig.SERVER.scent_cap.get();
    }

    public void TimeToLeave(){
        int i = entityData.get(TRIGGER);
        if (i == 1){
            this.SummonScent(this , this.level(),false);
        }else if (i == 2){
            this.SummonScent(this , this.level(),true);
        }else if (i >= 3){
            AABB searchbox = this.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
            List<Entity> entities = this.level().getEntities(this, searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Proto proto){
                    proto.setSignal(new Signal(true,new BlockPos((int)this.getX(),(int)this.getY(),(int)this.getZ())));
                    break;
                }}
        }
        punishHivemind();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.VIGIL_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }


    private void SummonScent(Entity entity ,Level level,boolean value){
        if (checkForScents()){
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),level);
        scent.moveTo(entity.getX(),entity.getY(),entity.getZ());
        scent.setOvercharged(value);
        level.addFreshEntity(scent);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public Entity getOwner() {
        return this.proto;
    }
    public VigilVariants getVariant() {
        return VigilVariants.byId(this.getTypeVariant() & 255);
    }

    @Override
    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        if (i > VigilVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return VigilVariants.values().length;
    }

    public void pickAndPlaceMessage(ServerLevel serverLevel, BlockPos pos) {
        if (pos.equals(BlockPos.ZERO) || !serverLevel.getBlockState(pos).isAir()) {
            return;
        }

        String key = "spore.proto.message." + random.nextInt(10);
        Component translated = Component.translatable(key);
        String[] words = translated.getString().split(" ");

        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= 15) {
                if (currentLine.length() > 0) currentLine.append(" ");
                currentLine.append(word);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
                if (lines.size() == 4) break;
            }
        }

        if (lines.size() < 4 && currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        // Ensure the array is exactly 4 lines (sign limit)
        while (lines.size() < 4) {
            lines.add("");
        }

        placeSignWithText(serverLevel, pos, lines.toArray(new String[0]));
    }

    public void placeSignWithText(ServerLevel world, BlockPos pos, String[] lines) {
        BlockState signState = Blocks.OAK_SIGN.defaultBlockState();

        world.setBlockAndUpdate(pos, signState);

        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof SignBlockEntity sign)) return;

        SignText newText = sign.getFrontText();
        int v = Math.min(lines.length, 4);
        for (int i = 0; i <v; i++) {
            String centered = centerLine(lines[i], 15);
            Component line = Component.literal(centered);
            newText = newText.setMessage(i, line, line);
        }

        sign.setText(newText,true);
        sign.setChanged();
    }
    private String centerLine(String text, int width) {
        if (text.length() >= width) return text.substring(0, width);
        int pad = (width - text.length()) / 2;
        return " ".repeat(pad) + text;
    }

    private void setVariant(VigilVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    private static class WatchTargetGoat extends Goal{
        private final Vigil vigil;

        public WatchTargetGoat(Vigil vigil1){
            this.vigil = vigil1;
        }
        @Override
        public boolean canUse() {
            return this.vigil.getTarget() != null;
        }

        @Override
        public void tick() {
            super.tick();
            Entity target = this.vigil.getTarget();
            if (target != null && this.vigil.hasLineOfSight(target)){
                this.vigil.getLookControl().setLookAt(target, 30.0F, 30.0F);
                if (target instanceof ServerPlayer player){
                    if (!player.hasEffect(Seffects.UNEASY.get())){
                        player.addEffect(new MobEffectInstance(Seffects.UNEASY.get(),6000,0));
                    }
                    player.displayClientMessage(Component.translatable("vigil.message"),true);
                }
            }
        }

        @Override
        public void start() {
            super.start();
            if (this.vigil.getTarget() != null && this.vigil.proto != null){
                if (this.vigil.proto.getTarget() == null){
                    this.vigil.proto.setTarget(this.vigil.getTarget());
                }
            }

        }
    }

    private static class WatcherMobSummon extends Goal{
        private final Vigil vigil;

        private WatcherMobSummon(Vigil vigil) {
            this.vigil = vigil;
        }

        @Override
        public boolean canUse() {
            if (this.vigil.getWaveSize() > 0){
                return false;
            }
            return this.vigil.random.nextInt(100) == 0  && this.vigil.getTarget() != null && checkForInfected(this.vigil.getTarget());
        }
        boolean checkForInfected(Entity entity){
            AABB boundingBox = entity.getBoundingBox().inflate(16);
            List<Entity> entities = entity.level().getEntities(entity, boundingBox ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Infected){
                    return false;
                }
            }
            return true;
        }

        @Override
        public void start() {
            super.start();
            if (this.vigil.getTarget() != null && this.vigil.getWaveSize() <= 0){
                LivingEntity target = this.vigil.getTarget();
                int l = SConfig.SERVER.vigil_wave_size.get();
                int e = target.getMaxHealth() > l*5 ? l : (int) (target.getMaxHealth() / 5) + (target.getArmorValue()/4);
                this.vigil.setWaveSize(e);
                this.vigil.setTrigger(this.vigil.getTrigger() +1);
            }
        }
    }

    public void SummonInfected(){
        List<? extends String> summons;
        int l = this.getTrigger();
        if (l <= 1) {
                summons = SConfig.SERVER.vigil_base_wave.get();
        } else if (l == 2) {
                summons = SConfig.SERVER.vigil_middle_wave.get();
        } else {
                summons = SConfig.SERVER.vigil_max_wave.get();
        }
        awardHivemind();
        LivingEntity target = this.getTarget();
        if (target != null && this.getTrigger() > 0 && this.level() instanceof ServerLevelAccessor world){
            RandomSource rand = RandomSource.create();
                int randomIndex = rand.nextInt(summons.size());
                ResourceLocation randomElement1 = new ResourceLocation(summons.get(randomIndex));
                EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                Mob waveentity = (Mob) randomElement.create(this.level());
                assert waveentity != null;
                waveentity.setPos(this.getX(), this.getY(), this.getZ());
                waveentity.finalizeSpawn(world, this.level().getCurrentDifficultyAt(new BlockPos((int) this.getX(),(int)  this.getY(),(int)  this.getZ())), MobSpawnType.NATURAL, null, null);
                if (waveentity.getTarget() == null && target.isAlive() && !target.isInvulnerable()){
                    waveentity.setTarget(target);
                }
                this.level().addFreshEntity(waveentity);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vigil_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vigil_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
    public void aiStep() {
        super.aiStep();
        if (this.getWaveSize() > 0 && this.summon_counter <=20){
            this.summon_counter++;
        }else{
            if (this.getWaveSize() > 0 && this.summon_counter >= 20){
                this.summon_counter = 0;
                SummonInfected();
                this.setWaveSize(this.getWaveSize() - 1);
            }
        }

        if (this.getWaveSize() > 0){
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();
            RandomSource randomsource = this.getRandom();
            for (int l = 0 ;l<3;l++){
                int i = randomsource.nextInt(-3,3);
                int i1 = randomsource.nextInt(-3,3);
                if (level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(),x+i,y+random.nextDouble(),z+i1,1
                    ,0,0.3,0,0.15F);
                }
            }
        }
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        if (getOwner() instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.GLOWING,200,0));
        }
        return super.mobInteract(player, interactionHand);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(2 ,new WatchTargetGoat(this));
        this.goalSelector.addGoal(2 ,new WatcherMobSummon(this));
        this.goalSelector.addGoal(3 ,new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    public int getNumberOfParticles(){
        return 4;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return isStalker() ? super.getDimensions(pose).scale(1.2f)  : super.getDimensions(pose);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        VigilVariants variant = Util.getRandom(VigilVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }
}
