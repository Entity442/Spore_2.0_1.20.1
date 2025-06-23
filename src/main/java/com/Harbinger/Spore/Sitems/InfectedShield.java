package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.List;

public class InfectedShield extends SporeToolsBaseItem {
    public static final String CHARGE_TAG = "ShieldCharge";
    public static final int MAX_CHARGE = 5;
    public InfectedShield() {
        super(5, 0, 1, 300, 0);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public UseAnim getUseAnimation(ItemStack p_43105_) {
        return UseAnim.BLOCK;
    }

    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    public InteractionResultHolder<ItemStack> use(Level p_43099_, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (tooHurt(itemstack)){
            player.startUsingItem(hand);
        }
        return InteractionResultHolder.consume(itemstack);
    }
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.hurtTool(stack,attacker,1);
        return true;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }


    public void triggerBash(Player player, ItemStack stack) {
        if (!(player.level().isClientSide)) {
            double radius = 5.0;
            Vec3 look = player.getLookAngle();
            AABB area = player.getBoundingBox().expandTowards(look.scale(radius)).inflate(2.0);

            List<LivingEntity> entities = player.level().getEntitiesOfClass(LivingEntity.class, area,
                    e -> e != player && e.isAlive() && player.hasLineOfSight(e));

            for (LivingEntity target : entities) {
                Vec3 direction = target.position().subtract(player.position()).normalize();
                target.hurtMarked = true;
                target.knockback(1.5F, -direction.x, -direction.z);
            }

            stack.getOrCreateTag().putInt(CHARGE_TAG, 0);
            player.level().playSound(null, player.blockPosition(), SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0F, 1.0F);
            this.hurtTool(stack,player,1);
        }
    }

}
