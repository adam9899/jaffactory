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

        withExistingParent(ModBlocks.ORANGE_PLANKS_DOOR.getId().getPath(), mcLoc("item/oak_door"));

        fenceItem(ModBlocks.ORANGE_PLANKS_FENCE, ModBlocks.ORANGE_PLANKS_BLOCK);
        buttonItem(ModBlocks.ORANGE_PLANKS_BUTTON, ModBlocks.ORANGE_PLANKS_BLOCK);

        // be warned we haven't added the other PLANKS BLOCKS
//        basicItem(ModBlocks.ORANGE_LOG_BLOCK.get().asItem());
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

}
