package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.AnimationTrackers.SGAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.SGReloadAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sentities.Projectile.SyringeProjectile;
import com.Harbinger.Spore.Sitems.Agents.ArmorSyringe;
import com.Harbinger.Spore.Sitems.Agents.WeaponSyringe;
import com.google.common.collect.ImmutableSet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.core.NonNullList;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SyringeGun extends BaseItem2 implements CustomModelArmorData, Vanishable {
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun.png");
    public String DATA = "data";
    private final NonNullList<ItemStack> magazine = NonNullList.withSize(4, ItemStack.EMPTY);
    private final NonNullList<Integer> clip = NonNullList.withSize(4, 0);

    public static final List<Item> AMMO = List.of(
            Sitems.SYRINGE.get(),
            Sitems.VAMPIRIC_SYRINGE.get(),
            Sitems.CALCIFIED_SYRINGE.get(),
            Sitems.BEZERK_SYRINGE.get(),
            Sitems.TOXIC_SYRINGE.get(),
            Sitems.ROTTEN_SYRINGE.get(),
            Sitems.REINFORCED_SYRINGE.get(),
            Sitems.SKELETAL_SYRINGE.get(),
            Sitems.DROWNED_SYRINGE.get(),
            Sitems.CHARRED_SYRINGE.get()
    );

    public SyringeGun() {
        super(new Properties().stacksTo(1).durability(SConfig.SERVER.syringe_durability.get()));
    }

    public List<Integer> getClip(ItemStack stack) {
        loadFromNBT(stack);
        return clip;
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    private boolean isValidAmmo(ItemStack stack) {
        return !stack.isEmpty() && AMMO.contains(stack.getItem());
    }

    public void setMagazine(ItemStack stack, int slot) {
        if (isValidAmmo(stack)) {
            magazine.set(slot, stack.copy());
            clip.set(slot, encodeColors(stack));
        }
    }

    public void removeMagazine(int slot) {
        magazine.set(slot, ItemStack.EMPTY);
        clip.set(slot, 0);
    }

    private int encodeColors(ItemStack stack) {
        if (stack.isEmpty()) return 0;
        if (stack.getItem().equals(Sitems.SYRINGE.get())) return -1;
        if (stack.getItem() instanceof WeaponSyringe w) return w.getColor();
        if (stack.getItem() instanceof ArmorSyringe a) return a.getColor();
        return 0;
    }

    private void saveToNBT(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTag();

        ListTag magTag = new ListTag();
        for (ItemStack ammo : magazine) {
            CompoundTag entry = new CompoundTag();
            if (!ammo.isEmpty()) ammo.save(entry);
            magTag.add(entry);
        }
        tag.put("Magazines", magTag);

        ListTag clipTag = new ListTag();
        for (Integer c : clip) {
            clipTag.add(IntTag.valueOf(c));
        }
        tag.put("Clip", clipTag);
    }

    private void loadFromNBT(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTag();

        if (tag.contains("Magazines", 9)) {
            ListTag magTag = tag.getList("Magazines", 10);
            for (int i = 0; i < 4; i++) {
                if (i < magTag.size()) {
                    magazine.set(i, ItemStack.of(magTag.getCompound(i)));
                }
            }
        }

        if (tag.contains("Clip", 9)) {
            ListTag clipTag = tag.getList("Clip", 3);
            for (int i = 0; i < 4; i++) {
                if (i < clipTag.size()) {
                    clip.set(i, ((IntTag) clipTag.get(i)).getAsInt());
                }
            }
        }
    }
    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack itemStack) {
        return itemStack.is(Sitems.CIRCUIT_BOARD.get());
    }
    private int getCurrentChamber(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        return tag.getInt("CurrentChamber");
    }

    private void setCurrentChamber(ItemStack gun, int value) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        tag.putInt("CurrentChamber", value);
    }

    private int getReloadTimer(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        return tag.getInt("ReloadTimer");
    }

    private void setReloadTimer(ItemStack gun, int value) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        tag.putInt("ReloadTimer", value);
    }

    private boolean isReloading(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        return tag.getBoolean("Reloading");
    }

    private void setReloading(ItemStack gun, boolean value) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        tag.putBoolean("Reloading", value);
    }

    private int getShootCooldown(ItemStack gun) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        return tag.getInt("ShootCooldown");
    }

    private void setShootCooldown(ItemStack gun, int value) {
        CompoundTag tag = gun.getOrCreateTagElement(DATA);
        tag.putInt("ShootCooldown", value);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!(entity instanceof Player player)) return;

        loadFromNBT(stack);

        boolean inHand = player.getMainHandItem() == stack || player.getOffhandItem() == stack;

        if (inHand && isReloading(stack)) {
            if (getReloadTimer(stack) > 0) setReloadTimer(stack, getReloadTimer(stack) - 1);
            else {
                player.playNotifySound(SoundEvents.CROSSBOW_LOADING_START, SoundSource.AMBIENT,1,1);
                reloadOne(stack, player);
                setReloadTimer(stack, 10);
            }
        }

        if (getShootCooldown(stack) > 0){
            if (getShootCooldown(stack) == 5 && level.isClientSide){
                int chamber = getCurrentChamber(stack);
                SGReloadAnimationTracker.triggerRotationToChamber(player,chamber,10);
            }
            setShootCooldown(stack, getShootCooldown(stack) - 1);
        }
        saveToNBT(stack);
    }

    public void startReload(ItemStack stack) {
        setReloading(stack, true);
        setReloadTimer(stack, 10);
    }

    private void reloadOne(ItemStack gun, Player player) {
        for (int i = 0; i < magazine.size(); i++) {
            if (magazine.get(i).isEmpty()) {
                ItemStack ammo = findAmmo(player);
                if (!ammo.isEmpty()) {
                    if (player.level().isClientSide) {
                        SGReloadAnimationTracker.triggerRotationToChamber(player,i,10);
                        player.playNotifySound(SoundEvents.CROSSBOW_LOADING_START, SoundSource.AMBIENT, 1, 1);
                    } else {
                        ItemStack taken = ammo.split(1);
                        setMagazine(taken, i);
                    }
                } else {
                    setReloading(gun, false);
                }
                return;
            }
        }
        setReloading(gun, false);
    }


    private ItemStack findAmmo(Player player) {
        if (player.getAbilities().instabuild)
            return new ItemStack(Sitems.SYRINGE.get());
        ItemStack offhand = player.getOffhandItem();
        if (isValidAmmo(offhand)) return offhand;
        for (ItemStack invStack : player.getInventory().items) {
            if (isValidAmmo(invStack)) return invStack;
        }
        return ItemStack.EMPTY;
    }

    public boolean shoot(ItemStack gun, Player player, Level level,InteractionHand hand) {
        if (getShootCooldown(gun) > 0) return false;
        int chamber = getCurrentChamber(gun);
        ItemStack ammo = magazine.get(chamber);
        if (!ammo.isEmpty()) {
            if (!level.isClientSide) {
                float enchantment = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS,gun);
                float power = enchantment > 0 ? enchantment * 0.5f + 1f : 0;
                SyringeProjectile arrow = new SyringeProjectile(level,player,SConfig.SERVER.syringe_damage.get() + power,ammo);
                Vec3 vec3 = (new Vec3(0.0D, 0.0D, hand == InteractionHand.MAIN_HAND ? 0.2 : -0.2)).yRot(-player.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
                arrow.moveTo(player.position().add(vec3.x,1.4,vec3.z));
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(arrow);
            }else {
                SGAnimationTracker.trigger(player);
            }
            removeMagazine(chamber);
            setCurrentChamber(gun, (chamber + 1) % 4);
            setShootCooldown(gun, 10);
            player.playNotifySound(SoundEvents.DISPENSER_DISPENSE, SoundSource.AMBIENT,1,1);
            return true;
        }else {
            player.playNotifySound(SoundEvents.LEVER_CLICK, SoundSource.AMBIENT,1,1);
            setCurrentChamber(gun, (chamber + 1) % 4);
            triggerMagazineRotation(chamber, player);
        }
        return false;
    }
    private void triggerMagazineRotation(int chamber, Player player) {
        if (player.level().isClientSide) {
            SGReloadAnimationTracker.triggerRotationToChamber(player,chamber,10);
        }
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack gun = player.getItemInHand(hand);
        player.startUsingItem(hand);
        loadFromNBT(gun);
        if (player.isShiftKeyDown()) {
            if (!isReloading(gun)) startReload(gun);
            saveToNBT(gun);
            return InteractionResultHolder.success(gun);
        }
        if (getShootCooldown(gun) > 0){
            return InteractionResultHolder.fail(gun);
        }
        if (shoot(gun, player, level,hand)) {
            gun.hurt(1,player.getRandom(),null);
            saveToNBT(gun);
            return InteractionResultHolder.success(gun);
        }
        startReload(gun);
        saveToNBT(gun);
        return InteractionResultHolder.consume(gun);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.POWER_ARROWS).contains(enchantment);
    }
}
