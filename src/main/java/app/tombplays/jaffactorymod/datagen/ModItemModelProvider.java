package app.tombplays.jaffactorymod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import app.tombplays.jaffactorymod.JaffactoryMod;
import app.tombplays.jaffactorymod.item.ModItems;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JaffactoryMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ORANGE);
        simpleItem(ModItems.ORANGE_JUICE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        String texturePath = "item/" + item.getId().getPath();

        // Log the texture path
        System.out.println("Using texture path: " + texturePath);

        // Items generally use a simple parent and one texture. The most common parents are item/generated and item/handheld.
        // In this example, the item texture would be located at assets/jaffactory/textures/item/example_item.png.
        // If you want a more complex model, you can use getBuilder() and then work from that, like you would with block models.
        return withExistingParent(item.get().toString(), mcLoc("item/generated")).texture("layer0", texturePath);
    }
}
