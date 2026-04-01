package com.Harbinger.Spore.Sitems.Guns;

import com.Harbinger.Spore.Client.AnimationTrackers.MistMakerSawAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.MistMakerShootAnimationTracker;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.GoreBullet;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MistMaker extends AbstractSporeGun implements CustomModelArmorData {
    private static final ResourceLocation TEXTURE =new ResourceLocation("spore:textures/item/mistmaker.png");
    public MistMaker() {
        super(SConfig.SERVER.mistmaker_durability.get());
    }

    @Override
    public boolean needsToReload() {
        return false;
    }

    @Override
    public int getDefaultTimeBeforeReload() {
        return 0;
    }

    @Override
    public int getTimeBeforeChangingClip(ItemStack stack) {
        return 20;
    }

    @Override
    public int timeBeforeStomachContentsConvertIntoAmmo() {
        return 0;
    }

    @Override
    public int getClipSize() {
        return 60;
    }

    @Override
    public int getAmmoUsage() {
        return 4;
    }

    @Override
    public int getBaseAmmoShotRequirement() {
        return 4;
    }

    @Override
    public Item getAmmoItem() {
        return null;
    }

    @Override
    public void clientShoot(Player player, InteractionHand interactionHand) {
        MistMakerShootAnimationTracker.trigger(player);
    }

    @Override
    public void serverShoot(ItemStack stack, ServerPlayer player, InteractionHand hand, Vec3 vec3) {
        super.serverShoot(stack, player, hand, vec3);
        int getVar = this.getTypeVariant(stack);
        for (int i = 0;i<4;i++){
            GoreBullet bullet = new GoreBullet(Sentities.GORE_BULLET.get(),player.level());
            bullet.setVariant(getVar);
            bullet.moveTo(player.getX()+vec3.x, player.getY()+1.25D ,player.getZ()+vec3.z);
            bullet.shootFrom(player,1.5f,6,(float) calculateTrueDamage(stack,SConfig.SERVER.mistmaker_damage.get()));
            player.level().addFreshEntity(bullet);
        }
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                Ssounds.MISTMAKER_SHOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            MistMakerSawAnimationTracker.trigger(player);
        } else {
            Vec3 lookVec = player.getLookAngle();
            double range = 4.0;
            double radius = 1.5;

            Vec3 startPos = player.getEyePosition();
            AABB attackArea = new AABB(
                    startPos.x - radius, startPos.y - radius, startPos.z - radius,
                    startPos.x + radius, startPos.y + radius, startPos.z + radius
            ).expandTowards(lookVec.scale(range));
            List<Entity> entities = level.getEntities(player, attackArea,
                    entity -> entity instanceof LivingEntity &&
                            entity != player &&
                            !entity.isSpectator() &&
                            entity.isAlive()
            );

            int hitCount = 0;

            for (Entity entity : entities) {
                Vec3 toEntity = entity.position().subtract(startPos).normalize();
                double dot = lookVec.dot(toEntity);

                if (dot > 0.5) {
                    double distance = startPos.distanceTo(entity.position());
                    if (distance <= range) {
                        if (entity instanceof LivingEntity living && living.hurtTime == 0) {
                            living.hurt(level.damageSources().playerAttack(player), (float) calculateTrueDamage(stack,SConfig.SERVER.mistmaker_melee_damage.get()));
                            doEntityHurtAfterEffects(stack,living,player);
                            hitCount++;
                        }
                    }
                }
            }

            if (hitCount > 0) {
                int stomach = getInt(stack, "Stomach");
                int newStomach = Math.min(stomach + hitCount, getClipSize());
                setInt(stack, "Stomach", newStomach);
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        Ssounds.MISTMAKER_BITE.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
                int i = calculateDurabilityLostForMutations(1,stack);
                this.hurtTool(stack,player,i);
            }
        }
        return super.use(level, player, hand);
    }
    @Override
    public Component extraTips() {
        return Component.translatable("spore.item.desc.mistmaker").withStyle(ChatFormatting.DARK_RED);
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}
