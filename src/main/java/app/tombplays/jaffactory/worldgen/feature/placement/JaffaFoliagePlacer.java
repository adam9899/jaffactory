package app.tombplays.jaffactory.worldgen.feature.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class JaffaFoliagePlacer extends FoliagePlacer {
    public static final Codec<JaffaFoliagePlacer> CODEC = RecordCodecBuilder.create(jaffaFoliagePlacerInstance
            -> foliagePlacerParts(jaffaFoliagePlacerInstance)
            .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
            .and(BlockStateProvider.CODEC.fieldOf("altFoliage").forGetter(fp -> fp.altFoliage))
            .apply(jaffaFoliagePlacerInstance, JaffaFoliagePlacer::new));
    private final int height;
    private final BlockStateProvider altFoliage;

    public JaffaFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height, BlockStateProvider altFoliage) {
        super(pRadius, pOffset);
        this.height = height;
        this.altFoliage = altFoliage;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return JaffaFoliagePlacers.JAFFA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int pMaxFreeTreeHeight, JaffaFoliagePlacer.FoliageAttachment foliageAttachment, int height, int pRadius, int pOffset) {
        for(int $$9 = pOffset; $$9 >= pOffset - height; --$$9) {
            int $$10 = Math.max(pRadius + foliageAttachment.radiusOffset() - 1 - $$9 / 2, 0);
            this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, altFoliage, foliageAttachment.pos(), $$10, $$9, foliageAttachment.doubleTrunk());
        }
    }

    protected void placeLeavesRow(LevelSimulatedReader pLevel, FoliageSetter pFoliageSetter, RandomSource pRandom, TreeConfiguration pTreeConfiguration, BlockStateProvider pAltFoliage, BlockPos pPos, int pRange, int pLocalY, boolean pLarge) {
        int $$8 = pLarge ? 1 : 0;
        BlockPos.MutableBlockPos $$9 = new BlockPos.MutableBlockPos();

        for(int $$10 = -pRange; $$10 <= pRange + $$8; ++$$10) {
            for(int $$11 = -pRange; $$11 <= pRange + $$8; ++$$11) {
                if (!this.shouldSkipLocationSigned(pRandom, $$10, pLocalY, $$11, pRange, pLarge)) {
                    $$9.setWithOffset(pPos, $$10, pLocalY, $$11);
                    tryPlaceLeaf(pLevel, pFoliageSetter, pRandom, pTreeConfiguration, pAltFoliage, $$9);
                }
            }
        }

    }

    protected static boolean tryPlaceLeaf(LevelSimulatedReader pLevel, FoliageSetter pFoliageSetter, RandomSource pRandom, TreeConfiguration pTreeConfiguration, BlockStateProvider pAltFoliage, BlockPos pPos) {
        if (!TreeFeature.validTreePos(pLevel, pPos)) {
            return false;
        } else {
            Random random = new Random();
            BlockState $$1 = pTreeConfiguration.foliageProvider.getState(pRandom, pPos);
            BlockState $$2 = pAltFoliage.getState(pRandom, pPos);

            BlockState $$5 = random.nextBoolean() ? $$1 : $$2;
            if ($$5.hasProperty(BlockStateProperties.WATERLOGGED)) {
                $$5 = (BlockState)$$5.setValue(BlockStateProperties.WATERLOGGED, pLevel.isFluidAtPosition(pPos, (p_225638_) -> {
                    return p_225638_.isSourceOfType(Fluids.WATER);
                }));
            }

            pFoliageSetter.set(pPos, $$5);
            return true;
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
