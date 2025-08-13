package net.ruddez.vapemod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

abstract class VapeParent extends Item {
    public VapeParent(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);

        return ActionResult.SUCCESS;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        // Calculate how long the item was used
        int usedTicks = this.getMaxUseTime(stack, user) - remainingUseTicks;
        int chargeTime = 10;

        if (usedTicks >= chargeTime) {
            if (!world.isClient && world instanceof ServerWorld serverWorld) {
                // Get a player's position and direction
                Vec3d playerPos = user.getPos();
                Vec3d lookDirection = user.getRotationVector();

                // Calculate position in front of the player (1.5 blocks forward, at head level)
                Vec3d spawnPos = playerPos
                        .add(lookDirection.multiply(1.5))
                        .add(0, user.getStandingEyeHeight(), 0);

                // Spawn particles in front of the player
                for (int i = 0; i < 10; i++) {
                    // Add some randomness to particle positions
                    double offsetX = (world.random.nextDouble() - 0.5) * 0.3;
                    double offsetY = (world.random.nextDouble() - 0.5) * 0.3;
                    double offsetZ = (world.random.nextDouble() - 0.5) * 0.3;

                    particleSpawn(serverWorld, spawnPos.add(offsetX, offsetY, offsetZ));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    abstract public void particleSpawn(ServerWorld serverWorld, Vec3d spawnPos);
}