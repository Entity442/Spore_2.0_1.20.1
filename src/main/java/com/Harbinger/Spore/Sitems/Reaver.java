package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.LootModifierWeapon;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Reaver extends SwordItem implements LootModifierWeapon {
    private final List<ComboValues> basicInfectedList;
    private final List<ComboValues> evolvedList;
    private final List<ComboValues> hyperList;
    private final List<ComboValues> organoidList;
    private final List<ComboValues> calamityList;
    public Reaver() {
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
        basicInfectedList = calculateMap(SConfig.SERVER.reaver_loot.get());
        evolvedList = calculateMap(SConfig.SERVER.reaver_loot1.get());
        hyperList = calculateMap(SConfig.SERVER.reaver_loot2.get());
        organoidList = calculateMap(SConfig.SERVER.reaver_loot3.get());
        calamityList = calculateMap(SConfig.SERVER.reaver_loot4.get());
    }

    public List<ComboValues> calculateMap(List<? extends String> list){
        List<ComboValues> values = new ArrayList<>();
        for(String string : list){
            String[] s = string.split("\\|");
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s[0]));
            int value = Integer.parseInt(s[1]);
            if (item != null && value != 0){
                ItemStack stack = new ItemStack(item);
                ComboValues comboValues = new ComboValues(stack,value);
                values.add(comboValues);
            }
        }
        return values;
    }
    public record ComboValues(ItemStack stack,Integer value){}

    @Override
    public int getLootingLevel() {
        return 3;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity livingEntity, LivingEntity victim) {
        if (livingEntity instanceof Calamity){
            return shaveLoot(stack,livingEntity,victim,getRandomFromList(calamityList));
        }
        if (livingEntity instanceof Organoid){
            return shaveLoot(stack,livingEntity,victim,getRandomFromList(organoidList));
        }
        if (livingEntity instanceof Hyper){
            return shaveLoot(stack,livingEntity,victim,getRandomFromList(hyperList));
        }
        if (livingEntity instanceof EvolvedInfected){
            return shaveLoot(stack,livingEntity,victim,getRandomFromList(evolvedList));
        }
        if (livingEntity instanceof Infected){
            return shaveLoot(stack,livingEntity,victim,getRandomFromList(basicInfectedList));
        }
        return super.hurtEnemy(stack, livingEntity, victim);
    }

    public ComboValues getRandomFromList(List<ComboValues> values){
        RandomSource source = RandomSource.create();
        return values.get(source.nextInt(values.size()));
    }

    public boolean shaveLoot(ItemStack stack, LivingEntity livingEntity, LivingEntity victim,ComboValues values){
        livingEntity.playSound(Ssounds.REAVER_REAVE.get());
        Level level = livingEntity.level();
        BlockPos pos = livingEntity.getOnPos();
        if (!level.isClientSide && values != null && Math.random() < (values.value * 0.01)){
        ItemEntity item = new ItemEntity(level,pos.getX(),pos.getY(),pos.getZ(),values.stack);
        level.addFreshEntity(item);}
        return super.hurtEnemy(stack, livingEntity, victim);
    }
}
