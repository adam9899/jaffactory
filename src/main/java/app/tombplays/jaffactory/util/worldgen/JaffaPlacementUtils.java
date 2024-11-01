package app.tombplays.jaffactory.util.worldgen;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.worldgen.feature.placement.JaffaTreePlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class JaffaPlacementUtils {
    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        JaffaTreePlacements.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(JaffactoryMod.MODID, name));
    }
}
