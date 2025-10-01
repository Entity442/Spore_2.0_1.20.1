package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Recipes.EntityContainer;
import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Sitems.Agents.AbstractSyringe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Optional;

public class SyringeProjectile extends AbstractArrow {
    private ItemStack itemStack;
    public SyringeProjectile(Level level) {
        super(Sentities.THROWN_SYRINGE.get(), level);
        itemStack = new ItemStack(Sitems.SYRINGE.get());
    }
    public SyringeProjectile(Level level,LivingEntity living,float damage,ItemStack stack){
        super(Sentities.STINGER.get(), level);
        this.setOwner(living);
        this.setBaseDamage(damage);
        this.setItemStack(stack);
    }

    public void setItemStack(ItemStack stack){
        itemStack = stack;
    }
    @Override
    protected ItemStack getPickupItem() {
        return itemStack;
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Syringe", 10)) {
            this.itemStack = ItemStack.of(tag.getCompound("Syringe"));
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("Syringe", this.itemStack.save(new CompoundTag()));
    }
    public Optional<InjectionRecipe> getRecipe(Level level, Entity entity){
        EntityContainer container = new EntityContainer(entity);
        return level.getRecipeManager().getRecipeFor(InjectionRecipe.InjectionRecipeType.INSTANCE, container, level);
    }
    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity living && !level().isClientSide){
            if (itemStack.getItem().equals(Sitems.SYRINGE.get())){
                Optional<InjectionRecipe> match = this.getRecipe(level(),living);
                if (match.isPresent() && Math.random() < 0.5){
                    ItemStack stack = match.get().getResultItem(null);
                    if (stack == null){
                        return;
                    }
                    ItemEntity itemEntity = new ItemEntity(level(),entity.getX(),entity.getY(),entity.getZ(),stack);
                    level().addFreshEntity(itemEntity);
                }
                this.playSound(Ssounds.SYRINGE_SUCK.get());
            }
            if (itemStack.getItem() instanceof AbstractSyringe syringe){
                syringe.useSyringe(itemStack,living);
                this.playSound(Ssounds.SYRINGE_INJECT.get());
            }
        }
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return !entity.equals(getOwner()) && super.canHitEntity(entity);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return Ssounds.SYRINGE_INJECT.get();
    }

}
