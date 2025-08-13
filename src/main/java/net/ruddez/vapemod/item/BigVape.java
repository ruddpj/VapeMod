package net.ruddez.vapemod.item;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class BigVape extends VapeParent {
    public BigVape(Settings settings) {
        super(settings);
    }

    @Override
    public void particleSpawn(ServerWorld serverWorld, Vec3d spawnPos) {
            serverWorld.spawnParticles(
                    ParticleTypes.SNOWFLAKE, // Particle type
                    spawnPos.x,
                    spawnPos.y,
                    spawnPos.z,
                    16, // Count
                    0.3, 0.3, 0.3, // Delta X, Y, Z
                    0.01 // Speed
            );
    }
}
