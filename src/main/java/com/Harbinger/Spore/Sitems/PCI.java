package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.AnimationTrackers.PCIAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class PCI extends BaseItem2 implements CustomModelArmorData,Vanishable {
    protected final UUID BONUS_DAMAGE_MODIFIER_UUID = UUID.fromString("035e66d6-5a74-402f-b64c-e61432ec39ba");
    protected final UUID BONUS_REACH_MODIFIER_UUID = UUID.fromString("d8c35ba5-f440-4335-92b2-3c8b1b703706");
    protected final UUID ATTACK_SPEED_MODIFIER_UUID = UUID.fromString("61bb4d9f-d2ea-4aa3-9468-9dd25a47bca1");
    private static final String CHARGE = "charge";
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/pci.png");
    private static final int RELOAD_TICKS = 60;

    public PCI() {
        super(new Properties().stacksTo(1).durability(SConfig.SERVER.pci_durability.get()));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE,new AttributeModifier(BONUS_DAMAGE_MODIFIER_UUID,"Tool modifier",SConfig.SERVER.pci_damage.get()-1, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",2, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER_UUID, "Delay modifier", -4.0, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? builder.build() : ImmutableMultimap.of();
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }

    public void setCharge(ItemStack stack, int value) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt(CHARGE, value);
    }

    public int getCharge(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getInt(CHARGE);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (entity.level().isClientSide && entity instanceof LocalPlayer player && !player.getCooldowns().isOnCooldown(this)) {
            PCIAnimationTracker.trigger(player);
        }
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player && player.getCooldowns().isOnCooldown(this)){
            return false;
        }
        if (getCharge(stack) > 0){
            if (target instanceof Infected infected && infected.getLinked()){infected.setLinked(false);}
        }
        if (attacker instanceof Player player){
            playSound(player);
        }
        stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(attacker.getUsedItemHand()));
        return true;
    }
    public void playSound(Player player){
        player.playNotifySound(Ssounds.PCI_INJECT.get(), SoundSource.AMBIENT,1f,1f);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (getCharge(stack) < SConfig.SERVER.pci_max_charge.get()/2){
            lookForAmmo(player,stack);
        }
        return super.use(level, player, hand);
    }

    private boolean lookForAmmo(Player player, ItemStack itemStack) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.getItem() == Sitems.ICE_CANISTER.get() && stack.getCount() > 0) {
                stack.shrink(1);
                setCharge(itemStack, SConfig.SERVER.pci_max_charge.get());
                player.getCooldowns().addCooldown(this,RELOAD_TICKS);
                player.playNotifySound(Ssounds.CDU_INSERT.get(), SoundSource.AMBIENT,1f,1f);
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(stack, p_41422_, components, p_41424_);
        components.add(Component.translatable("pci.line.normal").withStyle(ChatFormatting.BLUE));
        components.add(Component.literal(getCharge(stack)+"/"+SConfig.SERVER.pci_max_charge.get()).withStyle(ChatFormatting.DARK_BLUE));
    }
}
