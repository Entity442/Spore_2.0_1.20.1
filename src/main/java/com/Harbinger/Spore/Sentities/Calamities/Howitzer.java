package com.Harbinger.Spore.Sentities.Calamities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Howitzer extends Calamity implements TrueCalamity {
    private final CalamityMultipart[] subEntities;
    public final CalamityMultipart rightArm;
    public final CalamityMultipart leftArm;
    public final CalamityMultipart mouth;
    public Howitzer(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.rightArm = new CalamityMultipart(this, "rightarm", 2F, 4F);
        this.leftArm = new CalamityMultipart(this, "leftarm", 2F, 4F);
        this.mouth = new CalamityMultipart(this, "mouth", 4F, 3F);
        this.subEntities = new CalamityMultipart[]{ this.rightArm, this.leftArm,this.mouth};
        this.setMaxUpStep(1.5F);
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(p_20235_ + i + 1);
    }

    @Override
    public void chemAttack() {

    }

    @Override
    public void registerGoals() {
        super.registerGoals();

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sieger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sieger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sieger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public void aiStep() {
        float f14 = this.getYRot() * ((float)Math.PI/180);
        float f2 = Mth.sin(f14);
        float f15 = Mth.cos(f14);
        Vec3[] avec3 = new Vec3[this.subEntities.length];
        for(int j = 0; j < this.subEntities.length; ++j) {
            avec3[j] = new Vec3(this.subEntities[j].getX(), this.subEntities[j].getY(), this.subEntities[j].getZ());
        }
        this.tickPart(this.mouth, (double)(f2*0.5f), 5.0D, (double)(-f15 *0.5f));
        this.tickPart(this.rightArm, (double)(f2 * 5F), 0.0D, (double)(-f15*3f));
        this.tickPart(this.leftArm, (double)(f2 *-5.2F), 0.0D, (double)(-f15 * -2f));
        for(int l = 0; l < this.subEntities.length; ++l) {
            this.subEntities[l].xo = avec3[l].x;
            this.subEntities[l].yo = avec3[l].y;
            this.subEntities[l].zo = avec3[l].z;
            this.subEntities[l].xOld = avec3[l].x;
            this.subEntities[l].yOld = avec3[l].y;
            this.subEntities[l].zOld = avec3[l].z;
        }
        super.aiStep();
    }

    public CalamityMultipart[] getSubEntities() {
        return this.subEntities;
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_218825_) {
        super.recreateFromPacket(p_218825_);
        if (true) return;
        CalamityMultipart[] calamityMultiparts = this.getSubEntities();

        for(int i = 0; i < calamityMultiparts.length; ++i) {
            calamityMultiparts[i].setId(i + p_218825_.getId());
        }

    }
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        if (calamityMultipart == this.mouth){
            this.hurt(source,value*2f);
        }else if (calamityMultipart == this.rightArm){
            this.hurt(source,value *1.5f);
        }else if (calamityMultipart == this.leftArm){
            this.hurt(source,value*1.5f);
        } else{
            this.hurt(source,value );
        }
        return true;
    }


    @Override
    protected int calculateFallDamage(float value1, float value2) {
        damageStomp(this.level(),this.getOnPos(),8,10);
        return 0;
    }
    protected void damageStomp(Level level, BlockPos pos,double range,double damageRange){
        AABB aabb = this.getBoundingBox().inflate(damageRange);
        List<Entity> entities = level.getEntities(this,aabb,entity -> {return entity instanceof LivingEntity living && TARGET_SELECTOR.test(living);});
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            BlockState state = level.getBlockState(blockpos);
                            boolean airAbove = level.getBlockState(blockpos.above()).isAir();
                            boolean airBelow = level.getBlockState(blockpos.below()).isAir();
                            if (state.isSolidRender(level,blockpos) && level instanceof ServerLevel serverLevel){
                                if (airAbove){
                                    ItemStack stack = new ItemStack(state.getBlock().asItem());
                                    serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM,stack),blockpos.getX(), blockpos.getY()+0.3f, blockpos.getZ(),3,(this.random.nextFloat() - 1D) * 0.08D, (this.random.nextFloat() - 1D) * 0.08D, (this.random.nextFloat() - 1D) * 0.08D,0.15F);
                                }
                                if (airBelow){
                                    FallingBlockEntity.fall(serverLevel,blockpos,state);
                                    serverLevel.removeBlock(blockpos,false);
                                }
                            }

                        }}}}}
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living)
            for (int i = 0;i<2;i++){
                this.doHurtTarget(living);
                living.hurtTime = 0;
                living.invulnerableTime = 0;
            }
        }
    }
}
