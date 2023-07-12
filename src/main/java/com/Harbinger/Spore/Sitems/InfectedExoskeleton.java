package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class InfectedExoskeleton extends ArmorItem {


    public InfectedExoskeleton(Type slot, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_durability.get(), SConfig.SERVER.pants_durability.get(), SConfig.SERVER.chestplate_durability.get(), SConfig.SERVER.helmet_durability.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_protection.get(), SConfig.SERVER.pants_protection.get(), SConfig.SERVER.chestplate_protection.get(), SConfig.SERVER.helmet_protection.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 18;
            }

            @Override
            public SoundEvent getEquipSound() {
                return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }

            @Override
            public String getName() {
                return "Living";
            }

            @Override
            public float getToughness() {
                return SConfig.SERVER.armor_toughness.get();
            }

            @Override
            public float getKnockbackResistance() {
                return SConfig.SERVER.knockback_resistance.get() /10F;
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
        if ((entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.INF_BOOTS.get())
                && (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Sitems.INF_PANTS.get())
                && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.INF_CHEST.get())
                && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.INF_HELMET.get())) {
            if (!entity.hasEffect(Seffects.SYMBIOSIS.get())){
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }
    }
}
