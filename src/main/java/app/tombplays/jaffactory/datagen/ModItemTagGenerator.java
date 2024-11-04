package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.item.ModItems;
import app.tombplays.jaffactory.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, JaffactoryMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.JAFFACTORY_FRUIT)
                .add(ModItems.ORANGE.get()
                )
                .addTag(Tags.Items.CROPS);
        this.tag(ModTags.Items.ORANGE)
                .add(ModItems.ORANGE.get()
                )
                .addTag(Tags.Items.CROPS);

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ORANGE_PLANKS_BLOCK.get().asItem());
        this.tag(ItemTags.SLABS)
                .add(ModBlocks.ORANGE_PLANKS_SLAB.get().asItem());
        this.tag(ItemTags.LOGS)
                .add(ModBlocks.ORANGE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.get().asItem())
                .add(ModBlocks.ORANGE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.get().asItem());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORANGE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.get().asItem())
                .add(ModBlocks.ORANGE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.ORANGE_PLANKS_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.ORANGE_PLANKS_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.ORANGE_PLANKS_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.ORANGE_PLANKS_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.ORANGE_PLANKS_STAIRS.get().asItem());
        this.tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get().asItem());
    }
}
