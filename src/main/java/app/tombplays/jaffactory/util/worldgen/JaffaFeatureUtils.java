package app.tombplays.jaffactory.util.worldgen;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.worldgen.feature.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class JaffaFeatureUtils {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        JaffaTreeFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JaffactoryMod.MODID, name));
    }
}
