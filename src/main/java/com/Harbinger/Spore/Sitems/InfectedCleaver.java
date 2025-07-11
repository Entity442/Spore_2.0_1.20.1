package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.ClientUtils;
import com.Harbinger.Spore.Sitems.BaseWeapons.DeathRewardingWeapon;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class InfectedCleaver extends SporeSwordBase implements DeathRewardingWeapon {
    private final List<EnAndItem> heads;
    public InfectedCleaver() {
        super(SConfig.SERVER.cleaver_damage.get(), 2.5f, 3F, SConfig.SERVER.cleaver_durability.get());
        this.heads = getHeads();
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 120;
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }
    private record EnAndItem(String id, Item item){}

    private List<EnAndItem> getHeads(){
        List<EnAndItem> values = new ArrayList<>();
        for(String string : SConfig.SERVER.cleaver_drops.get()){
            String[] str = string.split("\\|");
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(str[1]));
            if (item != null){
                values.add(new EnAndItem(str[0],item));
            }
        }
        return values;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public void computeAfterEffect(LivingEntity victim, LivingEntity source, ItemStack weapon) {
        if (victim.level().isClientSide){return;}
        for (EnAndItem item : heads){
            if (item.id.equals(victim.getEncodeId()) && Math.random() < 0.1){
                dropLoot(victim.level(),victim.getX(),victim.getY(),victim.getZ(),new ItemStack(item.item));
                break;
            }
        }
    }

    public void dropLoot(Level level,double x, double y, double z,ItemStack stack){
        ItemEntity entity = new ItemEntity(level,x,y,z,stack);
        level.addFreshEntity(entity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.playNotifySound(Ssounds.CLEAVER_SPIN.get(), SoundSource.AMBIENT,1F,1F);
        player.startUsingItem(hand);
        this.hurtTool(player.getItemInHand(hand),player,1);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }


    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int count) {
        if (!(entity instanceof Player player)) return;

        int charge = getUseDuration(stack) - count;

        if (level.isClientSide) {
            ClientUtils.spinPlayer(player);
        } else {
            if (charge % 5 == 0) {
                double radius = 2.5;
                for (int i = 0; i < 10; i++) {
                    double angle = 2 * Math.PI * i / 10;
                    double x = player.getX() + radius * Math.cos(angle);
                    double z = player.getZ() + radius * Math.sin(angle);
                    ((ServerLevel) entity.level()).sendParticles(Sparticles.SPORE_SLASH.get(), x, player.getY() + 1, z, 1, 0, 0, 0, 0);
                }

                AABB area = player.getBoundingBox().inflate(3.5,1,3.5);
                List<LivingEntity> targets = player.level().getEntitiesOfClass(LivingEntity.class, area, e -> e != player && e.isAlive());
                for (LivingEntity target : targets) {
                    this.hurtEnemy(stack,target,player);
                    target.hurt(player.damageSources().playerAttack(player), SConfig.SERVER.cleaver_damage.get()/2f);
                    target.hurtTime = 10;
                    target.invulnerableTime = 10;
                }
            }
        }

        if (count <= 2){
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0));
            player.getCooldowns().addCooldown(this, 200);
            player.stopUsingItem();
        }

        if (charge % 20 == 0){
            player.playNotifySound(Ssounds.CLEAVER_SPIN.get(), SoundSource.AMBIENT, 1F, 1F);
        }

        super.onUseTick(level, entity, stack, count);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int p_41415_) {
        super.releaseUsing(stack, level, living, p_41415_);
        if (living instanceof Player player){player.getCooldowns().addCooldown(this, 60);}
    }
}
