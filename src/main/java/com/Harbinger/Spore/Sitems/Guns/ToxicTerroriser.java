package com.Harbinger.Spore.Sitems.Guns;

import com.Harbinger.Spore.Client.AnimationTrackers.TerroriserReloadAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.TerroriserShootAnimationTracker;
import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.ToxinBullet;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class ToxicTerroriser extends AbstractSporeGun implements CustomModelArmorData {
    private static final ResourceLocation TEXTURE =new ResourceLocation("spore:textures/item/terroriser.png");
    public ToxicTerroriser() {
        super(SConfig.SERVER.terroriser_durability.get());
    }

    @Override
    public boolean needsToReload() {
        return true;
    }

    @Override
    public int getDefaultTimeBeforeReload() {
        return 40;
    }

    @Override
    public int getTimeBeforeChangingClip(ItemStack stack) {
        return 10;
    }

    @Override
    public int timeBeforeStomachContentsConvertIntoAmmo() {
        return 40;
    }

    @Override
    public int getClipSize() {
        return 8;
    }

    @Override
    public Item getAmmoItem() {
        return Sitems.TOXIN_VIAL.get();
    }

    @Override
    public void clientShoot(Player player, InteractionHand interactionHand) {
        TerroriserShootAnimationTracker.trigger(player);
    }

    @Override
    public void serverShoot(ItemStack stack, ServerPlayer player, InteractionHand hand, Vec3 vec3) {
        super.serverShoot(stack, player, hand, vec3);
        int getVar = this.getTypeVariant(stack);
        ToxinBullet bullet = new ToxinBullet(Sentities.TOXIN_BULLET.get(),player.level());
        bullet.setVariant(getVar);
        bullet.moveTo(player.getX()+vec3.x, player.getY()+1.25D ,player.getZ()+vec3.z);
        bullet.shootFrom(player,2.5f,2,(float) calculateTrueDamage(stack,SConfig.SERVER.terroriser_damage.get()));
        player.level().addFreshEntity(bullet);
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                Ssounds.TERRORISER_SHOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public void triggerReloadAnimation(Player player) {
        super.triggerReloadAnimation(player);
        TerroriserReloadAnimationTracker.trigger(player);
    }
    @Override
    public Component extraTips() {
        return Component.translatable("spore.item.desc.toxic_terror").withStyle(ChatFormatting.YELLOW);
    }
    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}
