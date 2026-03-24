package com.Harbinger.Spore.Sitems.Guns;

import com.Harbinger.Spore.Client.AnimationTrackers.BileBlasterReloadAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.BileBlasterShootAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.BileBullet;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class BileBlaster extends AbstractSporeGun implements CustomModelArmorData {
    private static final ResourceLocation TEXTURE =new ResourceLocation("spore:textures/item/bile_blaster.png");
    public BileBlaster() {
        super(SConfig.SERVER.bile_blaster_durability.get());
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
        return 5;
    }

    @Override
    public int timeBeforeStomachContentsConvertIntoAmmo() {
        return 80;
    }

    @Override
    public int getClipSize() {
        return 16;
    }

    @Override
    public Item getAmmoItem() {
        return Sitems.BILE_VIAL.get();
    }

    @Override
    public void clientShoot(Player player, InteractionHand interactionHand) {
        BileBlasterShootAnimationTracker.trigger(player);
    }

    @Override
    public void serverShoot(ItemStack stack, ServerPlayer player, InteractionHand hand, Vec3 vec3) {
        super.serverShoot(stack, player, hand, vec3);
        int getVar = this.getTypeVariant(stack);
        BileBullet bullet = new BileBullet(Sentities.BILE_BULLET.get(),player.level());
        bullet.setVariant(getVar);
        bullet.moveTo(player.getX()+vec3.x, player.getY()+1.25D ,player.getZ()+vec3.z);
        bullet.shootFrom(player,2.5f,2,(float) calculateTrueDamage(stack,SConfig.SERVER.bile_blaster_damage.get()));
        player.level().addFreshEntity(bullet);
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                Ssounds.BILE_BLASTER_SHOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public void triggerReloadAnimation(Player player) {
        super.triggerReloadAnimation(player);
        BileBlasterReloadAnimationTracker.trigger(player);
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}
