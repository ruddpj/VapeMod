package net.ruddez.vapemod.item;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class Vape extends VapeParent{
    public Vape(Settings settings) {
        super(settings);
    }

    @Override
    public void particleSpawn(ServerWorld serverWorld, Vec3d spawnPos) {
        serverWorld.spawnParticles(
                ParticleTypes.SNOWFLAKE, // Particle type
                spawnPos.x,
                spawnPos.y,
                spawnPos.z,
                4, // Count
                0.2, 0.2, 0.2, // Delta X, Y, Z
                0.01 // Speed
        );
    }
}
