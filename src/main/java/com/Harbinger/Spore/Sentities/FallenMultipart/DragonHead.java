package com.Harbinger.Spore.Sentities.FallenMultipart;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.FallenMultipartEntity;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkDetashedNecks;
import com.Harbinger.Spore.Sentities.MovementControls.WaterXlandMovement;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.DragonHeadVariants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

import java.util.List;

public class DragonHead extends FallenMultipartEntity implements VariantKeeper {
    public static final int SEGMENTS = 6;
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(DragonHead.class, EntityDataSerializers.INT);
    private final IkDetashedNecks neck;
    public DragonHead(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.navigation = new HybridPathNavigation(this,level);
        this.moveControl = new WaterXlandMovement(this);
        neck = new IkDetashedNecks(this,SEGMENTS,new Vec3(-0.5,0.5,0),new Vec3(-6,0.5,0));
        this.setMaxUpStep(1F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.neck.getHitboxes().length + 1) + 1);
    }
    @Override
    public void setId(int va) {
        super.setId(va);
        for (int i = 0; i < this.neck.getHitboxes().length; i++)
            this.neck.getHitboxes()[i].setId(va + i + 1);
    }
    public IkDetashedNecks getNeck(){
        return neck;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void tick() {
        super.tick();
        neck.applyIK();
        if (tickCount % 50 == 0 && neck.getSitPosition() != null){
            neck.setSitPosition(null);
        }
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.neck.getHitboxes();
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if (true) return;
        DragonHeadMultipart[] calamityMultiparts = this.neck.getHitboxes();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + packet.getId());
        }

    }


    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.gazen_tongue_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.verfa_hp.get()*0.2) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.verfa_armor.get()*0.2) * SConfig.SERVER.global_armor.get())
                .add(Attributes.ATTACK_DAMAGE, (SConfig.SERVER.verfa_damage.get()*0.5) * SConfig.SERVER.global_damage.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.15);
    }

    public DragonHeadVariants getVariant() {
        return DragonHeadVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(2,new CustomMeleeAttackGoal(this,1.1,true));
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > DragonHeadVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return DragonHeadVariants.values().length;
    }

    public void setVariant(DragonHeadVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    public static class DragonHeadMultipart extends PartEntity<DragonHead>{
       public final DragonHead parentMob;
       public final String name;
       protected final EntityDimensions size;
       public DragonHeadMultipart(DragonHead parent, String name) {
           super(parent);
           this.size = EntityDimensions.scalable(1, 1);
           this.refreshDimensions();
           this.parentMob = parent;
           this.name = name;
       }
       public boolean isPickable() {
           return true;
       }

       public boolean is(Entity entity) {
           return this == entity || this.parentMob == entity;
       }

       public Packet<ClientGamePacketListener> getAddEntityPacket() {
           throw new UnsupportedOperationException();
       }

        @Override
        public boolean canBeCollidedWith() {
            return false;
        }

        public EntityDimensions getDimensions(Pose p_31023_) {
           return this.size;
       }

       public boolean shouldBeSaved() {
           return false;
       }

       @Override
       protected void defineSynchedData() {

       }

       @Override
       protected void readAdditionalSaveData(CompoundTag compoundTag) {

       }

       @Override
       protected void addAdditionalSaveData(CompoundTag compoundTag) {

       }

       public boolean hurt(DamageSource source, float amount) {
           if (source.getEntity() == this.parentMob){
               return false;
           }
           return !this.isInvulnerableTo(source) && this.parentMob.hurt(source, amount);
       }
   }
}
