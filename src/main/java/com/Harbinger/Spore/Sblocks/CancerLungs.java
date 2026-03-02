package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sparticles;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CancerLungs extends HangingRootsBlock {
    public CancerLungs() {
        super(Properties.of().strength(4f, 2f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK));
    }
    protected static final VoxelShape SHAPE = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public VoxelShape getShape(BlockState p_153342_, BlockGetter p_153343_, BlockPos p_153344_, CollisionContext p_153345_) {
        return SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void animateTick(BlockState state, Level level,
                            BlockPos pos, RandomSource random) {
        Entity entity = Minecraft.getInstance().cameraEntity;
        if (entity == null) return;
        double maxDistance = 12.0D;
        double maxDistanceSq = maxDistance * maxDistance;
        if (entity.distanceToSqr(
                pos.getX() + 0.5D,
                pos.getY() + 0.5D,
                pos.getZ() + 0.5D) > maxDistanceSq) {
            return;
        }
        if (random.nextFloat() < 0.6f) {

            double radius = 3D;

            double px = pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * radius;
            double py = pos.getY() + 0.5D + random.nextDouble() * 1.5D * -radius;
            double pz = pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * radius;

            // Target center of block
            double centerX = pos.getX() + 0.5D;
            double centerY = pos.getY() + 0.75D;
            double centerZ = pos.getZ() + 0.5D;

            // Direction toward center
            double dx = centerX - px;
            double dy = centerY - py;
            double dz = centerZ - pz;

            // Normalize + scale speed
            double speed = 0.25D;
            double length = Math.sqrt(dx * dx + dy * dy + dz * dz);

            dx = (dx / length) * speed;
            dy = (dy / length) * speed;
            dz = (dz / length) * speed;

            level.addParticle(
                    Sparticles.SPORE_PARTICLE.get(),
                    px, py, pz,
                    dx, dy, dz
            );
        }
    }

}
