package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArmorSyringe extends AbstractSyringe{
    private final SporeArmorMutations mutations;
    public ArmorSyringe(SporeArmorMutations mutations) {
        this.mutations = mutations;
    }
    @Override
    public int getColor() {
        return mutations.getColor();
    }

    @Override
    void useSyringe(ItemStack stack, LivingEntity living) {
        switch (mutations){
            case REINFORCED -> {living.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,200 ,1));}
            case SKELETAL -> {living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,400 ,1));}
            case DROWNED -> {living.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,600,0));}
            case CHARRED ->{living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,600,0));}
        }
        stack.shrink(1);
        addMycelium(living);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction clickAction, Player player) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.getItem() instanceof SporeArmorData weaponData && clickAction == ClickAction.SECONDARY){
            player.playNotifySound(Ssounds.SYRINGE_INJECT.get(), SoundSource.AMBIENT,1F,1F);
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
