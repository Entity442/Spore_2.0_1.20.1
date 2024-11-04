package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Tumor extends BaseItem {
    private final TumorType type;
    public Tumor(TumorType type) {
        super(new Item.Properties().stacksTo(16));
        this.type = type;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            ThrownTumor tumor = new ThrownTumor(level, player);
            tumor.setItem(itemstack);
            tumor.setType(type.getType());
            tumor.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(tumor);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public enum TumorType{
        REGULAR(0),
        SICKEN(1),
        CALCIFIED(2),
        FROZEN(3),
        BILE(4);
        private int type;
        TumorType(int e){
            type=e;
        }
        public int getType(){return type;}
    }
}
