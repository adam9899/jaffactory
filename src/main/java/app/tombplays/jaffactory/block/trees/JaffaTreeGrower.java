package app.tombplays.jaffactory.block.trees;

import app.tombplays.jaffactory.worldgen.feature.JaffaTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class JaffaTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> m_213888_(RandomSource pRandom, boolean pHasFlowers) {
        return JaffaTreeFeatures.JAFFA_TREE_KEY;
    }
}