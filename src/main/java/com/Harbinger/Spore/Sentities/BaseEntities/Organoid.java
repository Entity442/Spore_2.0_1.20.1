package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class Organoid extends UtilityEntity implements Enemy {
    protected Organoid(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.onGround()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
        }
    }

    protected void addTargettingGoals(){
        this.goalSelector.addGoal(2, new HurtTargetGoal(this , entity -> {return !(SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()) || entity instanceof UtilityEntity || entity instanceof Infected);}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, Player.class,  true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return SConfig.SERVER.whitelist.get().contains(en.getEncodeId()) || (en.hasEffect(Seffects.MARKER.get()) && !this.likedFellows(en));
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return !(this.otherWorld(en) || this.SkulkLove(en) || this.likedFellows(en)) && SConfig.SERVER.at_mob.get();
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, 5, false, true, (en) -> {
            return !SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) && SConfig.SERVER.at_an.get();
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return !this.likedFellows(en) && SConfig.SERVER.at_mob.get() && ((this.otherWorld(en) && SConfig.SERVER.faw_target.get())
                    || (this.SkulkLove(en) && SConfig.SERVER.skulk_target.get()));
        }));
    }
    @Override
    public boolean dampensVibrations() {
        return true;
    }


    public boolean otherWorld(Entity entity){
        return entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("fromanotherworld:things")));
    }

    public boolean SkulkLove(Entity entity){
        return entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("sculkhorde:sculk_entity")));
    }

    public boolean likedFellows(Entity en){
        return en instanceof Animal || en instanceof AbstractFish || en instanceof Infected || en instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(en.getEncodeId());
    }
}
