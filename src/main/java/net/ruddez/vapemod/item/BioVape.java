package net.ruddez.vapemod.item;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class BioVape extends VapeParent {
    public BioVape(Settings settings) {
        super(settings);
    }

    @Override
    public void particleSpawn(ServerWorld serverWorld, Vec3d spawnPos) {
        serverWorld.spawnParticles(
                ParticleTypes.SMOKE, // Particle type
                spawnPos.x,
                spawnPos.y,
                spawnPos.z,
                16, // Count
                0.1, 0.1, 0.1, // Delta X, Y, Z
                0.01 // Speed
        );
    }
}
