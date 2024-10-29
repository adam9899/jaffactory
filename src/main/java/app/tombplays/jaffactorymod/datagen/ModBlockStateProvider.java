package app.tombplays.jaffactorymod.datagen;

import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JaffactoryMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockBarrelWithItem(ModBlocks.ORANGE_BLOCK);
    }

    private void blockBarrelWithItem(RegistryObject<Block> blockRegistryObject) {
        ResourceLocation sideTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_side");
        ResourceLocation bottomTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_bottom");
        ResourceLocation topTexture = modLoc("block/" + blockRegistryObject.getId().getPath() + "_top");

        ModelFile barrelModel = modelBarrel(sideTexture, bottomTexture, topTexture);

        simpleBlockWithItem(blockRegistryObject.get(), barrelModel);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private ModelFile modelBarrel(ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        ModelFile barrelModel = models().cubeBottomTop("barrel", sideTexture, bottomTexture, topTexture);
        return barrelModel;
    }

}