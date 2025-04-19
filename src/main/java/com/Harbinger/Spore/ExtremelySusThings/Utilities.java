package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Core.SAttributes;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Utilities {
    public static void explodeCircle(ServerLevel level, Entity owner, BlockPos pos, double range, float damage,double blockHardness,Predicate<Entity> predicate) {
        explodeCircle(level,owner,pos,range,damage, ParticleTypes.EXPLOSION_EMITTER,false,blockHardness,predicate);
    }

    public static void explodeCircle(ServerLevel level, Entity owner, BlockPos pos, double range, float damage, ParticleOptions particleTypes, boolean dropItems,double blockHardness,Predicate<Entity> predicate){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            RandomSource source = RandomSource.create();
                            BlockState state = level.getBlockState(blockpos);
                            if ((state.getDestroySpeed(level,blockpos) <= blockHardness && state.getDestroySpeed(level,blockpos) >=0) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, owner)){
                                level.removeBlock(blockpos,dropItems);
                                if (Math.random() < 0.3){
                                    float value = source.nextFloat() * 0.05f;
                                    level.sendParticles(particleTypes,blockpos.getX(),blockpos.getY(),blockpos.getZ(),1,value,0,value,1);
                                }
                            }
                          }}}}}
        AABB searchbox = AABB.ofSize(new Vec3(pos.getX(), pos.getY(), pos.getZ()), range*2, range*2, range*2);
        List<Entity> entities = level.getEntities(owner,searchbox, predicate);
        for (Entity entity : entities){
            entity.hurt(level.damageSources().mobAttack((LivingEntity) owner),damage);
        }
        level.playSound(null,pos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS);
    }
    public static void convertBlocks(ServerLevel level, Entity owner, BlockPos pos, double range, BlockState state){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, owner) && Math.random() < 0.2f){
                                if (level.getBlockState(blockpos).isAir() && level.getBlockState(blockpos.below()).isSolidRender(level,blockpos)){
                                    level.setBlock(blockpos,state,3);
                                }
                            }
                        }}}}}
    }

    public static final Predicate<LivingEntity> TARGET_SELECTOR_PREDICATE = (entity) -> {
        if (entity instanceof Infected || entity instanceof UtilityEntity){
            return false;
        }else if ((entity instanceof AbstractFish || entity instanceof Animal) && !SConfig.SERVER.at_an.get()){
            return false;
        }else if (!SConfig.SERVER.blacklist.get().isEmpty()){
            for(String string : SConfig.SERVER.blacklist.get()){
                if (string.endsWith(":") && entity.getEncodeId() != null){
                    String[] mod = string.split(":");
                    String[] iterations = entity.getEncodeId().split(":");
                    if (Objects.equals(mod[0], iterations[0])){
                        return false;
                    }
                }
            }
            return !SConfig.SERVER.blacklist.get().contains(entity.getEncodeId());
        }
        return true;
    };
    public static BooleanCache<LivingEntity> TARGET_SELECTOR = new BooleanCache<>(8, TARGET_SELECTOR_PREDICATE);

    public static List<Item> helmetList(){
        List<Item> values = new ArrayList<>();
        for (String string : SConfig.SERVER.gas_masks.get()){
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(string));
            if (item != null){
                values.add(item);
            }
        }
        return values;
    }

    public static List<BlockState> biomass(){
        List<BlockState> states = new ArrayList<>();
        states.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.MEMBRANE_BLOCK.get().defaultBlockState());
        states.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        states.add(Sblocks.ROOTED_MYCELIUM.get().defaultBlockState());
        states.add(Sblocks.GASTRIC_BIOMASS.get().defaultBlockState());
        return states;
    }

    public static Vec3 generatePositionAway(Vec3 origin, double distance) {
        Random random = new Random();
        double theta = random.nextDouble() * 2 * Math.PI; // Random angle around the z-axis (0 to 2π)
        double phi = Math.acos(2 * random.nextDouble() - 1); // Random angle from the z-axis (0 to π)
        // Convert spherical coordinates to Cartesian coordinates for the offset
        double offsetX = Math.sin(phi) * Math.cos(theta) * distance;
        double offsetY = Math.sin(phi) * Math.sin(theta) * distance;
        double offsetZ = Math.cos(phi) * distance;
        // Generate the new position
        return new Vec3(origin.x + offsetX, origin.y + offsetY,origin.z + offsetZ);
    }

    public static List<Item> getItemsFromTag(String namespace, String tagName) {
        TagKey<Item> tagKey = TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation(namespace, tagName));
        return BuiltInRegistries.ITEM.getTag(tagKey)
                .map(holderSet -> holderSet.stream().map(Holder::value).collect(Collectors.toList()))
                .orElse(List.of());  // Return an empty list if no items are found
    }

    public static void doCustomModifiersAfterEffects(LivingEntity attacker,LivingEntity victim){
        AttributeInstance corrosion = attacker.getAttribute(SAttributes.CORROSIVES.get());
        if(corrosion != null){
            double level = corrosion.getValue();
            if (level < 1){
                return;
            }
            victim.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),300,(int) level-1),attacker);
        }
        AttributeInstance toxic = attacker.getAttribute(SAttributes.TOXICITY.get());
        if(toxic != null){
            double level = toxic.getValue();
            if (level < 1){
                return;
            }
            victim.addEffect(new MobEffectInstance(MobEffects.POISON,400,(int) level-1),attacker);
        }
        AttributeInstance local = attacker.getAttribute(SAttributes.LOCALIZATION.get());
        if(local != null){
            double level = local.getValue();
            if (level < 1){
                return;
            }
            victim.addEffect(new MobEffectInstance(Seffects.MARKER.get(),600,(int) level-1),attacker);
        }

        AttributeInstance grind = attacker.getAttribute(SAttributes.GRINDING.get());
        if(grind != null){
            double level = grind.getValue();
            if (level < 1){
                return;
            }
            victim.getArmorSlots().forEach(itemStack -> {itemStack.setDamageValue((int) (itemStack.getDamageValue()+(10*level)));});
        }
    }
}
