package app.tombplays.jaffactory.worldgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

import java.util.List;

public class JaffaTreeConfiguration extends JAFTreeConfiguration {
    public static final Codec<JaffaTreeConfiguration> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(
                BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter((instance) -> instance.trunkProvider),
                BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter((instance) -> instance.foliageProvider),
                BlockStateProvider.CODEC.fieldOf("alt_foliage_provider").forGetter((instance) -> instance.altFoliageProvider),
                Codec.INT.fieldOf("min_height").forGetter((instance) -> instance.minHeight),
                Codec.INT.fieldOf("max_height").forGetter((instance) -> instance.maxHeight),
                TreeDecorator.CODEC.listOf().fieldOf("decorators").forGetter(instance -> instance.decorators),
                Codec.INT.fieldOf("leaf_layers").forGetter((instance) -> instance.leafLayers),
                Codec.INT.fieldOf("leaves_offset").forGetter((instance) -> instance.leavesOffset),
                Codec.INT.fieldOf("max_leaves_radius").forGetter((instance) -> instance.maxLeavesRadius),
                Codec.INT.fieldOf("leaves_layer_height").forGetter((instance) -> instance.leavesLayerHeight)
        ).apply(builder, JaffaTreeConfiguration::new);
    });
    public final int leafLayers;
    public final int leavesOffset;
    public final int maxLeavesRadius;
    public final int leavesLayerHeight;

    protected JaffaTreeConfiguration(BlockStateProvider trunkProvider, BlockStateProvider foliageProvider, BlockStateProvider altFoliageProvider, int minHeight, int maxHeight, List<TreeDecorator> decorators, int leafLayers, int leavesOffset, int maxLeavesRadius, int leavesLayerHeight)
    {
        super(trunkProvider, foliageProvider, altFoliageProvider, minHeight, maxHeight, decorators);
        this.leafLayers = leafLayers;
        this.leavesOffset = leavesOffset;
        this.maxLeavesRadius = maxLeavesRadius;
        this.leavesLayerHeight = leavesLayerHeight;
    }

    public static class Builder extends JAFTreeConfiguration.Builder<Builder>
    {
        protected int leafLayers;
        protected int leavesOffset;
        protected int maxLeavesRadius;
        protected int leavesLayerHeight;

        public Builder leafLayers(int a) {this.leafLayers = a; return this;}
        public Builder leavesOffset(int a) {this.leavesOffset = a; return this;}
        public Builder leavesLayerHeight(int a) {this.leavesLayerHeight = a; return this;}
        public Builder maxLeavesRadius(int a) {this.maxLeavesRadius = a; return this;}

        public Builder()
        {
            this.minHeight = 4;
            this.maxHeight = 7;
            this.leafLayers = 4;
            this.leavesOffset = 1;
            this.maxLeavesRadius = 1;
            this.leavesLayerHeight = 2;
        }

        public JaffaTreeConfiguration build()
        {
            return new JaffaTreeConfiguration(this.trunkProvider, this.foliageProvider, this.altFoliageProvider, this.minHeight, this.maxHeight, this.decorators, this.leafLayers, this.leavesOffset, this.maxLeavesRadius, this.leavesLayerHeight);
        }
    }
}
