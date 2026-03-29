package com.Harbinger.Spore.Sitems.Guns;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Package.SporeGunFireSyncPacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import com.Harbinger.Spore.Sitems.BaseItem;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.Harbinger.Spore.Sitems.GunHeldItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractSporeGun extends BaseItem implements GunHeldItem, SporeWeaponData {
    public static final String SHOOT_DELAY = "ShootDelay";
    public static final String RELOAD_DELAY = "ReloadDelay";
    public static final String CLIP_AMMO = "ClipAmmo";
    public static final String STOMACH = "Stomach";
    public AbstractSporeGun(int durability) {
        super(new Properties().stacksTo(1).durability(durability));
        Sitems.TINTABLE_ITEMS.add(this);
    }
    public abstract boolean needsToReload();
    public abstract int getDefaultTimeBeforeReload();
    public abstract int getTimeBeforeChangingClip(ItemStack stack);
    public abstract int timeBeforeStomachContentsConvertIntoAmmo();
    public abstract int getClipSize();
    public abstract Item getAmmoItem();
    public int getAmmoUsage(){return 1;}
    public int getBaseAmmoShotRequirement(){return 1;}


    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return getLuck(stack);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack gun = player.getItemInHand(hand);

        int ammo = getInt(gun, "ClipAmmo");

        if (needsToReload() && ammo < getClipSize()) {
            for (ItemStack invStack : player.getInventory().items) {
                if (getAmmoItem().equals(invStack.getItem())) {

                    if (level.isClientSide) {
                        triggerReloadAnimation(player);
                        player.playNotifySound(Ssounds.BIOGUN_RELOAD.get(), SoundSource.MASTER, 1, 1);
                    } else {
                        player.getCooldowns().addCooldown(this, getDefaultTimeBeforeReload());

                        invStack.shrink(1);

                        setInt(gun, "ClipAmmo", getClipSize());
                        setInt(gun, "ReloadDelay", getDefaultTimeBeforeReload());
                    }
                    break;
                }
            }
        }

        return super.use(level, player, hand);
    }

    public void triggerReloadAnimation(Player player){

    }
    protected static int getInt(ItemStack stack, String key) {
        return  stack.getTag() != null && stack.getTag().contains(key) ? stack.getTag().getInt(key) : 0;
    }

    protected static void setInt(ItemStack stack, String key, int value) {
        stack.getOrCreateTag().putInt(key, value);
    }

    public void playEmptyFireSounds(ServerPlayer player){
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                Ssounds.BIOGUN_NO_AMMO.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;

        int shootDelay = getInt(stack, "ShootDelay");
        if (shootDelay > 0) {
            setInt(stack, "ShootDelay", shootDelay - 1);
        }

        int reloadDelay = getInt(stack, "ReloadDelay");
        if (reloadDelay > 0) {
            setInt(stack, "ReloadDelay", reloadDelay - 1);
        }

        if (needsToReload() && getInt(stack, "ClipAmmo") < getClipSize()) {

            int tick = (int)(level.getGameTime() % timeBeforeStomachContentsConvertIntoAmmo());

            if (tick == 0) {
                int stomach = getInt(stack, "Stomach");
                int ammo = getInt(stack, "ClipAmmo");

                if (stomach > 0) {
                    int consumed = Math.min(stomach, 5);

                    setInt(stack, "Stomach", stomach - consumed);
                    setInt(stack, "ClipAmmo", ammo + 1);
                }
            }
        }
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack itemStack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        boolean shouldOverride = clickAction == ClickAction.SECONDARY
                && itemStack.getItem() == Sitems.SYRINGE.get()
                && getVariant(stack) != SporeToolsMutations.DEFAULT;

        if (shouldOverride) {
            this.setVariant(SporeToolsMutations.DEFAULT, stack);
            itemStack.shrink(1);
            player.playNotifySound(Ssounds.SYRINGE_SUCK.get(), SoundSource.AMBIENT, 1f, 1f);
        }
        if (clickAction == ClickAction.SECONDARY) {
            int current = getInt(stack, "Stomach");

            if (!needsToReload() && current >= getClipSize()) {
                return false;
            }

            if (itemStack.getFoodProperties(player) == null) {
                return false;
            }

            FoodProperties food = itemStack.getFoodProperties(player);
            if (food == null){
                return false;
            }

            int value = (int)(food.getNutrition() + (10 * food.getSaturationModifier()));

            int newValue = needsToReload()
                    ? current + value
                    : Math.min(current + value, getClipSize());

            setInt(stack, "Stomach", newValue);

            itemStack.shrink(1);

            player.playNotifySound(SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 1f, 1f);
            return true;
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal(""));
        int stomach = getInt(stack, "Stomach");
        int clip = getInt(stack, "ClipAmmo");
        if (needsToReload()) {
            tooltip.add(Component.literal(Component.translatable("spore.item.clip").getString() + clip + "/" + getClipSize()).withStyle(ChatFormatting.GOLD));
        } else {
            tooltip.add(Component.literal(Component.translatable("spore.item.biomass").getString() + stomach + "/" + getClipSize())
                    .withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        if (Screen.hasShiftDown()){
            if (needsToReload()){
                tooltip.add(Component.literal(Component.translatable("spore.item.stomach").getString() + stomach).withStyle(ChatFormatting.DARK_GREEN));
            }if (getVariant(stack) != SporeToolsMutations.DEFAULT) {
                tooltip.add(Component.literal(Component.translatable("spore.item.mutation").getString() + Component.translatable(getVariant(stack).getName()).getString()));
            }
            if (getAdditionalDamage(stack) > 0){
                tooltip.add(Component.literal(Component.translatable("spore.item.damage_increase").getString() + getAdditionalDamage(stack) + "%"));
            }if (getMaxAdditionalDurability(stack) > 0){
                tooltip.add(Component.literal(Component.translatable("spore.item.durability_increase").getString()+ getMaxAdditionalDurability(stack) + "%"));
            }if (getAdditionalDurability(stack) > 0){
                tooltip.add(Component.literal(Component.translatable("spore.item.additional_durability").getString()+ getAdditionalDurability(stack)));
            }
        }else {
            tooltip.add(Component.translatable("item.armor.normal").withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public void serverShoot(ItemStack stack, ServerPlayer player, InteractionHand hand, Vec3 vec3) {
        SporePacketHandler.sendToClient(new SporeGunFireSyncPacket(player.getId(), hand == InteractionHand.MAIN_HAND ? 0 : 1), player);
        int value = calculateDurabilityLostForMutations(1,stack);
        hurtTool(stack,player,value);
    }

    public void clientShoot(Player player, InteractionHand interactionHand) {

    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public HumanoidModel.@org.jetbrains.annotations.Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
                ItemStack stack = entityLiving.getItemInHand(hand);
                if (stack.getItem() instanceof GunHeldItem){
                    return HumanoidModel.ArmPose.CROSSBOW_HOLD;
                }
                return IClientItemExtensions.super.getArmPose(entityLiving, hand, itemStack);
            }
        });
    }
}
