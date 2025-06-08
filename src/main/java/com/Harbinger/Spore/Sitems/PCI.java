package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

public class PCI extends SwordItem implements CustomModelArmorData {
    private final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/pci.png");
    public PCI() {
        super(new Tier() {
            @Override
            public int getUses() {
                return SConfig.SERVER.reaver_durability.get();
            }

            @Override
            public float getSpeed() {
                return -1;
            }

            @Override
            public float getAttackDamageBonus() {
                return SConfig.SERVER.reaver_damage.get() -1;
            }

            @Override
            public int getLevel() {
                return 3;
            }

            @Override
            public int getEnchantmentValue() {
                return 3;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Items.IRON_INGOT);
            }
        }, 0, -1, new Properties());
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity livingEntity, LivingEntity victim) {
        return super.hurtEnemy(stack, livingEntity, victim);
    }
}
