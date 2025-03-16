package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Predicate;

public class NukeEntity extends Entity {
    private static final EntityDataAccessor<Float> INIT_RANGE = SynchedEntityData.defineId(NukeEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> RANGE = SynchedEntityData.defineId(NukeEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> INIT_DURATION = SynchedEntityData.defineId(NukeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(NukeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(NukeEntity.class, EntityDataSerializers.FLOAT);
    public Predicate<LivingEntity> livingEntityPredicate = (entity) -> {return true;};

    public NukeEntity(EntityType<?> type, Level level) {
        super(type, level);
        setInitRange(1f);
        setRange(6f);
        setInitDuration(0);
        setDuration(600);
        setDamage(10f);
    }

    public void setInitRange(float value){
        entityData.set(INIT_RANGE,value);
    }
    public void setRange(float value){
        entityData.set(RANGE,value);
    }
    public void setInitDuration(int value){
        entityData.set(INIT_DURATION,value);
    }
    public void setDuration(int value){
        entityData.set(DURATION,value);
    }
     public void setDamage(float value){
        entityData.set(DAMAGE,value);
    }
    public float getInitRange(){return entityData.get(INIT_RANGE);}
    public float getRange(){return entityData.get(RANGE);}
    public int getInitDuration(){return entityData.get(INIT_DURATION);}
    public int getDuration(){return entityData.get(DURATION);}
    public float getDamage(){return entityData.get(DAMAGE);}


    @Override
    protected void defineSynchedData() {
        entityData.define(INIT_RANGE,1f);
        entityData.define(RANGE,6f);
        entityData.define(INIT_DURATION,0);
        entityData.define(DURATION,600);
        entityData.define(DAMAGE,10f);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        setInitRange(compoundTag.getFloat("init_range"));
        setRange(compoundTag.getFloat("range"));
        setInitDuration(compoundTag.getInt("init_duration"));
        setDuration(compoundTag.getInt("duration"));
          setDamage(compoundTag.getFloat("damage"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putFloat("init_range",this.getInitRange());
        compoundTag.putFloat("range",this.getRange());
        compoundTag.putInt("init_duration",this.getInitDuration());
        compoundTag.putInt("duration",this.getDuration());
        compoundTag.putFloat("damage", this.getDamage());
    }
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    public void tick() {
        if (!level().isClientSide){
            calculateRange();
            if (getInitDuration() >= getDuration()){
                discard();
            }
            if (tickCount % 10 == 0){
                hurtEntities();
                damageAround(level(),getInitRange()+4,this.getOnPos());
            }
            if (getInitDuration() == 1){
                playNukeSound();
            }
        }
        super.tick();
    }

    private void calculateRange() {
        if (getDuration() > getInitDuration()) {
            setInitDuration(getInitDuration() + 1);
        }
        int remainingDuration = getDuration() - getInitDuration();
        if (remainingDuration > 0) {
            setInitRange(getInitRange() + (getRange() / remainingDuration));
        } else {
            setInitRange(getInitRange());
        }
    }
    public void hurtEntities(){
        AABB aabb = this.getBoundingBox().inflate(getInitRange()+5);
        List<Entity> entities = level().getEntities(this,aabb,entity -> {return entity instanceof LivingEntity;});
        for (Entity entity :entities){
            if (entity instanceof LivingEntity living && livingEntityPredicate.test(living)){
                living.setSecondsOnFire(10);
                addEffect(living);
                living.hurt(damageSources().inFire(),this.getDamage());
                living.hurtTime = 10;
                living.invulnerableTime = 10;
            }
        }
    }
    public void addEffect(LivingEntity living){
        if (ModList.get().isLoaded("alexscaves")){
            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("alexscaves:irradiated"));
            if (effect != null)
                living.addEffect(new MobEffectInstance(effect,1200,1));
        }else{
            living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,1200,1));
        }
    }
    public void playNukeSound(){
        AABB aabb = this.getBoundingBox().inflate(32);
        List<Entity> players = level().getEntities(this,aabb,entity -> {return  entity instanceof ServerPlayer;});
        for (Entity entity : players){
            if (entity instanceof ServerPlayer serverPlayer){
                serverPlayer.playNotifySound(Ssounds.NUKE.get(), SoundSource.AMBIENT,1f,1f);
            }
        }
    }
    private void damageAround(Level level, double range, BlockPos pos) {
        for (int i = 0; i <= 2 * range; ++i) {
            for (int j = 0; j <= 2 * range; ++j) {
                for (int k = 0; k <= 2 * range; ++k) {
                    double distance = Mth.sqrt((float) ((i - range) * (i - range) + (j - range) * (j - range) + (k - range) * (k - range)));
                    if (distance < range + 0.5) {
                        BlockPos blockpos = pos.offset(i - (int) range, j - (int) range, k - (int) range);
                        BlockState blockstate = level.getBlockState(blockpos);

                        if (blockstate.is(Blocks.WATER)) {
                            level.setBlockAndUpdate(blockpos, Blocks.AIR.defaultBlockState());
                        } else {
                            if (Math.random() < 0.1 && blockstate.isSolidRender(level, blockpos) && level.getBlockState(blockpos.above()).isAir()) {
                                level.setBlock(blockpos.above(), Sblocks.ACID.get().defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
        }
    }
}
