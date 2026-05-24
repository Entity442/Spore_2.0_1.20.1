package com.Harbinger.Spore.Sentities;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AmbientSparks{
    public int life;
    public final Vec3 Connection;
    @Nullable
    public final Entity living;
    public final LivingEntity owner;
    public final int maxLife;
    protected final Vec3 spawnPoint;
    protected final RandomSource random = RandomSource.create();
    protected List<Vec3> connections = new ArrayList<>();
    protected final RandomSource randomSource = RandomSource.create();

    public AmbientSparks(Vec3 connection, @Nullable Entity living, LivingEntity owner, int maxLife) {
        Connection = connection;
        this.living = living;
        this.owner = owner;
        this.maxLife = maxLife;
        this.spawnPoint = Vec3.ZERO;
    }
    public AmbientSparks(Vec3 connection, @Nullable Entity living, LivingEntity owner,Vec3 spawnPoint, int maxLife) {
        Connection = connection;
        this.living = living;
        this.owner = owner;
        this.maxLife = maxLife;
        this.spawnPoint = spawnPoint;
    }

    private void rebuildChain(Vec3 start, Vec3 end){

        double distance = start.distanceTo(end);

        int desiredSegments = Mth.clamp((int)(distance * 2), 4, 40);

        if(desiredSegments == connections.size()) return;

        connections.clear();

        for(int i = 0; i < desiredSegments; i++){

            double t = (double)i/(desiredSegments-1);

            connections.add(new Vec3(
                    Mth.lerp(t,start.x,end.x),
                    Mth.lerp(t,start.y,end.y),
                    Mth.lerp(t,start.z,end.z)
            ));
        }
    }
    public List<Vec3> getConnections(){
        return connections;
    }

    public void TickSpark(){
        life++;
        Vec3 vec3 = living == null ? Connection : living.position().add(0,living.getBbHeight()/2,0);
        double rng = (random.nextFloat() - random.nextFloat()) * 0.05;
        Vec3 basePosition = spawnPoint == Vec3.ZERO ? owner.position().add(rng,2.2,rng) : spawnPoint.add(rng,rng,rng);
        if (connections.isEmpty()){
            rebuildChain(basePosition,vec3);
        }
        applyIK(connections,basePosition,vec3);
    }
    protected void moveSegmentTowards(List<Vec3> entities,int index, Vec3 target) {
        double random = (randomSource.nextFloat() - randomSource.nextFloat()) * 0.1;
        entities.set(index,target.add(random,random,random));
    }
    public void applyIK(List<Vec3> entities , Vec3 basePos,Vec3 camera) {
        if (entities == null || entities.size() < 3) return;
        moveSegmentTowards(entities,entities.size()-1, camera);
        for (int i = entities.size() - 2; i >= 0; i--) {
            Vec3 nextPos = entities.get(i + 1);
            Vec3 dir = entities.get(i).subtract(nextPos);

            float segmentLength = 1f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = nextPos.add(dir);
            moveSegmentTowards(entities,i, solvedPos);
        }
        entities.set(0,basePos);

        for (int i = 1; i < entities.size(); i++) {
            Vec3 prevPos = entities.get(i - 1);
            Vec3 dir = entities.get(i).subtract(prevPos);

            float segmentLength = 1f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(entities,i, solvedPos);
        }
    }
}