package com.Harbinger.Spore.Sentities.MovementControls.PathFinders;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.pathfinder.FlyNodeEvaluator;
import net.minecraft.world.level.pathfinder.Node;

public class CachedFlyNodeEvaluator extends FlyNodeEvaluator {
    private final Object2ObjectOpenHashMap<BlockPos, Node> nodeCache = new Object2ObjectOpenHashMap<>();
    private Level level;

    @Override
    public void prepare(PathNavigationRegion region, Mob mob) {
        super.prepare(region, mob);
        this.nodeCache.clear();
        level = mob.level();
    }
    @Override
    public Node getNode(int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        Node cached = nodeCache.get(pos);
        if (cached != null) return cached;

        Node node = super.getNode(x, y, z);
        nodeCache.put(pos, node);
        return node;
    }
    private boolean isValidNode(int x, int y, int z) {
        var type = this.getBlockPathType(this.level, x, y, z);
        return type == net.minecraft.world.level.pathfinder.BlockPathTypes.OPEN
                || type == net.minecraft.world.level.pathfinder.BlockPathTypes.WALKABLE;
    }
    private boolean isFlyable(BlockPos pos) {
        if (level == null || level.isClientSide()){
            return false;
        }
        return FlyPathCache.isAir(level, pos)
                && FlyPathCache.isAir(level, pos.above())
                && FlyPathCache.isAir(level, pos.below());
    }

    @Override
    public int getNeighbors(Node[] neighbors, Node node) {
        int count = 0;

        for (Direction dir : Direction.values()) {
            int x = node.x + dir.getStepX();
            int y = node.y + dir.getStepY();
            int z = node.z + dir.getStepZ();

            if (!isValidNode(x, y, z)) continue;

            BlockPos pos = new BlockPos(x, y, z);
            if (!isFlyable(pos)) continue;

            Node n = getNode(x, y, z);
            n.costMalus = Math.abs(dir.getStepY()) > 0 ? 0.6f : 1f;
            neighbors[count++] = n;
        }

        // diagonals (same fix applied)
        count = addDiagSafe(neighbors, node, count, 1,0,1);
        count = addDiagSafe(neighbors, node, count,-1,0,1);
        count = addDiagSafe(neighbors, node, count, 1,0,-1);
        count = addDiagSafe(neighbors, node, count,-1,0,-1);
        count = addDiagSafe(neighbors, node, count, 0,1,1);
        count = addDiagSafe(neighbors, node, count, 0,1,-1);
        count = addDiagSafe(neighbors, node, count, 0,-1,1);
        count = addDiagSafe(neighbors, node, count, 0,-1,-1);

        return count;
    }

    private int addDiagSafe(Node[] neighbors, Node node, int count, int dx, int dy, int dz) {
        int x = node.x + dx;
        int y = node.y + dy;
        int z = node.z + dz;

        if (!isValidNode(x,y,z)) return count;

        BlockPos pos = new BlockPos(x, y, z);
        if (!isFlyable(pos)) return count;

        Node n = getNode(x, y, z);
        n.costMalus = Math.abs(dy) > 0 ? 0.6f : 1f;
        neighbors[count++] = n;
        return count;
    }

    @Override
    public Node getStart() {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int x = net.minecraft.util.Mth.floor(this.mob.getX());
        int y = net.minecraft.util.Mth.floor(this.mob.getY());
        int z = net.minecraft.util.Mth.floor(this.mob.getZ());

        pos.set(x, y, z);

        while (y < this.mob.level().getMaxBuildHeight() && !isFlyable(pos)) {
            y++;
            pos.setY(y);
        }

        return this.getNode(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public net.minecraft.world.level.pathfinder.Target getGoal(double x, double y, double z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(
                net.minecraft.util.Mth.floor(x),
                net.minecraft.util.Mth.floor(y),
                net.minecraft.util.Mth.floor(z)
        );

        while (pos.getY() < this.mob.level().getMaxBuildHeight() && !isFlyable(pos)) {
            pos.move(Direction.UP);
        }

        Node node = this.getNode(pos.getX(), pos.getY(), pos.getZ());
        return new net.minecraft.world.level.pathfinder.Target(node);
    }
}