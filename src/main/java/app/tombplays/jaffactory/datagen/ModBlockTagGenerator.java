package app.tombplays.jaffactory.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JaffactoryMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ORANGE_PLANKS_BLOCK.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.ORANGE_LOG.get())
                .add(ModBlocks.ORANGE_WOOD.get())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.get())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.get());


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORANGE_LOG.get())
                .add(ModBlocks.ORANGE_WOOD.get())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.get())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.ORANGE_LEAVES.get())
                .add(ModBlocks.ORANGE_FRUIT_LEAVES.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.ORANGE_PLANKS_DOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.ORANGE_PLANKS_BUTTON.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.ORANGE_PLANKS_SLAB.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.ORANGE_PLANKS_STAIRS.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get());

        this.tag(ModTags.Blocks.JAFFACTORY_FRUIT)
                .add(ModBlocks.ORANGE_BLOCK.get()
                )
                .addTag(Tags.Blocks.STORAGE_BLOCKS);
        this.tag(ModTags.Blocks.ORANGE_PLANKS_BLOCK)
                .add(ModBlocks.ORANGE_PLANKS_BLOCK.get()
                )
                .addTag(BlockTags.PLANKS);

    }
}
