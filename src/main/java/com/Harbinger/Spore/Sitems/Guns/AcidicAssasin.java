package com.Harbinger.Spore.Sitems.Guns;

import com.Harbinger.Spore.Client.AnimationTrackers.AssassinReloadAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.AssassinShootAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.AssassinBullet;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class AcidicAssasin extends AbstractSporeGun implements CustomModelArmorData {
    private static final ResourceLocation TEXTURE =new ResourceLocation("spore:textures/item/acidic_assasin.png");
    public AcidicAssasin() {
        super(SConfig.SERVER.acidic_assassin_durability.get());
    }

    @Override
    public boolean needsToReload() {
        return true;
    }

    @Override
    public int getDefaultTimeBeforeReload() {
        return 80;
    }

    @Override
    public int getTimeBeforeChangingClip(ItemStack stack) {
        return 40;
    }

    @Override
    public int timeBeforeStomachContentsConvertIntoAmmo() {
        return 200;
    }

    @Override
    public int getClipSize() {
        return 6;
    }

    @Override
    public Item getAmmoItem() {
        return Sitems.ACID_VIAL.get();
    }

    @Override
    public void triggerReloadAnimation(Player player) {
        super.triggerReloadAnimation(player);
        AssassinReloadAnimationTracker.trigger(player);
    }

    @Override
    public void clientShoot(Player player, InteractionHand interactionHand) {
        AssassinShootAnimationTracker.trigger(player);
    }

    @Override
    public void serverShoot(ItemStack stack, ServerPlayer player, InteractionHand hand, Vec3 vec3) {
        super.serverShoot(stack, player, hand, vec3);
        int getVar = this.getTypeVariant(stack);
        AssassinBullet bullet = new AssassinBullet(Sentities.ASSASSIN_BULLET.get(),player.level());
        bullet.setVariant(getVar);
        bullet.moveTo(player.getX()+vec3.x, player.getY()+1.25D ,player.getZ()+vec3.z);
        bullet.shootFrom(player,7,0,(float) calculateTrueDamage(stack,SConfig.SERVER.acidic_assassin_damage.get()));
        player.level().addFreshEntity(bullet);
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                Ssounds.ASSASSIN_SHOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}
