package app.tombplays.jaffactory.worldgen.feature;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.worldgen.feature.configurations.*;
import app.tombplays.jaffactory.worldgen.feature.tree.BasicTreeFeature;
import app.tombplays.jaffactory.worldgen.feature.tree.JaffaTreeFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.function.BiConsumer;

public class JaffaBaseFeatures {
    public static JaffaTreeFeature<BasicTreeConfiguration> BASIC_TREE;

    public static void registerFeatures(BiConsumer<ResourceLocation, Feature<?>> func) {
        BASIC_TREE = register(func, "basic_tree", new BasicTreeFeature(BasicTreeConfiguration.CODEC));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(BiConsumer<ResourceLocation, Feature<?>> func, String name, F feature)
    {
        func.accept(new ResourceLocation(JaffactoryMod.MODID, name), feature);
        return feature;
    }
}
