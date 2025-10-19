package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.IkLegWithHitbox;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class Tentacle extends UtilityEntity {
    private final TentaclePart[] completeArray;
    private final IkLegWithHitbox rightFrontHitbox;
    private final IkLegWithHitbox leftFrontHitbox;
    private final IkLegWithHitbox rightBackHitbox;
    private final IkLegWithHitbox leftBackHitbox;
    private final IkLegWithHitbox[] IkLegs;
    public Tentacle(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        TentaclePart part0 = new TentaclePart(this, "segment0", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part1 = new TentaclePart(this, "segment1", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part2 = new TentaclePart(this, "segment2", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part3 = new TentaclePart(this, "segment3", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part4 = new TentaclePart(this, "segment4", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part5 = new TentaclePart(this, "segment5", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part6 = new TentaclePart(this, "segment6", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part7 = new TentaclePart(this, "segment7", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part8 = new TentaclePart(this, "segment8", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part9 = new TentaclePart(this, "segment9", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part10 = new TentaclePart(this, "segment10", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        TentaclePart part11 = new TentaclePart(this, "segment11", new EntityDimensions(0.5f, 0.5f, false), 1.0f);
        this.completeArray = new TentaclePart[]{
                part0, part1, part2, part3, part4, part5,
                part6, part7, part8, part9, part10, part11
        };
        this.rightFrontHitbox = new IkLegWithHitbox(this,new TentaclePart[]{part0, part1, part2},LEGS.RIGHT_FRONT.getBodySet(),LEGS.RIGHT_FRONT.getOffset(),8,1,1.25f,0.5f,0.6f,40);
        this.leftFrontHitbox = new IkLegWithHitbox(this,new TentaclePart[]{part3, part4, part5},LEGS.LEFT_FRONT.getBodySet(),LEGS.LEFT_FRONT.getOffset(),8,1,1.25f,0.5f,0.6f,40);
        this.rightBackHitbox = new IkLegWithHitbox(this,new TentaclePart[]{part6, part7, part8},LEGS.RIGHT_BACK.getBodySet(),LEGS.RIGHT_BACK.getOffset(),8,1,1.25f,0.5f,0.6f,40);
        this.leftBackHitbox = new IkLegWithHitbox(this,new TentaclePart[]{part9, part10, part11},LEGS.LEFT_BACK.getBodySet(),LEGS.LEFT_BACK.getOffset(),8,1,1.25f,0.5f,0.6f,40);
        this.IkLegs = new IkLegWithHitbox[]{rightFrontHitbox,leftFrontHitbox,rightBackHitbox,leftBackHitbox};
        int baseId = ENTITY_COUNTER.getAndAdd(this.completeArray.length + 1);
        this.setId(baseId);
        setMaxUpStep(1f);
    }
    public enum LEGS{
        RIGHT_FRONT(new Vec3(0.5, 0.5, -0.5), new Vec3(3, -0.5, -3)),   // Front right
        LEFT_FRONT(new Vec3(0.5, 0.5, 0.5), new Vec3(3, -0.5, 3)),  // Front left
        RIGHT_BACK(new Vec3(-0.5, 0.5, -0.5), new Vec3(-3, -0.5, -3)),      // Back right
        LEFT_BACK(new Vec3(-0.5, 0.5, 0.5), new Vec3(-3, -0.5, 3));     // Back left

        private final Vec3 bodySet;
        private final Vec3 offset;

        LEGS(Vec3 bodySet, Vec3 offset) {
            this.bodySet = bodySet;
            this.offset = offset;
        }

        public Vec3 getOffset(){
            return offset;
        }
        public Vec3 getBodySet(){
            return bodySet;
        }
    }

    @Override
    public void setId(int entityId) {
        super.setId(entityId);
        for (int i = 0; i < this.completeArray.length; i++) {
            this.completeArray[i].setId(entityId + i + 1);
        }
    }
    public PartEntity<?>[] getRightSegments(){return rightFrontHitbox.getEntities();}
    public PartEntity<?>[] getLeftSegments(){return leftFrontHitbox.getEntities();}
    public PartEntity<?>[] getRightBackSegments(){return rightBackHitbox.getEntities();}
    public PartEntity<?>[] getLeftBackSegments(){return leftBackHitbox.getEntities();}

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.mound_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.mound_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.3);

    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        for(int i = 0; i < completeArray.length; ++i) {
            completeArray[i].setId(i + clientboundAddEntityPacket.getId());
        }
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.completeArray;
    }


    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        super.registerGoals();
        this.goalSelector.addGoal(1,new MeleeAttackGoal(this,1,true));
        this.goalSelector.addGoal(4,new RandomStrollGoal(this,1));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        IkLegWithHitbox[] diagonalPair1 = new IkLegWithHitbox[]{IkLegs[0], IkLegs[2]}; // RF + LB
        IkLegWithHitbox[] diagonalPair2 = new IkLegWithHitbox[]{IkLegs[1], IkLegs[3]}; // LF + RB
        int stepInterval = 30;
        int stepCycleTicks = 60;
        if (tickCount % stepInterval == 0) {
            if (tickCount % stepCycleTicks == 0){
                for (IkLegWithHitbox leg : diagonalPair1){
                    leg.refreshLegStandingPoint();
                }
            }else {
                for (IkLegWithHitbox leg : diagonalPair2){
                    leg.refreshLegStandingPoint();
                }
            }
        }
        for (IkLegWithHitbox leg : IkLegs) {
            leg.applyIK();
            spawnParticlesInPlaces(leg.getSitPosition(), leg, false);
            spawnParticlesInPlaces(leg.getSitPosition(), leg, true);
        }
    }
    private void spawnParticlesInPlaces(Vec3 vec3, IkLegWithHitbox legs,boolean fire){
        if (fire){
            Vec3 positionOnBody = legs.getDefaultBodyOffset();
            level().addParticle(ParticleTypes.SOUL_FIRE_FLAME,positionOnBody.x,positionOnBody.y,positionOnBody.z,0,0.2,0);
        }else {
            if (vec3 != null){
                level().addParticle(ParticleTypes.FLAME,vec3.x,vec3.y,vec3.z,0,0.2,0);
            }
        }
    }

    public boolean hurt(TentaclePart tentaclePart, DamageSource source, float amount) {
        return this.hurt(source,amount * 0.25f);
    }

}