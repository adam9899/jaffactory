package net.tombplays.jaffactorymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tombplays.jaffactorymod.JaffactoryMod;
import net.tombplays.jaffactorymod.block.ModBlocks;
import net.tombplays.jaffactorymod.item.ModItems;
import net.tombplays.jaffactorymod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JaffactoryMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.JAFFACTORY_FRUIT)
                .add(ModBlocks.ORANGE_BLOCK.get()
                )
                .addTag(Tags.Blocks.STORAGE_BLOCKS);

    }
}
