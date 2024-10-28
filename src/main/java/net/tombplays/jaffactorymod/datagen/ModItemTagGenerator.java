package net.tombplays.jaffactorymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tombplays.jaffactorymod.JaffactoryMod;
import net.tombplays.jaffactorymod.item.ModItems;
import net.tombplays.jaffactorymod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, JaffactoryMod.MODID, existingFileHelper);
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
    }
}
