package app.tombplays.jaffactory.block.trees;

import app.tombplays.jaffactory.worldgen.feature.JaffaTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class JaffaTreeGrowers {
    private static JaffaTreeGrowerImpl register(
            Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree,
            Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree) {
        return new JaffaTreeGrowerImpl(0.1F, tree, secondaryTree, Optional.empty(), Optional.empty());
    }

    public static final JaffaTreeGrowerImpl JAFFA_TREE_GROWER = register(0.1F, Optional.empty(), Optional.empty(), Optional.of(JaffaTreeFeatures.JAFFA_TREE), Optional.empty(), Optional.of(JaffaTreeFeatures.JAFFA_TREE_BEES), Optional.empty());
}
