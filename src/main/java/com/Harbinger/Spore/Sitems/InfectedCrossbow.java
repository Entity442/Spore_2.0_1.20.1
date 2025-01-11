package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;

public class InfectedCrossbow extends CrossbowItem implements SporeWeaponData {
    private boolean startSoundPlayed = false;
    private boolean midLoadSoundPlayed = false;
    public InfectedCrossbow() {
        super(new Item.Properties().durability(SConfig.SERVER.crossbow_durability.get()));
        Sitems.BIOLOGICAL_ITEMS.add(this);
        Sitems.TINTABLE_ITEMS.add(this);
    }

    @Override
    public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
        return Objects.equals(Sitems.BIOMASS.get(), repairitem.getItem());
    }


    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!tooHurt(itemstack)){
            return InteractionResultHolder.fail(itemstack);
        }
        if (isCharged(itemstack)) {
            performShooting(level, player, hand, itemstack, getShootingPower(itemstack), 1.0F);
            if (!player.getAbilities().instabuild){
                hurtTool(itemstack,player,1);
            }
            setCharged(itemstack, false);
            return InteractionResultHolder.consume(itemstack);
        } else if (!player.getProjectile(itemstack).isEmpty()) {
            if (!isCharged(itemstack)) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
                player.startUsingItem(hand);
            }

            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    private float getShootingPower(ItemStack stack) {
        float value = containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 2.6F : 4.15F;
        return (float) calculateTrueDamage(stack,value);
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int value) {
        int i = this.getUseDuration(stack) - value;
        float f = getPowerForTime(i, stack);
        if (f >= 1.0F && !isCharged(stack) && tryLoadProjectiles(living, stack)) {
            setCharged(stack, true);
            SoundSource soundsource = living instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
            level.playSound(null, living.getX(), living.getY(), living.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundsource, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }

    }

    private static boolean tryLoadProjectiles(LivingEntity entity, ItemStack stack) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, stack);
        int j = i == 0 ? 1 : 3;
        boolean flag = entity instanceof Player && ((Player)entity).getAbilities().instabuild;
        ItemStack itemstack = entity.getProjectile(stack);
        ItemStack itemstack1 = itemstack.copy();

        for(int k = 0; k < j; ++k) {
            if (k > 0) {
                itemstack = itemstack1.copy();
            }

            if (itemstack.isEmpty() && flag) {
                itemstack = new ItemStack(Items.ARROW);
                itemstack1 = itemstack.copy();
            }

            if (!loadProjectile(entity, stack, itemstack, k > 0, flag)) {
                return false;
            }
        }

        return true;
    }

    private static boolean loadProjectile(LivingEntity entity, ItemStack stack, ItemStack itemStack, boolean p_40866_, boolean p_40867_) {
        if (itemStack.isEmpty()) {
            return false;
        } else {
            boolean flag = p_40867_ && itemStack.getItem() instanceof ArrowItem;
            ItemStack itemstack;
            if (!flag && !p_40867_ && !p_40866_) {
                itemstack = itemStack.split(1);
                if (itemStack.isEmpty() && entity instanceof Player) {
                    ((Player)entity).getInventory().removeItem(itemStack);
                }
            } else {
                itemstack = itemStack.copy();
            }

            addChargedProjectile(stack, itemstack);
            return true;
        }
    }

    public static boolean isCharged(ItemStack stack) {
        CompoundTag compoundtag = stack.getTag();
        return compoundtag != null && compoundtag.getBoolean("Charged");
    }

    public static void setCharged(ItemStack stack, boolean p_40886_) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        compoundtag.putBoolean("Charged", p_40886_);
    }

    private static void addChargedProjectile(ItemStack stack, ItemStack itemStack) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        ListTag listtag;
        if (compoundtag.contains("ChargedProjectiles", 9)) {
            listtag = compoundtag.getList("ChargedProjectiles", 10);
        } else {
            listtag = new ListTag();
        }

        CompoundTag compoundtag1 = new CompoundTag();
        itemStack.save(compoundtag1);
        listtag.add(compoundtag1);
        compoundtag.put("ChargedProjectiles", listtag);
    }

    private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
        List<ItemStack> list = Lists.newArrayList();
        CompoundTag compoundtag = stack.getTag();
        if (compoundtag != null && compoundtag.contains("ChargedProjectiles", 9)) {
            ListTag listtag = compoundtag.getList("ChargedProjectiles", 10);
            if (listtag != null) {
                for(int i = 0; i < listtag.size(); ++i) {
                    CompoundTag compoundtag1 = listtag.getCompound(i);
                    list.add(ItemStack.of(compoundtag1));
                }
            }
        }
        return list;
    }

    private static void clearChargedProjectiles(ItemStack stack) {
        CompoundTag compoundtag = stack.getTag();
        if (compoundtag != null) {
            ListTag listtag = compoundtag.getList("ChargedProjectiles", 9);
            listtag.clear();
            compoundtag.put("ChargedProjectiles", listtag);
        }

    }

    public static boolean containsChargedProjectile(ItemStack stack, Item item) {
        return getChargedProjectiles(stack).stream().anyMatch((p_40870_) -> {
            return p_40870_.is(item);
        });
    }

    private static void shootProjectile(Level level, LivingEntity entity, InteractionHand hand, ItemStack stack, ItemStack p_40899_, float p_40900_, boolean p_40901_, float p_40902_, float p_40903_, float p_40904_) {
        if (!level.isClientSide) {
            boolean flag = p_40899_.is(Items.FIREWORK_ROCKET);
            Projectile projectile;
            if (flag) {
                projectile = new FireworkRocketEntity(level, p_40899_, entity, entity.getX(), entity.getEyeY() - (double)0.15F, entity.getZ(), true);
            } else {
                projectile = getArrow(level, entity, stack, p_40899_);
                if (p_40901_ || p_40904_ != 0.0F) {
                    ((AbstractArrow)projectile).pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }
            }

            if (entity instanceof CrossbowAttackMob) {
                CrossbowAttackMob crossbowattackmob = (CrossbowAttackMob)entity;
                crossbowattackmob.shootCrossbowProjectile(crossbowattackmob.getTarget(), stack, projectile, p_40904_);
            } else {
                Vec3 vec31 = entity.getUpVector(1.0F);
                Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(p_40904_ * ((float)Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
                Vec3 vec3 = entity.getViewVector(1.0F);
                Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
                projectile.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), p_40902_, p_40903_);
            }
            if (projectile instanceof Arrow arrow){
                abstractEffects(stack,arrow);
                arrow.setBaseDamage(getAdditionalDamageCrossbow(entity.getItemInHand(hand),arrow.getBaseDamage()));
            }
            level.addFreshEntity(projectile);
            level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 1.0F, p_40900_);
        }
    }

    private static AbstractArrow getArrow(Level level, LivingEntity entity, ItemStack stack, ItemStack itemStack) {
        ArrowItem arrowitem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
        AbstractArrow abstractarrow = arrowitem.createArrow(level, itemStack, entity);
        if (entity instanceof Player) {
            abstractarrow.setCritArrow(true);
        }

        abstractarrow.setSoundEvent(SoundEvents.CROSSBOW_HIT);
        abstractarrow.setShotFromCrossbow(true);
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, stack);
        if (i > 0) {
            abstractarrow.setPierceLevel((byte)i);
        }
        abstractarrow.setBaseDamage((abstractarrow.getBaseDamage() * 2) * SConfig.SERVER.crossbow_arrow_damage_multiplier.get());

        return abstractarrow;
    }

    public static void performShooting(Level p_40888_, LivingEntity p_40889_, InteractionHand p_40890_, ItemStack p_40891_, float p_40892_, float p_40893_) {
        if (p_40889_ instanceof Player player && net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40891_, p_40889_.level(), player, 1, true) < 0) return;
        List<ItemStack> list = getChargedProjectiles(p_40891_);
        float[] afloat = getShotPitches(p_40889_.getRandom());

        for(int i = 0; i < list.size(); ++i) {
            ItemStack itemstack = list.get(i);
            boolean flag = p_40889_ instanceof Player && ((Player)p_40889_).getAbilities().instabuild;
            if (!itemstack.isEmpty()) {
                if (i == 0) {
                    shootProjectile(p_40888_, p_40889_, p_40890_, p_40891_, itemstack, afloat[i], flag, p_40892_, p_40893_, 0.0F);
                } else if (i == 1) {
                    shootProjectile(p_40888_, p_40889_, p_40890_, p_40891_, itemstack, afloat[i], flag, p_40892_, p_40893_, -10.0F);
                } else if (i == 2) {
                    shootProjectile(p_40888_, p_40889_, p_40890_, p_40891_, itemstack, afloat[i], flag, p_40892_, p_40893_, 10.0F);
                }
            }
        }

        onCrossbowShot(p_40888_, p_40889_, p_40891_);
    }

    private static float[] getShotPitches(RandomSource p_220024_) {
        boolean flag = p_220024_.nextBoolean();
        return new float[]{1.0F, getRandomShotPitch(flag, p_220024_), getRandomShotPitch(!flag, p_220024_)};
    }

    private static float getRandomShotPitch(boolean p_220026_, RandomSource p_220027_) {
        float f = p_220026_ ? 0.63F : 0.43F;
        return 1.0F / (p_220027_.nextFloat() * 0.5F + 1.8F) + f;
    }

    private static void onCrossbowShot(Level p_40906_, LivingEntity p_40907_, ItemStack p_40908_) {
        if (p_40907_ instanceof ServerPlayer serverplayer) {
            if (!p_40906_.isClientSide) {
                CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayer, p_40908_);
            }

            serverplayer.awardStat(Stats.ITEM_USED.get(p_40908_.getItem()));
        }

        clearChargedProjectiles(p_40908_);
    }

    public void onUseTick(Level p_40910_, LivingEntity p_40911_, ItemStack p_40912_, int p_40913_) {
        if (!p_40910_.isClientSide) {
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40912_);
            SoundEvent soundevent = this.getStartSound(i);
            SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
            float f = (float)(p_40912_.getUseDuration() - p_40913_) / (float)getChargeDuration(p_40912_);
            if (f < 0.2F) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
            }

            if (f >= 0.2F && !this.startSoundPlayed) {
                this.startSoundPlayed = true;
                p_40910_.playSound(null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent, SoundSource.PLAYERS, 0.5F, 1.0F);
            }

            if (f >= 0.5F && soundevent1 != null && !this.midLoadSoundPlayed) {
                this.midLoadSoundPlayed = true;
                p_40910_.playSound(null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
            }
        }

    }

    public int getUseDuration(ItemStack p_40938_) {
        return getChargeDuration(p_40938_) + 3;
    }

    public static int getChargeDuration(ItemStack p_40940_) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40940_);
        return i == 0 ? 25 : 25 - 5 * i;
    }

    public UseAnim getUseAnimation(ItemStack p_40935_) {
        return UseAnim.CROSSBOW;
    }

    private SoundEvent getStartSound(int p_40852_) {
        switch (p_40852_) {
            case 1:
                return SoundEvents.CROSSBOW_QUICK_CHARGE_1;
            case 2:
                return SoundEvents.CROSSBOW_QUICK_CHARGE_2;
            case 3:
                return SoundEvents.CROSSBOW_QUICK_CHARGE_3;
            default:
                return SoundEvents.CROSSBOW_LOADING_START;
        }
    }

    private static float getPowerForTime(int p_40854_, ItemStack p_40855_) {
        float f = (float)p_40854_ / (float)getChargeDuration(p_40855_);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public void appendHoverText(ItemStack stack, @Nullable Level p_40881_, List<Component> components, TooltipFlag p_40883_) {
        List<ItemStack> list = getChargedProjectiles(stack);
        if (isCharged(stack) && !list.isEmpty()) {
            ItemStack itemstack = list.get(0);
            components.add(Component.translatable("item.minecraft.crossbow.projectile").append(" ").append(itemstack.getDisplayName()));
            if (p_40883_.isAdvanced() && itemstack.is(Items.FIREWORK_ROCKET)) {
                List<Component> list1 = Lists.newArrayList();
                Items.FIREWORK_ROCKET.appendHoverText(itemstack, p_40881_, list1, p_40883_);
                if (!list1.isEmpty()) {
                    list1.replaceAll(p130942 -> Component.literal("  ").append(p130942).withStyle(ChatFormatting.GRAY));
                    components.addAll(list1);
                }
            }

        }
        if (Screen.hasShiftDown()){
            components.add(Component.literal(Component.translatable("spore.item.damage_increase").getString() + getAdditionalDamage(stack) + "%"));
            components.add(Component.literal(Component.translatable("spore.item.durability_increase").getString()+ getMaxAdditionalDurability(stack) + "%"));
            components.add(Component.literal(Component.translatable("spore.item.additional_durability").getString()+ getAdditionalDurability(stack)));
            components.add(Component.literal(Component.translatable("spore.item.enchant").getString()+ getEnchantmentValue(stack)));
            if (getVariant(stack) != SporeToolsMutations.DEFAULT){
                components.add(Component.literal(Component.translatable("spore.item.mutation").getString()+Component.translatable(getVariant(stack).getName()).getString()));
            }
        }
    }

    public boolean useOnRelease(ItemStack p_150801_) {
        return p_150801_.is(this);
    }

    public int getDefaultProjectileRange() {
        return 8;
    }
    @Override
    public boolean isBarVisible(ItemStack stack) {
        return super.isBarVisible(stack) || getAdditionalDurability(stack) > 0;
    }
    @Override
    public int getBarColor(ItemStack stack) {
        if (getAdditionalDurability(stack) > 0){
            return Mth.hsvToRgb( 240.0F, 100.0F, 100.0F);
        }else{
            return super.getBarColor(stack);
        }
    }
    @Override
    public int getEnchantmentValue(ItemStack stack) {
        int luck = getLuck(stack);
        return luck > 0 ? luck : 1;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (!tooHurt(stack) && entity instanceof Player player){
            player.getCooldowns().addCooldown(this,60);
        }
        return false;
    }

    public static void abstractEffects(ItemStack stack, Arrow arrow){
        if (stack.getEnchantmentLevel(Senchantments.CORROSIVE_POTENCY.get())>0){
            arrow.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,1));
        }
        if (stack.getEnchantmentLevel(Senchantments.GASTRIC_SPEWAGE.get())>0){
            for (MobEffectInstance instance : BileLiquid.bileEffects())
                arrow.addEffect(instance);
        }
        if (getMutation(stack) == SporeToolsMutations.TOXIC){
            arrow.addEffect(new MobEffectInstance(MobEffects.WITHER,100,0));
        }
        if (getMutation(stack) == SporeToolsMutations.ROTTEN){
            arrow.addEffect(new MobEffectInstance(MobEffects.POISON,100,1));
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity entity) {
        if (tooHurt(stack)){
            hurtTool(stack,entity,1);
        }
        doEntityHurtAfterEffects(stack,living,entity);
        return super.hurtEnemy(stack, living, entity);
    }

    private static SporeToolsMutations getMutation(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return SporeToolsMutations.byId(tag.getInt(MUTATION) & 255);
    }

    private static double getAdditionalDamageCrossbow(ItemStack itemStack,double damage){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        double value = tag.getDouble(MELEE_TAG) * 0.01;
        if (value > 0){
            return damage + (damage * value);
        }
        return damage;
    }
}

