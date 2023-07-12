package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Sparticles;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.PlayMessages;

public class ThrownTumor extends ThrowableItemProjectile {
    public ThrownTumor(EntityType<? extends ThrownTumor> type, Level level) {
        super(type, level);
    }
    public MobEffect mobEffect;
    public int duration = 600;
    public int potion_level = 1;
    public Level.ExplosionInteraction explode = Level.ExplosionInteraction.NONE;

    public ThrownTumor(Level level, LivingEntity entity) {
        super(Sentities.THROWN_TUMOR.get(), entity, level);
    }

    public ThrownTumor(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(Sentities.THROWN_TUMOR.get(), level);
    }

    @Override
    protected Item getDefaultItem() {
        return Sitems.TUMOR.get();
    }

    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    public void setMobEffect(MobEffect effect){
        this.mobEffect = effect;
    }
    public void setExplode(Level.ExplosionInteraction value){
        this.explode = value;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide){
        this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float)2, explode);
        if (mobEffect != null){
            AreaEffectCloud cloud = EntityType.AREA_EFFECT_CLOUD.create(level());
            assert cloud != null;
            cloud.addEffect(new MobEffectInstance(mobEffect,duration,potion_level));
            cloud.setDuration(160);
            cloud.setRadius(2f);
            cloud.moveTo(this.getX(), this.getY(), this.getZ());
            level().addFreshEntity(cloud);
        }
        this.discard();
        }
    }


}
