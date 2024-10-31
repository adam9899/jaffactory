package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JaffactoryMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ORANGE.get());
        basicItem(ModItems.ORANGE_JUICE.get());

        doorItem(ModBlocks.ORANGE_PLANKS_DOOR);
        trapDoorItem(ModBlocks.ORANGE_PLANKS_TRAPDOOR);
        fenceItem(ModBlocks.ORANGE_PLANKS_FENCE, ModBlocks.ORANGE_PLANKS_BLOCK);
        buttonItem(ModBlocks.ORANGE_PLANKS_BUTTON, ModBlocks.ORANGE_PLANKS_BLOCK);
        saplingItem(ModBlocks.ORANGE_SAPLING);

        // be warned we haven't added the other ORANGE BLOCKS
        tubeItem(ModBlocks.ORANGE_LOG);
//        tubeItem(ModBlocks.ORANGE_WOOD);
//        tubeItem(ModBlocks.STRIPPED_ORANGE_LOG);
//        tubeItem(ModBlocks.STRIPPED_ORANGE_WOOD);
        simpleItemFromBlock(ModBlocks.ORANGE_PLANKS_STAIRS, ModBlocks.ORANGE_PLANKS_BLOCK);
        simpleItemFromBlock(ModBlocks.ORANGE_PLANKS_PRESSURE_PLATE, ModBlocks.ORANGE_PLANKS_BLOCK);
        simpleItemFromBlock(ModBlocks.ORANGE_PLANKS_FENCE_GATE, ModBlocks.ORANGE_PLANKS_BLOCK);
        simpleItemFromBlock(ModBlocks.ORANGE_PLANKS_SLAB, ModBlocks.ORANGE_PLANKS_BLOCK);
    }

    public <T> void simpleItemFromBlock(RegistryObject<T> block, RegistryObject<Block> textBlock) {
        String modelPath = prepareModelPath("block/" + block.getId().getPath());
        String texturePath = prepareTexturePath("block/" + textBlock.getId().getPath());
        this.withExistingParent(block.getId().getPath(), modLoc(modelPath))
                .texture("texture", texturePath);
    }
    public <T> void simpleItem(RegistryObject<T> block) {
        String modelPath = prepareModelPath("block/" + block.getId().getPath());
        String texturePath = prepareTexturePath("block/" + block.getId().getPath());
        this.withExistingParent(block.getId().getPath(), modLoc(modelPath))
                .texture("texture", texturePath);
    }
    public <T> void tubeItem(RegistryObject<T> block) {
        String modelPath = prepareModelPath("block/" + block.getId().getPath());
        String texturePath = prepareTexturePath("block/" + block.getId().getPath());
        this.withExistingParent(block.getId().getPath(), modLoc(modelPath))
                .texture("end", texturePath + "_top")
                .texture("side", texturePath + "_side");
    }

    public <T> void saplingItem(RegistryObject<T> block) {
        String modelPath = prepareModelPath("item/generated");
        String texturePath = prepareTexturePath("block/" + block.getId().getPath());
        this.withExistingParent(block.getId().getPath(), mcLoc(modelPath))
                .texture("layer0", texturePath);
    }

    public void fenceItem(RegistryObject<FenceBlock> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", "block/" + baseBlock.getId().getPath());
    }
    public void buttonItem(RegistryObject<ButtonBlock> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", "block/" + baseBlock.getId().getPath());
    }
    public void wallItem(RegistryObject<WallBlock> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", "block/" + baseBlock.getId().getPath());
    }
    public void doorItem(RegistryObject<DoorBlock> block) {
        String modelPath = prepareModelPath("block/" + block.getId().getPath());
        this.withExistingParent(block.getId().getPath(), mcLoc("item/oak_door"))
                .texture( "bottom", "block/" + block.getId().getPath() + "_bottom")
                .texture( "top", "block/" + block.getId().getPath() + "_top");
    }
    public void trapDoorItem(RegistryObject<TrapDoorBlock> block) {
        String modelPath = prepareModelPath("block/" + block.getId().getPath());
        this.withExistingParent(block.getId().getPath(), mcLoc("item/oak_trapdoor"))
                .texture( "texture", "block/" + block.getId().getPath());
    }

    private static String prepareModelPath(String path) {
        // Log the Model path
        System.out.println("Using model path: " + path);
        return path;
    }
    private static String prepareTexturePath(String path) {
        // Log the Texture path
        System.out.println("Using texture path: " + path);
        return path;
    }

}
