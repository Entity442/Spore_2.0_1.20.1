package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.Variants.BraureiVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class CorpseEntity extends Entity {
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(CorpseEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> OWNER_ADA = SynchedEntityData.defineId(CorpseEntity.class, EntityDataSerializers.BOOLEAN);
    private final SimpleContainer inventory = new SimpleContainer(20);
    public CorpseEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(TYPE, 0);
        this.entityData.define(OWNER_ADA,false);
    }
    public SimpleContainer getInventory(){
        return inventory;
    }
    public void addToInventory(ItemStack stack){
        this.inventory.addItem(stack);
    }
    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        setCorpseType(compoundTag.getInt("corpse_type"));
        setOwnerAda(compoundTag.getBoolean("owner_ada"));
        ListTag listtag = compoundTag.getList("Items",10);

        for (int i = 0; i < listtag.size(); i++) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = (compoundtag.getByte("Slot") & 255) % this.inventory.getContainerSize();
            this.inventory.setItem(j, ItemStack.of(compoundtag));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("corpse_type",getCorpseType());
        compoundTag.putBoolean("owner_ada",getOwnerAda());
        ListTag listtag = new ListTag();
        for (int i = 0; i < this.inventory.getContainerSize(); i++) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte)i);
                listtag.add(itemstack.save(compoundtag));
            }
        }
        compoundTag.put("Items", listtag);
    }

    public void setCorpseType(int e){
        entityData.set(TYPE,e);
    }
    public int getCorpseType(){
        return entityData.get(TYPE);
    }
    public void setOwnerAda(boolean e){
        entityData.set(OWNER_ADA,e);
    }
    public boolean getOwnerAda(){
        return entityData.get(OWNER_ADA);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 hitVec, InteractionHand hand) {
        if (!level().isClientSide) {
            if (player.isShiftKeyDown()){
                inventory.addItem(new ItemStack(Items.APPLE));
                return InteractionResult.SUCCESS;
            }
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                ItemStack stack = inventory.getItem(i);
                if (!stack.isEmpty()) {
                    summonItem(stack);
                    inventory.setItem(i, ItemStack.EMPTY);
                }
            }

            if (inventory.isEmpty()) {
                this.discard();
            }
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public boolean isPickable() {
        return true;
    }
    public void summonItem(ItemStack stack){
        ItemEntity entity = new ItemEntity(level(),this.getX(),this.getY(),this.getZ(),stack);
        level().addFreshEntity(entity);
    }

    @Override
    public boolean mayInteract(Level p_146843_, BlockPos p_146844_) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        // Apply gravity
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D)); // gravity
        }

        // Move entity using current velocity
        this.move(MoverType.SELF, this.getDeltaMovement());

        // Update rotation to match motion (only while moving)
        if (!this.onGround() && this.getDeltaMovement().lengthSqr() > 0.0001) {
            Vec3 motion = this.getDeltaMovement();
            double horizSpeed = Math.sqrt(motion.x * motion.x + motion.z * motion.z);

            this.setYRot((float)(Mth.atan2(motion.x, motion.z) * (180F / Math.PI)));
            this.setXRot((float)(Mth.atan2(motion.y, horizSpeed) * (180F / Math.PI)));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        // Stop movement when grounded
        if (this.onGround()) {
            Vec3 motion = this.getDeltaMovement();
            if (motion.lengthSqr() > 0.01) {
                this.setDeltaMovement(motion.multiply(0.5, -0.5, 0.5)); // bounce & dampen
            } else {
                this.setDeltaMovement(Vec3.ZERO); // full stop
            }
        }
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }
    @Override
    public boolean shouldBeSaved() {
        return true;
    }

    public HitboxesForParts getVariant() {
        return HitboxesForParts.byId(this.getCorpseType() & 255);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (TYPE.equals(key)) {
            this.refreshDimensions();
            this.setBoundingBox(this.getDimensions(this.getPose()).makeBoundingBox(this.position()));
        }
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        HitboxesForParts parts = getVariant();
        return EntityDimensions.scalable(parts.getWidth(), parts.getHeight());
    }
}
