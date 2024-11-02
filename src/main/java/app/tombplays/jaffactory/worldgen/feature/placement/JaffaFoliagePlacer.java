package app.tombplays.jaffactory.worldgen.feature.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class JaffaFoliagePlacer extends FoliagePlacer {
    public static final Codec<JaffaFoliagePlacer> CODEC = RecordCodecBuilder.create(jaffaFoliagePlacerInstance
            -> foliagePlacerParts(jaffaFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height)).apply(jaffaFoliagePlacerInstance, JaffaFoliagePlacer::new));
    private final int height;

    public JaffaFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return JaffaFoliagePlacers.JAFFA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int pMaxFreeTreeHeight, JaffaFoliagePlacer.FoliageAttachment foliageAttachment, int height, int pRadius, int pOffset) {
        for(int $$9 = pOffset; $$9 >= pOffset - height; --$$9) {
            int $$10 = Math.max(pRadius + foliageAttachment.radiusOffset() - 1 - $$9 / 2, 0);
            this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), $$10, $$9, foliageAttachment.doubleTrunk());
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
