package app.tombplays.jaffactory.block.tree;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class SaplingBlockFactory {
    public static Supplier<SaplingBlock> createSaplingBlock(TreeGrower treeGrower) {
        OrangeTreeGrower orangeTreeGrower = new OrangeTreeGrower(treeGrower);
        return () -> new SaplingBlock(orangeTreeGrower.getTreeGrower(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    }
}
