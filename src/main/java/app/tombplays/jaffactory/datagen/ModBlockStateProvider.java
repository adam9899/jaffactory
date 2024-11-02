package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JaffactoryMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockBarrelWithItem(ModBlocks.ORANGE_BLOCK);

        blockTubeWithItem(ModBlocks.ORANGE_LOG);
        blockTubeWithItem(ModBlocks.STRIPPED_ORANGE_LOG);

        blockTubeWithItemFromParent(ModBlocks.ORANGE_WOOD, ModBlocks.ORANGE_LOG);
        blockTubeWithItemFromParent(ModBlocks.STRIPPED_ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_LOG);


//        simpleBlockItem(ModBlocks.STRIPPED_ORANGE_LOG);
//        simpleBlockItem(ModBlocks.ORANGE_WOOD);
//        simpleBlockItem(ModBlocks.STRIPPED_ORANGE_WOOD);

        blockWithItem(ModBlocks.ORANGE_PLANKS_BLOCK);

        stairsBlock(        ModBlocks.ORANGE_PLANKS_STAIRS.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        slabBlock(          ModBlocks.ORANGE_PLANKS_SLAB.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        buttonBlock(        ModBlocks.ORANGE_PLANKS_BUTTON.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        pressurePlateBlock( ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        fenceBlock(         ModBlocks.ORANGE_PLANKS_FENCE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));
        fenceGateBlock(     ModBlocks.ORANGE_PLANKS_FENCE_GATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ORANGE_PLANKS_DOOR.get(), modLoc("block/orange_planks_door_bottom"), modLoc("block/orange_planks_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ORANGE_PLANKS_TRAPDOOR.get(), modLoc("block/orange_planks_trapdoor"), true, "cutout");

        blockItem(ModBlocks.ORANGE_PLANKS_STAIRS);
        blockItem(ModBlocks.ORANGE_PLANKS_SLAB);
        blockItem(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE);
        blockItem(ModBlocks.ORANGE_PLANKS_FENCE_GATE);
        blockItem(ModBlocks.ORANGE_PLANKS_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.ORANGE_PLANKS_DOOR, "_bottom");

        saplingBlock(ModBlocks.ORANGE_SAPLING);
        leavesBlock(ModBlocks.ORANGE_LEAVES);
        leavesBlock(ModBlocks.ORANGE_FRUIT_LEAVES);
    }

    private <T> void saplingBlock(RegistryObject<T> blockRegistryObject) {
        simpleBlock( (Block) blockRegistryObject.get(),
                models().cross( "orange_sapling", blockTexture( (Block) blockRegistryObject.get() )).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockBarrelWithItem(RegistryObject<Block> blockRegistryObject) {
        String blockName = blockRegistryObject.getId().getPath();
        ResourceLocation sideTexture = modLoc("block/" + blockName + "_side");
        ResourceLocation bottomTexture = modLoc("block/" + blockName + "_bottom");
        ResourceLocation topTexture = modLoc("block/" + blockName + "_top");

        ModelFile barrelModel = modelBarrel(blockName, sideTexture, bottomTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), barrelModel);
    }

    private void blockTubeWithItem(RegistryObject<Block> blockRegistryObject) {
        String blockName = blockRegistryObject.getId().getPath();
        ResourceLocation sideTexture = modLoc("block/" + blockName + "_side");
        ResourceLocation topTexture = modLoc("block/" + blockName + "_top");

        ModelFile tubeModel = modelTube(blockName, sideTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), tubeModel);
    }

    private void blockTubeWithItemFromParent(RegistryObject<Block> blockRegistryObject, RegistryObject<Block> blockParent) {
        String blockName = blockRegistryObject.getId().getPath();
        String parentName = blockParent.getId().getPath();
        ResourceLocation sideTexture = modLoc("block/" + parentName + "_side");
        ResourceLocation topTexture = modLoc("block/" + parentName + "_top");

        ModelFile tubeModel = modelTube(blockName, sideTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), tubeModel);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void simpleBlockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(JaffactoryMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private <T> void blockItem(RegistryObject<T> blockRegistryObject) {
        simpleBlockItem( (Block) blockRegistryObject.get(), new ModelFile.UncheckedModelFile( modLoc("block/" + blockRegistryObject.getId().getPath()) ));
    }
    private <T> void blockItem(RegistryObject<T> blockRegistryObject, String appendix) {
        simpleBlockItem( (Block) blockRegistryObject.get(), new ModelFile.UncheckedModelFile( modLoc("block/" + blockRegistryObject.getId().getPath() + appendix) ));
    }

    private ModelFile modelBarrel(String name, ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        return models().cubeBottomTop(name, sideTexture, bottomTexture, topTexture);
    }

    private ModelFile modelTube(String name, ResourceLocation sideTexture, ResourceLocation topTexture) {
        return models().cubeColumn(name, sideTexture, topTexture);
    }

}