package app.tombplays.jaffactory.datagen;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.util.worldgen.JaffaFeatureUtils;
import app.tombplays.jaffactory.util.worldgen.JaffaPlacementUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, JaffaFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, JaffaPlacementUtils::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(JaffactoryMod.MODID));
    }
}
