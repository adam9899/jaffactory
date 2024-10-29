package app.tombplays.jaffactorymod.datagen;

import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import app.tombplays.jaffactorymod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ORANGE_JUICE.get(), 1)
                .requires(ModItems.ORANGE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.ORANGE.get()), has(ModItems.ORANGE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ORANGE.get(), 9)
                .requires(ModBlocks.ORANGE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_BLOCK.get()), has(ModBlocks.ORANGE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORANGE_BLOCK.get(), 1)
                .pattern("ooo")
                .pattern("ooo")
                .pattern("ooo")
                .define('o', ModItems.ORANGE.get())
                .unlockedBy(getHasName(ModItems.ORANGE.get()), has(ModItems.ORANGE.get()))
                .save(pRecipeOutput);
    }
}
