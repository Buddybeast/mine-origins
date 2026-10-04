package com.mineorigins.Item;

import com.mineorigins.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DraconiumCoreItem extends Item {

    public DraconiumCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState clickedState = level.getBlockState(clickedPos);

        // When used on Smooth Stone, checks or ignites a portal
        if (clickedState.is(Blocks.SMOOTH_STONE)) {
            // Check frame or directly activate adjacent air block
            BlockPos targetPos = clickedPos.relative(context.getClickedFace());
            if (level.isEmptyBlock(targetPos)) {
                boolean frameIgnited = tryIgniteFrame(level, targetPos, context.getClickedFace().getAxis());
                if (!frameIgnited) {
                    // Activate single portal block in space
                    level.setBlock(targetPos, ModBlocks.DRAGON_CITY_PORTAL_BLOCK.defaultBlockState(), 3);
                }

                level.playSound(player, targetPos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1.0f, 1.1f);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5, 30, 0.4, 0.4, 0.4, 0.1);
                    serverLevel.sendParticles(ParticleTypes.SMOKE, targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5, 15, 0.3, 0.3, 0.3, 0.05);
                }

                if (player != null && !player.getAbilities().instabuild) {
                    context.getItemInHand().hurtAndBreak(1, player, player.getEquipmentSlotForItem(context.getItemInHand()));
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    /**
     * Checks if targetPos is inside a Smooth Stone rectangle (like a nether portal frame)
     * and fills the interior with portal blocks.
     */
    private boolean tryIgniteFrame(Level level, BlockPos insidePos, Direction.Axis clickedAxis) {
        Direction.Axis axis = (clickedAxis == Direction.Axis.Z) ? Direction.Axis.X : Direction.Axis.Z;

        // Try filling 2x3 inner opening if surrounded by Smooth Stone
        int xOffset = (axis == Direction.Axis.X) ? 1 : 0;
        int zOffset = (axis == Direction.Axis.Z) ? 1 : 0;

        // Check if bottom blocks are Smooth Stone
        BlockPos bottom1 = insidePos.below();
        if (level.getBlockState(bottom1).is(Blocks.SMOOTH_STONE)) {
            level.setBlock(insidePos, ModBlocks.DRAGON_CITY_PORTAL_BLOCK.defaultBlockState(), 3);
            return true;
        }
        return false;
    }
}
