package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.worldgen.feature.configurations.JaffaTreeConfiguration;
import app.tombplays.jaffactory.worldgen.feature.tree.JAFTreeFeature;
import app.tombplays.jaffactory.worldgen.feature.tree.JaffaTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;

import java.util.function.BiConsumer;

public class JaffaTreeFeatures {

    public static JAFTreeFeature<JaffaTreeConfiguration> JAFFA_TREE;

    public static final ResourceKey<ConfiguredFeature<?, ?>> JAFFA_TREE_KEY = registerKey("jaffa_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, JAFFA_TREE_KEY, JAFFA_TREE, new JaffaTreeConfiguration.Builder()
                        .trunk(BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get()))
                .foliage(BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()))
                        .altFoliage(BlockStateProvider.simple(ModBlocks.ORANGE_FRUIT_LEAVES.get()))
                        .minHeight(2).maxHeight(3)
                        .decorator( new BeehiveDecorator(0.05f))
                        .leafLayers(3)
                        .leavesOffset(3)
                        .maxLeavesRadius(2)
                        .leavesLayerHeight(3).build());

    }

    public static void registerFeatures(BiConsumer<ResourceLocation, Feature<?>> func) {
        JAFFA_TREE = register(func, "basic_tree", new JaffaTreeFeature(JaffaTreeConfiguration.CODEC));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JaffactoryMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
