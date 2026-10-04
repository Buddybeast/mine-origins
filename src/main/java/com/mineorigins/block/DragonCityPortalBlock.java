package com.mineorigins.block;

import com.mineorigins.worldgen.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DragonCityPortalBlock extends Block {

    public DragonCityPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, net.minecraft.world.entity.InsideBlockEffectApplier effectApplier, boolean bl) {
        if (!level.isClientSide() && entity.canUsePortal(false)) {
            if (entity instanceof ServerPlayer player) {
                ServerLevel currentLevel = player.level();
                boolean isInDragonCity = currentLevel.dimension().equals(ModDimensions.DRAGON_CITY_LEVEL);

                ServerLevel targetLevel = isInDragonCity
                        ? currentLevel.getServer().getLevel(Level.OVERWORLD)
                        : currentLevel.getServer().getLevel(ModDimensions.DRAGON_CITY_LEVEL);

                if (targetLevel != null) {
                    BlockPos targetPos = isInDragonCity
                            ? targetLevel.getRespawnData().pos()
                            : new BlockPos(0, 200, 0); // Arrive at Mid City/Suspended Tier

                    if (!isInDragonCity) {
                        ensureArrivalPlatform(targetLevel, targetPos);
                    }

                    Vec3 targetVec = Vec3.atBottomCenterOf(targetPos.above());
                    TeleportTransition transition = new TeleportTransition(
                            targetLevel,
                            targetVec,
                            Vec3.ZERO,
                            player.getYRot(),
                            player.getXRot(),
                            TeleportTransition.PLAY_PORTAL_SOUND
                    );
                    player.teleport(transition);
                    player.setPortalCooldown(100);
                }
            }
        }
    }

    /**
     * Builds a safe landing platform in Dragon City made of Smooth Stone & Polished Blackstone
     */
    private static void ensureArrivalPlatform(ServerLevel level, BlockPos center) {
        for (int dx = -3; dx <= 3; dx++) {
            for (int dz = -3; dz <= 3; dz++) {
                BlockPos p = center.offset(dx, 0, dz);
                if (Math.abs(dx) == 3 || Math.abs(dz) == 3) {
                    level.setBlock(p, Blocks.POLISHED_BLACKSTONE.defaultBlockState(), 3);
                } else {
                    level.setBlock(p, Blocks.SMOOTH_STONE.defaultBlockState(), 3);
                }

                // Clear vertical clearance above the platform
                for (int dy = 1; dy <= 4; dy++) {
                    BlockPos airPos = center.offset(dx, dy, dz);
                    if (!level.isEmptyBlock(airPos)) {
                        level.removeBlock(airPos, false);
                    }
                }
            }
        }

        // Place a return portal
        BlockPos portalPos = center.above();
        if (level.isEmptyBlock(portalPos)) {
            level.setBlock(portalPos, ModBlocks.DRAGON_CITY_PORTAL_BLOCK.defaultBlockState(), 3);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(100) == 0) {
            level.playLocalSound(
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    SoundEvents.PORTAL_AMBIENT,
                    SoundSource.BLOCKS,
                    0.5f,
                    random.nextFloat() * 0.3f + 0.6f,
                    false
            );
        }

        // Golden and shadow/smoke particles
        for (int i = 0; i < 2; i++) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();

            // Golden sparks
            level.addParticle(ParticleTypes.ELECTRIC_SPARK, x, y, z, 0.0, 0.03, 0.0);

            // Black/smoke accents for the golden-black aesthetic
            if (random.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.02, 0.0);
            }
        }
    }
}
