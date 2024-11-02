package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.worldgen.feature.placement.JaffaTreePlacements;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class JaffaVegetationFeatures {

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        final Holder<PlacedFeature> JAFFA_TREE_BEES_CHECKED = placedFeatureGetter.getOrThrow(JaffaTreePlacements.JAFFA_TREE_BEES_CHECKED);
        final Holder<PlacedFeature> JAFFA_TREE_CHECKED = placedFeatureGetter.getOrThrow(JaffaTreePlacements.JAFFA_TREE_CHECKED);
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
