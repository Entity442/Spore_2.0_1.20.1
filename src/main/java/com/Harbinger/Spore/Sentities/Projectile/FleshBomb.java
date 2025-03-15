package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Utility.NukeEntity;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class FleshBomb extends AbstractArrow {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> BOMB_TYPE = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> EXPLOSION = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> CARRIER = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.BOOLEAN);
    private Predicate<LivingEntity> livingEntityPredicate = (entity) -> {return true;};
    @Nullable
    private Entity target;

    public FleshBomb(Level level,LivingEntity entity,float damage,BombType type,int range) {
        super(Sentities.FLESH_BOMB.get(), level);
        setBombType(type.getValue());
        setExplosion(range);
        setDamage(damage);
        setOwner(entity);
    }
    public void setTarget(Entity entity){
        this.target = entity;
    }

    public FleshBomb(EntityType<FleshBomb> fleshBombEntityType, Level level) {
        super(fleshBombEntityType,level);
    }

    public FleshBomb(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(Sentities.FLESH_BOMB.get(), level);
    }
    public void setLivingEntityPredicate(Predicate<LivingEntity> value){
        this.livingEntityPredicate = value;
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, 2f);
        this.entityData.define(BOMB_TYPE, 0);
        this.entityData.define(EXPLOSION, 5);
        this.entityData.define(CARRIER, false);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
        this.setBombType(tag.getInt("bomb_type"));
        this.setExplosion(tag.getInt("explosion"));
        this.setCarrier(tag.getBoolean("carrier"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
        tag.putInt("bomb_type",this.getBombType());
        tag.putInt("explosion",this.getExplosion());
        tag.putBoolean("carrier",this.getCarrier());
    }

    public float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(float value){entityData.set(DAMAGE,value);}
    public int getBombType(){return entityData.get(BOMB_TYPE);}
    public void setBombType(int value){entityData.set(BOMB_TYPE,value);}
    public int getExplosion(){return entityData.get(EXPLOSION);}
    public void setExplosion(int value){entityData.set(EXPLOSION,value);}
    public boolean getCarrier(){return entityData.get(CARRIER);}
    public void setCarrier(boolean value){entityData.set(CARRIER,value);}
    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity instanceof LivingEntity living && livingEntityPredicate.test(living);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (result.getEntity() instanceof LivingEntity living){
            if (level() instanceof ServerLevel serverLevel){
                Utilities.explodeCircle(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(),getDamage(),8,entity -> {return entity instanceof LivingEntity livingEntity && livingEntityPredicate.test(livingEntity);});
                if (getBombType() == 1){
                    living.setSecondsOnFire(20);
                    Utilities.convertBlocks(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(), Blocks.FIRE.defaultBlockState());
                }if (getBombType() == 2){
                    Utilities.convertBlocks(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(), Sblocks.BILE.get().defaultBlockState());
                }
            }
        }
        discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 70 == 0){
            this.playSound(Ssounds.FALLING_BOMB.get());
        }
        if (this.getBombType() == 1){
            for (int i = 0; i < 360; i++) {
                if (i % 40 == 0) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            this.getX() , this.getY(), this.getZ() ,
                            Math.cos(i) * 0.25d, 0.25d, Math.sin(i) * 0.25d);
                }
            }
        }
        aimForTarget();
    }
    private float calculate(Entity entity,Entity entity1){
        float f = (float)(entity.getX() - entity1.getX());
        float f2 = (float)(entity.getZ() - entity1.getZ());
        return Mth.sqrt(f * f + f2 * f2);
    }
    private void aimForTarget(){
        if (target != null && this.getDeltaMovement().y<0){
            Vec3 vec3 = this.getDeltaMovement();
            Vec3 vec31 = new Vec3(this.target.getX() - this.getX(), 0.0D, this.target.getZ() - this.getZ());
            if (vec31.lengthSqr() > 1.0E-7D) {
                vec31 = vec31.normalize().scale(0.05D);
            }
            if (target != null &&  calculate(this,target) < 3.5f){
                this.setDeltaMovement(new Vec3(vec31.x,vec3.y,vec31.z));
            }else{
                this.setDeltaMovement(vec3.add(vec31.x,0 , vec31.z));
            }
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.GENERIC_EXPLODE;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (level() instanceof ServerLevel serverLevel){
            Utilities.explodeCircle(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(),getDamage(),SConfig.SERVER.calamity_bd.get(),entity -> {return entity instanceof LivingEntity livingEntity && livingEntityPredicate.test(livingEntity);});
            if (getBombType() == 1){
                Utilities.convertBlocks(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(), Blocks.FIRE.defaultBlockState());
            }if (getBombType() == 2){
                Utilities.convertBlocks(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(), Sblocks.BILE.get().defaultBlockState());
            }if(getBombType() == 3){
                summonAcid(this.getX(),this.getY()-(getExplosion()-2),this.getZ(),getExplosion());
            }if(getBombType() == 4){
                NukeEntity nukeEntity = new NukeEntity(Sentities.NUKE.get(), level());
                nukeEntity.setInitRange(1);
                nukeEntity.setRange((float) (SConfig.SERVER.nuke_range.get()*1f));
                nukeEntity.setInitDuration(0);
                nukeEntity.setDuration(SConfig.SERVER.nuke_time.get());
                nukeEntity.setDamage((float) (SConfig.SERVER.nuke_damage.get()*1f));
                nukeEntity.livingEntityPredicate = livingEntityPredicate;
                nukeEntity.setPos(result.getBlockPos().getX(),result.getBlockPos().getY()-getExplosion()+1,result.getBlockPos().getZ());
                level().addFreshEntity(nukeEntity);
            }
            if (this.getCarrier()){
                SummonInfected(serverLevel);
            }
            this.playSound(SoundEvents.GENERIC_EXPLODE);
        }
        discard();
    }
    public enum BombType{
        BASIC(0),
        FLAME(1),
        BILE(2),
        ACID(3),
        NUCLEAR(4);
        private final int value;
        BombType(int value1){
            value = value1;
        }
        public int getValue() {
            return value;
        }
    }
    private void summonAcid(double x,double y, double z,int range){
        AreaEffectCloud cloud = new AreaEffectCloud(this.level(),x,y,z);
        cloud.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),300,1));
        cloud.setRadius((float) range);
        level().addFreshEntity(cloud);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (accessor.equals(CARRIER)){
            this.refreshDimensions();
        }
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return this.getCarrier() ? super.getDimensions(pose).scale(2) : super.getDimensions(pose);
    }

    private void SummonInfected(ServerLevel serverLevel){
        List<? extends String> values = SConfig.SERVER.howit_summmons.get();
        int randomIndex = this.random.nextInt(values.size());
        ResourceLocation randomElement1 = new ResourceLocation(values.get(randomIndex));
        EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
        Mob waveentity = (Mob) randomElement.create(this.level());
        if (waveentity != null){
            waveentity.setPos(this.getX(), this.getY(), this.getZ());
            waveentity.finalizeSpawn(serverLevel, this.level().getCurrentDifficultyAt(new BlockPos((int) this.getX(),(int)  this.getY(),(int)  this.getZ())), MobSpawnType.NATURAL, null, null);
            serverLevel.addFreshEntity(waveentity);
        }
    }
}
