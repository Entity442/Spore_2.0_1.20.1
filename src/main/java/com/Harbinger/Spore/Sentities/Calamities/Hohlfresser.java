package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.CalamityInfectedCommand;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SporeBurstSupport;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.SummonScentInCombat;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Hohlfresser extends Calamity implements TrueCalamity {
    private final List<HohlMultipart> subEntities = new ArrayList<>();
    public final HohlMultipart seg1;
    public final HohlMultipart seg2;
    public final HohlMultipart seg3;
    public final HohlMultipart seg4;
    public final HohlMultipart seg5;
    private int segmentTime = 0;
    public Hohlfresser(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.seg1 = new HohlMultipart(this, "seg1", 2F, 2F,new Vec3(-1.5D,0D,0D),2.1f);
        this.seg2 = new HohlMultipart(this, "seg2", 2F, 2F,new Vec3(-4.75D,0D,0D),2f);
        this.seg3 = new HohlMultipart(this, "seg3", 2F, 2F,new Vec3(-8D,0D,0D),1.8f);
        this.seg4 = new HohlMultipart(this, "seg4", 2F, 2F,new Vec3(-11.25D,0D,0D),1.7f);
        this.seg5 = new HohlMultipart(this, "seg5", 2F, 2F,new Vec3(-14.5D,0D,0D),1.6f);
        this.subEntities.add(seg1);
        this.subEntities.add(seg2);
        this.subEntities.add(seg3);
        this.subEntities.add(seg4);
        this.subEntities.add(seg5);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.size() + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.size(); i++)
            this.subEntities.get(i).setId(p_20235_ + i + 1);
    }
    public List<HohlMultipart> getSubEntities() {
        return this.subEntities;
    }
    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return subEntities.toArray(new net.minecraftforge.entity.PartEntity<?>[0]);
    }
    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        CalamityMultipart[] calamityMultiparts = this.getSubEntities()
                .toArray(new CalamityMultipart[0]);

        for (int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + packet.getId());
        }
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }


    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        this.hurt(source,value);
        return false;
    }

    @Override
    public int chemicalRange() {
        return 16;
    }

    @Override
    public List<? extends String> buffs() {
        return SConfig.SERVER.sieger_buffs.get();
    }

    @Override
    public List<? extends String> debuffs() {
        return SConfig.SERVER.sieger_debuffs.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.23)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public void aiStep() {
        super.aiStep();
        segmentTime +=1;
    }

    @Override
    public void tick() {
        super.tick();
        applyIK();
    }

    public void applyIK() {
        List<HohlMultipart> parts = getSubEntities();
        for (int i = 0; i < parts.size(); i++) {
            parts.get(i).tickMovement(segmentTime,i);
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(4, new AOEMeleeAttackGoal(this, 1.5, false,2.5 ,6, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            protected double getAttackReachSqr(LivingEntity entity) {
                float f = Hohlfresser.this.getBbWidth();
                return (double)(f * 3.0F * f * 3.0F + entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.2));
        this.goalSelector.addGoal(6,new CalamityInfectedCommand(this));
        this.goalSelector.addGoal(7,new SummonScentInCombat(this));
        this.goalSelector.addGoal(8,new SporeBurstSupport(this));
        this.goalSelector.addGoal(9,new RandomStrollGoal(this , 1));
        super.registerGoals();
    }
}
