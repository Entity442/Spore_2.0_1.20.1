package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.Sitems.Guns.AbstractSporeGun;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record SporeGunFirePacket(int id){

    public SporeGunFirePacket(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }


    private static int getInt(ItemStack stack, String key) {
        return  stack.getTag() != null && stack.getTag().contains(key) ? stack.getTag().getInt(key) : 0;
    }

    private static void setInt(ItemStack stack, String key, int value) {
        stack.getOrCreateTag().putInt(key, value);
    }

    public static void handle(SporeGunFirePacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {

            Player sender = context.get().getSender();
            if (sender == null) return;

            Level level = sender.level();
            if (level.isClientSide) return;

            Entity truePlayer = level.getEntity(message.id);

            if (!(truePlayer instanceof ServerPlayer playerValue)) return;

            ItemStack stack = playerValue.getItemInHand(InteractionHand.MAIN_HAND);

            if (!(stack.getItem() instanceof AbstractSporeGun gun)) return;

            // 🔥 Offsets
            Vec3 offset = new Vec3(-0.2, 0, 0.3);
            Vec3 vec3 = offset.yRot(-playerValue.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));

            int shootDelay = getInt(stack, "ShootDelay");
            int reloadDelay = getInt(stack, "ReloadDelay");

            if (shootDelay > 0 || reloadDelay > 0) return;

            if (gun.needsToReload()) {

                int clip = getInt(stack, "ClipAmmo");

                if (clip < gun.getBaseAmmoShotRequirement()) {
                    gun.playEmptyFireSounds(playerValue);

                    setInt(stack, "ShootDelay", 5);
                    playerValue.getCooldowns().addCooldown(gun, 5);
                    return;
                }

                setInt(stack, "ClipAmmo", clip - gun.getAmmoUsage());

            } else {

                int stomach = getInt(stack, "Stomach");

                if (stomach < gun.getBaseAmmoShotRequirement()) {
                    gun.playEmptyFireSounds(playerValue);

                    setInt(stack, "ShootDelay", 5);
                    playerValue.getCooldowns().addCooldown(gun, 5);
                    return;
                }

                setInt(stack, "Stomach", stomach - gun.getAmmoUsage());
            }

            int timeout = gun.getTimeBeforeChangingClip(stack);

            setInt(stack, "ShootDelay", timeout);
            playerValue.getCooldowns().addCooldown(gun, timeout);

            gun.serverShoot(stack, playerValue, InteractionHand.MAIN_HAND, vec3);

        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        context.get().setPacketHandled(true);
    }

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(id);
    }
}