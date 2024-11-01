package app.tombplays.jaffactory.worldgen.feature.placement;

import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.util.worldgen.JaffaPlacementUtils;
import app.tombplays.jaffactory.worldgen.feature.JaffaTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class JaffaTreePlacements {

    public static final ResourceKey<PlacedFeature> JAFFA_TREE_CHECKED = JaffaPlacementUtils.createKey("jaffa_tree");
    public static final ResourceKey<PlacedFeature> JAFFA_TREE_BEES_CHECKED = JaffaPlacementUtils.createKey("jaffa_tree_bees");

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> JAFFA_TREE_BEES = configuredFeatureGetter.getOrThrow(JaffaTreeFeatures.JAFFA_TREE_BEES);
        final Holder<ConfiguredFeature<?, ?>> JAFFA_TREE = configuredFeatureGetter.getOrThrow(JaffaTreeFeatures.JAFFA_TREE);

        register(context, JaffaTreePlacements.JAFFA_TREE_BEES_CHECKED, JAFFA_TREE_BEES, List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.ORANGE_SAPLING.get())));
        register(context, JaffaTreePlacements.JAFFA_TREE_CHECKED, JAFFA_TREE, List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.ORANGE_SAPLING.get())));
    }


    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... modifiers)
    {
        register(context, placedFeatureKey, configuredFeature, List.of(modifiers));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers)
    {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeature, modifiers));
    }
}
