package com.Harbinger.Spore.Sitems;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ScannerItem extends BaseItem2 {
    public ScannerItem(Properties properties) {
        super(properties);
    }


    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }


    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
            ItemStack tool = player.getItemInHand(hand);
            EntityHitResult result = getScanner(player,level,25);
            if (result != null && result.getEntity() instanceof LivingEntity living){
                showInfo(tool,living,player);
            }
            player.getCooldowns().addCooldown(this,20);
            return InteractionResultHolder.success(tool);
    }

    @Nullable
    public EntityHitResult getScanner(Player player,Level level,double range){
        Vec3 vec3 = (new Vec3(range, Mth.sin(-player.getXRot() * 0.017453292F),0D)).yRot(-player.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        AABB aabb = new AABB(-0.6,-0.6,-0.6,0.6,0.6,0.6);
        return ProjectileUtil.getEntityHitResult(level,player,player.getEyePosition(),vec3,aabb, entity -> {return entity instanceof LivingEntity;});
    }

    public void showInfo(ItemStack stack, LivingEntity entity, Player player){
        if (stack.getItem() instanceof ScannerItem){
            String name = entity.getCustomName() != null ? entity.getCustomName().getString() : "Unknown";
            player.displayClientMessage(Component.literal("Subject " + name), false);
            player.displayClientMessage(Component.literal("Subspecies " + Component.translatable(entity.getType().getDescriptionId()).getString()), false);
            player.displayClientMessage(Component.literal("Health " + entity.getHealth() + "/" + entity.getMaxHealth()), false);
        }
    }
}
