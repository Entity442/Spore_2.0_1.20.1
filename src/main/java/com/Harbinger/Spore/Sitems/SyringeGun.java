package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.Agents.ArmorSyringe;
import com.Harbinger.Spore.Sitems.Agents.WeaponSyringe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.core.NonNullList;

import java.util.List;

public class SyringeGun extends BaseItem2 implements CustomModelArmorData {
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun.png");

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
        super(new Properties().stacksTo(1));
    }

    public List<Integer> getClip() {
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

    private int getCurrentChamber(ItemStack gun) {
        return gun.getOrCreateTag().getInt("CurrentChamber");
    }

    private void setCurrentChamber(ItemStack gun, int value) {
        gun.getOrCreateTag().putInt("CurrentChamber", value);
    }

    private int getReloadTimer(ItemStack gun) {
        return gun.getOrCreateTag().getInt("ReloadTimer");
    }

    private void setReloadTimer(ItemStack gun, int value) {
        gun.getOrCreateTag().putInt("ReloadTimer", value);
    }

    private boolean isReloading(ItemStack gun) {
        return gun.getOrCreateTag().getBoolean("Reloading");
    }

    private void setReloading(ItemStack gun, boolean value) {
        gun.getOrCreateTag().putBoolean("Reloading", value);
    }

    private int getShootCooldown(ItemStack gun) {
        return gun.getOrCreateTag().getInt("ShootCooldown");
    }

    private void setShootCooldown(ItemStack gun, int value) {
        gun.getOrCreateTag().putInt("ShootCooldown", value);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (level.isClientSide || !(entity instanceof Player player)) return;

        loadFromNBT(stack);

        boolean inHand = player.getMainHandItem() == stack || player.getOffhandItem() == stack;

        if (inHand && isReloading(stack)) {
            if (getReloadTimer(stack) > 0) setReloadTimer(stack, getReloadTimer(stack) - 1);
            else {
                reloadOne(stack, player);
                setReloadTimer(stack, 10);
            }
        }

        if (getShootCooldown(stack) > 0) setShootCooldown(stack, getShootCooldown(stack) - 1);

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
                    ItemStack taken = ammo.split(1);
                    setMagazine(taken, i);
                } else {
                    setReloading(gun, false);
                }
                return;
            }
        }
        setReloading(gun, false);
    }

    private ItemStack findAmmo(Player player) {
        ItemStack offhand = player.getOffhandItem();
        if (isValidAmmo(offhand)) return offhand;
        for (ItemStack invStack : player.getInventory().items) {
            if (isValidAmmo(invStack)) return invStack;
        }
        return ItemStack.EMPTY;
    }

    public boolean shoot(ItemStack gun, Player player, Level level) {
        if (getShootCooldown(gun) > 0) return false;
        int chamber = getCurrentChamber(gun);
        ItemStack ammo = magazine.get(chamber);
        if (!ammo.isEmpty()) {
            if (!level.isClientSide) {
                Arrow arrow = new Arrow(level, player);
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(arrow);
            }
            removeMagazine(chamber);
            setCurrentChamber(gun, (chamber + 1) % 4);
            setShootCooldown(gun, 10);
            return true;
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack gun = player.getItemInHand(hand);
        loadFromNBT(gun);
        if (player.isShiftKeyDown()) {
            if (!isReloading(gun)) startReload(gun);
            saveToNBT(gun);
            return InteractionResultHolder.success(gun);
        }
        if (getShootCooldown(gun) > 0) return InteractionResultHolder.fail(gun);
        if (shoot(gun, player, level)) {
            saveToNBT(gun);
            return InteractionResultHolder.success(gun);
        }
        startReload(gun);
        saveToNBT(gun);
        return InteractionResultHolder.consume(gun);
    }
}
