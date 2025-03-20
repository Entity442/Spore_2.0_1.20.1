package com.Harbinger.Spore.Sentities.AI.NeuralProcessing.ProtoAIs;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.NeuralProcessing.NeuralNetwork;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ProtoDefense extends Goal {
    public final Proto proto;
    public final NeuralNetwork brain;
    private final RandomSource randomSource = RandomSource.create();
    public ProtoDefense(Proto proto1){
        this.proto = proto1;
        brain = proto1.getNetwork();
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.proto.getTarget();
        if (target != null && this.proto.tickCount % 200 == 0){
            double[] inputs = gatherInputs(target);
            double decision = brain.computeOutput(inputs, target.getEncodeId());
            return decision > 0.5;
        }
        return false;
    }
    @Override
    public void start() {
        LivingEntity target = this.proto.getTarget();
        if (target != null){
            for (int i = 0; i<randomSource.nextInt(3,6);i++){
                SummonDefense(target);
            }
        }
        super.start();
    }

    protected boolean checkForOrganoids(Entity entity){
        AABB aabb = entity.getBoundingBox().inflate(12);
        List<Entity> entities = proto.level().getEntities(proto,aabb, entity1 -> {return entity1 instanceof Organoid;});
        return entities.size() <= 4;
    }
    private void SummonDefense(Entity target) {
        List<? extends String> summons = SConfig.SERVER.proto_summonable_troops.get();
        int x = randomSource.nextInt(-10,10);
        int z = randomSource.nextInt(-10,10);
        if (target != null && proto.level() instanceof ServerLevelAccessor world){
            RandomSource rand = RandomSource.create();
            int randomIndex = rand.nextInt(summons.size());
            ResourceLocation randomElement1 = new ResourceLocation(summons.get(randomIndex));
            EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
            Mob waveentity = (Mob) randomElement.create(proto.level());
            if (waveentity != null){
                waveentity.randomTeleport(target.getX() + x,target.getY(),target.getZ() + z,false);
                if (waveentity instanceof Mound mound){
                    mound.setMaxAge(1);
                    mound.setLinked(true);
                }
                if (waveentity instanceof Vigil vigil){
                    vigil.setProto(proto);
                }
                if (checkTheGround(waveentity.getOnPos(),waveentity.level())){
                    waveentity.finalizeSpawn(world, waveentity.level().getCurrentDifficultyAt(new BlockPos((int) waveentity.getX(),(int)  waveentity.getY(),(int)  waveentity.getZ())), MobSpawnType.NATURAL, null, null);
                    proto.level().addFreshEntity(waveentity);
                }
            }
        }
    }

    private boolean checkTheGround(BlockPos pos, Level level){
        for (int i = 0;i < 3;i++){
            BlockState state = level.getBlockState(pos.below(i));
            if (state.getDestroySpeed(level,pos.below(i)) > 4 || state.isAir()){
                return false;
            }
        }
        return true;
    }

    private double[] gatherInputs(LivingEntity entity) {
        double healthRatio = entity.getHealth() / entity.getMaxHealth();
        double randomFactor = proto.getRandom().nextDouble();
        double distance = entity.distanceToSqr(proto) < 200 ? 1.0 : 0.0;
        double hasReinforcements = checkForOrganoids(entity) ? 0.0 : 1.0;
        double dangerLevel = calculateDangerLevel(entity);
        double bestDamageEffectiveness = getBestDamageEffectiveness(brain);
        return new double[]{healthRatio, randomFactor, distance, hasReinforcements, dangerLevel, bestDamageEffectiveness};
    }
    private double calculateDangerLevel(LivingEntity entity) {
        double healthRatio = entity.getMaxHealth();
        double armorRatio = entity.getArmorValue();
        if (healthRatio < 10) return 1.0;
        if (healthRatio <= 15 || (armorRatio > 0 && armorRatio <= 5)) return 2.0;
        if (healthRatio <= 20 || (armorRatio > 5 && armorRatio <= 10)) return 3.0;
        if (healthRatio > 20 || (armorRatio > 10 && armorRatio <= 20)) return 4.0;
        return 5.0;
    }
    private double getBestDamageEffectiveness(NeuralNetwork neuralNetwork) {
        return neuralNetwork.getDamageEffectiveness(neuralNetwork.getMostEffectiveDamageType());
    }
}