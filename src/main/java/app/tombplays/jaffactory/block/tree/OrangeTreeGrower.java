package app.tombplays.jaffactory.block.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.TreeGrower;
import app.tombplays.jaffactory.worldgen.ModConfiguredFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class OrangeTreeGrower {
    private final TreeGrower treeGrower;

    public OrangeTreeGrower(TreeGrower treeGrower) {
        this.treeGrower = treeGrower;
    }

    private ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pFlowers) {
        return ModConfiguredFeatures.ORANGE_TREE_KEY;
    }

    public boolean growTree(ServerLevel pLevel, ChunkGenerator pChunkGenerator, BlockPos pPos, BlockState pState, RandomSource pRandom) {



        // Delegate to the original TreeGrower
        boolean result = treeGrower.growTree(pLevel, pChunkGenerator, pPos, pState, pRandom);

        return result;
    }

    // Method to get the wrapped TreeGrower
    public TreeGrower getTreeGrower() {
        return this.treeGrower;
    }
}