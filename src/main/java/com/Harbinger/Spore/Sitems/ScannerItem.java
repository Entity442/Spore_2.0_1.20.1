package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ScannerItem extends BaseItem2 {
    public ScannerItem(Properties properties) {
        super(properties);
    }


    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }


    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
            ItemStack tool = player.getItemInHand(hand);
            if (tool.getItem() instanceof ScannerItem  && !level.isClientSide) {
                AABB hitbox = player.getBoundingBox().inflate(2);
                List<Entity> entities = player.level().getEntities(player, hitbox);
                for (Entity entity1 : entities) {
                if (entity1 instanceof Infected infected) {
                    String name = infected.getCustomName() != null ? infected.getCustomName().getString() : "Unknown";
                    player.displayClientMessage(Component.literal("Subject " + name), false);
                    player.displayClientMessage(Component.literal("Subspecies " + Component.translatable(infected.getType().getDescriptionId()).getString()), false);
                    player.displayClientMessage(Component.literal("Health " + infected.getHealth() + "/" + infected.getMaxHealth()), false);
                    break;
                    }
                }
            }
            return InteractionResultHolder.success(tool);
    }
}
