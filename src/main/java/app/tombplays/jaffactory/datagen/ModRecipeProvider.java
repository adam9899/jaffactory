package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import app.tombplays.jaffactory.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ORANGE_JUICE.get(), 1)
                .requires(ModItems.ORANGE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.ORANGE.get()), has(ModItems.ORANGE.get()))
                .save(pRecipeOutput);

        /* Get Items from a Block - Category, Item, Block, Count, pRecipeOutput */
        ShapelessGetFromGiveRecipe(RecipeCategory.FOOD, ModItems.ORANGE.get(), ModBlocks.ORANGE_BLOCK.get(), 9, pRecipeOutput);
        ShapelessGetFromGiveRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_PLANKS_BLOCK.get(), ModBlocks.ORANGE_LOG.get(), 4, pRecipeOutput);

        /* Get Block from 9 Items in a square - Category, Block, Item, pRecipeOutput */
        ShapedBlockRecipe(RecipeCategory.DECORATIONS, ModBlocks.ORANGE_BLOCK.get(), ModItems.ORANGE.get(), pRecipeOutput);

        StairBuilder(ModBlocks.ORANGE_PLANKS_STAIRS.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);
        ButtonBuilder(ModBlocks.ORANGE_PLANKS_BUTTON.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);
        FenceBuilder(ModBlocks.ORANGE_PLANKS_FENCE.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);
        FenceGateBuilder(ModBlocks.ORANGE_PLANKS_FENCE_GATE.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);

        DoorBuilder(ModBlocks.ORANGE_PLANKS_DOOR.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);
        TrapDoorBuilder(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get(),"orange", pRecipeOutput);

        pressurePlate(pRecipeOutput, ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get());
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_PLANKS_SLAB.get(), ModBlocks.ORANGE_PLANKS_BLOCK.get());
    }

    private <P> void StairBuilder( Block stairs,P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        stairBuilder(stairs, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }
    private <P> void ButtonBuilder(ButtonBlock button, P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        buttonBuilder(button, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }
    private <P> void FenceBuilder(FenceBlock fence, P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        fenceBuilder(fence, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }
    private <P> void FenceGateBuilder(FenceGateBlock fence, P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        fenceBuilder(fence, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }
    private <P> void DoorBuilder(DoorBlock door, P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        doorBuilder(door, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }
    private <P> void TrapDoorBuilder(TrapDoorBlock door, P give, String group, Consumer<FinishedRecipe> recipeOutput) {
        trapdoorBuilder(door, Ingredient.of( (ItemLike) give)).group(group)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give)).save(recipeOutput);
    }


    private <P> void ShapelessGetFromGiveRecipe(RecipeCategory recipeCategory, P get, P give, int count, Consumer<FinishedRecipe> pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(recipeCategory, (ItemLike) get, count)
                .requires((ItemLike) give)
                .unlockedBy(getHasName((ItemLike) give), has((ItemLike) give))
                .save(pRecipeOutput);
    }

    private void ShapedBlockRecipe(RecipeCategory recipeCategory, Block recipeBlock, Item recipeItem, Consumer<FinishedRecipe> recipeOutput) {
        ShapedRecipeBuilder.shaped(recipeCategory, recipeBlock, 1)
                .pattern("ooo")
                .pattern("ooo")
                .pattern("ooo")
                .define('o', recipeItem)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(recipeOutput);
    }
}
