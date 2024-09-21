package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class InfectedPickaxe extends PickaxeItem {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public InfectedPickaxe() {
        super(new Tier() {
            public int getUses() {
                return SConfig.SERVER.inf_pickaxe_durability.get();
            }

            public float getSpeed() {
                return 5;
            }

            public float getAttackDamageBonus() {return  0;}
            public int getLevel() {
                return 4;}
            public int getEnchantmentValue() {
                return 3;}

            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }}, 3, -3f, new Item.Properties());
        UUID BONUS_REACH_MODIFIER_UUID = UUID.fromString("30a9271c-d6b2-4651-b088-800acc43f282");
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", SConfig.SERVER.inf_pickaxe_damage.get() -1, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3F, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",2f, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.SHARPNESS, Enchantments.FIRE_ASPECT, Enchantments.MOB_LOOTING).contains(enchantment);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        if (player instanceof ServerPlayer serverPlayer)
        lookForOres(pos,level,serverPlayer);
        return super.useOn(context);
    }
    private void lookForOres(BlockPos blockPos, Level level, ServerPlayer player){
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 35, 35, 35);
        BlockState state = null;
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            if (level.getBlockState(blockpos).is(TagKey.create(Registries.BLOCK,new ResourceLocation("forge:ores")))){
                if (player.getRandom().nextFloat() < 0.3f){
                    state = level.getBlockState(blockpos);
                    break;
                }
            }
        }
        if (state == null){
            player.displayClientMessage(Component.translatable("inf_pickaxe_no_ores"),true);
        }else {
            Component component = Component.translatable(state.getBlock().getDescriptionId());
            Component component1 = Component.translatable("inf_pickaxe_found_ores");
            String string = component1.getString() + component.getString();
            player.displayClientMessage(Component.literal(string),true);
        }
        player.getCooldowns().addCooldown(this,40);
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
