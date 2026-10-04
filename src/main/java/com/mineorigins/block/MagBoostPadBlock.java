package com.mineorigins.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * Draconium Mag-Boost Pad:
 * High-friction propulsion surface used across Dragon City's suspended raceways.
 * Propels entities forward along their facing direction and applies a Speed buff.
 */
public class MagBoostPadBlock extends Block {

    public MagBoostPadBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof LivingEntity living) {
                // Apply Draconium overdrive speed buff (Speed IV for 3 seconds)
                living.addEffect(new MobEffectInstance(MobEffects.SPEED, 60, 3, true, false, true));
            }

            // Impulse boost along entity's look vector
            Vec3 motion = entity.getDeltaMovement();
            Vec3 look = entity.getLookAngle();
            double boost = 1.6;
            entity.setDeltaMovement(new Vec3(look.x * boost, Math.max(motion.y, 0.08), look.z * boost));
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(3) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + random.nextDouble();
            level.addParticle(ParticleTypes.ELECTRIC_SPARK, x, y, z, 0.0, 0.08, 0.0);
        }
    }
}
