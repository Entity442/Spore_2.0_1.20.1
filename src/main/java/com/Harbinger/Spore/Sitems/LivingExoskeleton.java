package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class LivingExoskeleton extends ArmorItem {


    public LivingExoskeleton(Type slot, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_durability2.get(), SConfig.SERVER.pants_durability2.get(), SConfig.SERVER.chestplate_durability2.get(), SConfig.SERVER.helmet_durability2.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_protection2.get(), SConfig.SERVER.pants_protection2.get(), SConfig.SERVER.chestplate_protection2.get(), SConfig.SERVER.helmet_protection2.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 18;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_LEATHER;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }

            @Override
            public String getName() {
                return "Flesh";
            }

            @Override
            public float getToughness() {
                return SConfig.SERVER.armor_toughness2.get();
            }

            @Override
            public float getKnockbackResistance() {
                return SConfig.SERVER.knockback_resistance2.get() /10F;
            }
        } , slot,properties);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }



    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        this.geteffect(player);
        super.onArmorTick(stack, level, player);
    }

    public void geteffect(LivingEntity entity) {
        if (!entity.hasEffect(Seffects.SYMBIOSIS.get())){
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.LIVING_BOOTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Sitems.LIVING_PANTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.LIVING_CHEST.get())
                    && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.LIVING_HELMET.get())) {
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }

    }
}
