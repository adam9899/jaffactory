package app.tombplays.jaffactory.block.tree;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.worldgen.feature.JaffaTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class OrangeTreeGrower {

    public static final TreeGrower JAFFA = register("jaffa",  0.1F, Optional.empty(), Optional.empty(), Optional.of(JaffaTreeFeatures.JAFFA_TREE), Optional.empty(), Optional.of(JaffaTreeFeatures.JAFFA_TREE_BEES), Optional.empty());

    private static TreeGrower register(String name, float secondaryChance, Optional<ResourceKey<ConfiguredFeature<?, ?>>> megaTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryMegaTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryFlowers)
    {
        return new TreeGrower(String.format("%s:%s", JaffactoryMod.MODID, name), secondaryChance, megaTree, secondaryMegaTree, tree, secondaryTree, flowers, secondaryFlowers);
    }

    private static TreeGrower register(String name, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree)
    {
        return register(name, 0.1F, Optional.empty(), Optional.empty(), tree, secondaryTree, Optional.empty(), Optional.empty());
    }

    private static TreeGrower register(String name, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> megaTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryMegaTree)
    {
        return register(name, 0.1F, megaTree, secondaryMegaTree, tree, secondaryTree, Optional.empty(), Optional.empty());
    }
}