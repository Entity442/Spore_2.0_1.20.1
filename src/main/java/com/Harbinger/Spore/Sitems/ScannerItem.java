package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
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
        if (!level.isClientSide){
            LivingEntity victim = getScannedEntity(player,level);
            if (victim != null){
                showInfo(tool,victim,player);
            }
            player.getCooldowns().addCooldown(this,20);
        }
        return InteractionResultHolder.success(tool);
    }
    @Nullable
    public LivingEntity getScannedEntity(Player player,Level level){
        AABB hitbox1 = getScannerHitBox(player,10f);
        List<Entity> list = level.getEntities(player,hitbox1, entity -> {return entity instanceof LivingEntity;});
        Iterator<Entity> var5 = list.iterator();
        double value = Double.MAX_VALUE;
        LivingEntity entity = null;
        while(var5.hasNext()) {
            LivingEntity $$3 = (LivingEntity)var5.next();
            if (player.distanceToSqr($$3) < value) {
                entity = $$3;
                value = player.distanceToSqr($$3);
            }
        }
        return entity;
    }

    @Nullable
    public AABB getScannerHitBox(Player player,double range){
        Vec3 vec3 = (new Vec3(range, Mth.cos(player.getXRot() * 0.017453292F),0D)).yRot(-player.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        return player.getBoundingBox().expandTowards(vec3);
    }

    public void showInfo(ItemStack stack, LivingEntity entity, Player player){
        if (stack.getItem() instanceof ScannerItem){
            if (entity instanceof Illusion){
                player.displayClientMessage(Component.translatable("spore.scanner.line.15"), false);
                return;
            }
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING,40));
            String name = entity.getCustomName() != null ? entity.getCustomName().getString() : Component.translatable("spore.scanner.line.1").getString();
            player.displayClientMessage(Component.literal("------------------"), false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.2").getString() + name), false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.3").getString() + Component.translatable(entity.getType().getDescriptionId()).getString()), false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.4").getString() + (double)entity.getHealth() + "/" + entity.getMaxHealth()), false);
            showExtraInfo(entity,player);
            if (showThreatLevel(entity) != null){
                Component component = Component.translatable(showThreatLevel(entity));
                player.displayClientMessage(Component.literal("------------------"), false);
                player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.5").getString()+component.getString()), false);
            }
            writeDrops(entity,player);
        }
    }
    public String showThreatLevel(LivingEntity living){
        if (living instanceof Calamity){
            return  "spore.scanner.danger.calamity";
        }
        if (living instanceof Hyper){
            return "spore.scanner.danger.hyper";
        }
        if (living instanceof EvolvedInfected){
            return "spore.scanner.danger.evolved";
        }
        if (living instanceof Experiment){
            return "spore.scanner.danger.experiment";
        }
        if (living instanceof Infected){
            return "spore.scanner.danger.infected";
        }
        if (living instanceof Organoid){
            return "spore.scanner.danger.organoid";
        }
        if (living instanceof UtilityEntity){
            return "spore.scanner.danger.utility";
        }
        return null;
    }

    public void showExtraInfo(LivingEntity entity, Player player){
        if (entity instanceof Infected infected){
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.6").getString() + infected.getKills()),false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.7").getString() + infected.getEvoPoints()),false);
            if (infected.getEvolutionCoolDown() > 0){
                player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.8").getString() + infected.getEvolutionCoolDown() + "/" + SConfig.SERVER.evolution_age_human.get()),false);
            }
            if (infected.getHunger() > 0){
                player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.9").getString() + infected.getHunger() + "/" + (SConfig.SERVER.hunger.get())),false);
            }
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.10").getString() + infected.getLinked()),false);
            if (infected.getMutation() != null){
                player.displayClientMessage(Component.translatable(infected.getMutation()),false);
            }
            if (infected instanceof Scamper scamper){
                player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.scamper").getString() + scamper.getAge() + "/" + SConfig.SERVER.scamper_age.get()),false);
            }
        }
        if (entity instanceof UtilityEntity utilityEntity && utilityEntity.getMutation() != null){
            player.displayClientMessage(Component.translatable(utilityEntity.getMutation()),false);
        }
        if (entity instanceof Mound mound){
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.10").getString() + mound.getLinked()),false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.11").getString() + mound.getAge()),false);
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.12").getString() + mound.getAgeCounter() + "/" + SConfig.SERVER.mound_age.get()),false);
        }
        if (entity instanceof Calamity calamity){
            player.displayClientMessage(Component.literal(Component.translatable("spore.scanner.line.6").getString() + calamity.getKills()),false);
        }
    }
    public void writeDrops(LivingEntity living,Player player){
        List<? extends String> itemDrops = null;
        if (living instanceof Infected infected){
            itemDrops = infected.getDropList();
        }
        if(living instanceof UtilityEntity utilityEntity){
            itemDrops = utilityEntity.getDropList();
        }
        if (itemDrops == null || itemDrops.isEmpty()){
            player.displayClientMessage(Component.translatable("spore.scanner.line.13"), false);
        }else{
            List<Item> drops = new ArrayList<>();
            for (String string : itemDrops){
                String[] split = string.split("\\|" );
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(split[0]));
                if (item != null){
                    drops.add(item);
                }
            }
            player.displayClientMessage(Component.literal("------------------"), false);
            player.displayClientMessage(Component.translatable("spore.scanner.line.14"), false);
            for (Item item : drops){
                player.displayClientMessage(Component.translatable(item.getDescriptionId()), false);
            }
        }
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction clickAction, Player player) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.getItem() instanceof OrganItem organItem && !organItem.isScanned(itemStack) && clickAction == ClickAction.SECONDARY){
            organItem.setScanned(itemStack);
            return true;
        }
        return false;
    }
}
