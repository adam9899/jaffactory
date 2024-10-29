package app.tombplays.jaffactorymod.datagen;

import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class ModBlockStateProvider extends BlockStateProvider {
    private final PackOutput packOutput;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JaffactoryMod.MODID, exFileHelper);
        this.packOutput = output;
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ORANGE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        String texturePath = "block/" + blockRegistryObject.getId().getPath();
        ResourceLocation textureLocation = modLoc(texturePath);

        // Log the texture path
        System.out.println("Using texture path: " + texturePath);
    }

}