package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeaponSyringe extends AbstractSyringe{
    private final SporeToolsMutations mutations;
    public WeaponSyringe(SporeToolsMutations mutations) {
        this.mutations = mutations;
    }
    @Override
    public int getColor() {
        return mutations.getColor();
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction clickAction, Player player) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.getItem() instanceof SporeWeaponData weaponData && clickAction == ClickAction.SECONDARY){
            weaponData.setVariant(mutations,itemStack);
            stack.shrink(1);
            return true;
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(stack, p_41422_, components, p_41424_);
        components.add(Component.literal(Component.translatable("spore.item.mutation").getString()+Component.translatable(mutations.getName()).getString()));
    }
}
