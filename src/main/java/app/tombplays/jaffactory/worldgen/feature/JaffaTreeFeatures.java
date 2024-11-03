package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.worldgen.feature.configurations.JaffaTreeConfiguration;
import app.tombplays.jaffactory.worldgen.feature.placement.JaffaFoliagePlacer;
import app.tombplays.jaffactory.worldgen.feature.tree.JAFTreeFeature;
import app.tombplays.jaffactory.worldgen.feature.tree.JaffaTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.function.BiConsumer;

public class JaffaTreeFeatures {

    public static JAFTreeFeature<JaffaTreeConfiguration> JAFFA_TREE;

    public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE_KEY = registerKey("jaffa_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, JAFFA_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get()),
                new StraightTrunkPlacer(2 , 1 ,1),


                BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
                new JaffaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3, BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get())),


                new TwoLayersFeatureSize(1, 0 ,2)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JaffactoryMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
