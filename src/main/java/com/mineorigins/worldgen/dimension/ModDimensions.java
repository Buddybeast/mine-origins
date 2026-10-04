package com.mineorigins.worldgen.dimension;

import com.mineorigins.MineOrigins;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<DimensionType> SKY_DIMENSION_TYPE = ResourceKey.create(
            Registries.DIMENSION_TYPE,
            MineOrigins.id("aetherial_aurora")
    );

    public static final ResourceKey<Level> SKY_DIMENSION_LEVEL = ResourceKey.create(
            Registries.DIMENSION,
            MineOrigins.id("aetherial_aurora")
    );

    // --- Dragon City Dimension & Biome Keys ---
    public static final ResourceKey<DimensionType> DRAGON_CITY_DIMENSION_TYPE = ResourceKey.create(
            Registries.DIMENSION_TYPE,
            MineOrigins.id("dragon_city")
    );

    public static final ResourceKey<Level> DRAGON_CITY_LEVEL = ResourceKey.create(
            Registries.DIMENSION,
            MineOrigins.id("dragon_city")
    );

    // Stratified Biomes
    public static final ResourceKey<net.minecraft.world.level.biome.Biome> SUN_CITY_BIOME = ResourceKey.create(
            Registries.BIOME,
            MineOrigins.id("sun_city")
    );

    public static final ResourceKey<net.minecraft.world.level.biome.Biome> MID_CITY_BIOME = ResourceKey.create(
            Registries.BIOME,
            MineOrigins.id("mid_city")
    );

    public static final ResourceKey<net.minecraft.world.level.biome.Biome> DOWN_CITY_BIOME = ResourceKey.create(
            Registries.BIOME,
            MineOrigins.id("down_city")
    );

    public static final ResourceKey<net.minecraft.world.level.biome.Biome> OLD_CITY_BIOME = ResourceKey.create(
            Registries.BIOME,
            MineOrigins.id("old_city")
    );

    public static void initialize() {
        MineOrigins.LOGGER.info("Registered Aetherial Aurora and Dragon City dimension keys");
    }
}
