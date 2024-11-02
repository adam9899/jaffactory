package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.util.worldgen.JaffaFeatureUtils;
import app.tombplays.jaffactory.worldgen.feature.configurations.*;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;

public class JaffaTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE = JaffaFeatureUtils.createKey("jaffa_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE_BEES = JaffaFeatureUtils.createKey("jaffa_tree_bees");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, JaffaTreeFeatures.JAFFA_TREE, JaffaBaseFeatures.BASIC_TREE, new BasicTreeConfiguration.Builder().trunk(BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get())).foliage(BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get())).altFoliage(BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get())).build());
        register(context, JaffaTreeFeatures.JAFFA_TREE_BEES, JaffaBaseFeatures.BASIC_TREE, new BasicTreeConfiguration.Builder().trunk(BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get())).foliage(BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get())).altFoliage(BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get())).decorator(new BeehiveDecorator(0.05f)).build());

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
