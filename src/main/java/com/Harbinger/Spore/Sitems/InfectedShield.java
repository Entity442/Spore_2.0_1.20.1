package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
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
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class InfectedShield extends SporeToolsBaseItem {
    public InfectedShield() {
        super(5, 1, 1, 300, 0);
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
        if (attacker instanceof Player player && player.isSprinting()) {
            double knockbackStrength = 1;
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            double magnitude = Math.sqrt(dx * dx + dz * dz);

            if (magnitude > 0.01) {
                target.push(
                        dx / magnitude * knockbackStrength,
                        0.1,
                        dz / magnitude * knockbackStrength
                );
                target.hurtMarked = true;
            }
        }
        this.hurtTool(stack,attacker,1);
        return true;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }
}
