package app.tombplays.jaffactory.worldgen.feature.biome;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.worldgen.feature.JaffaPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class JaffaBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_JAFFA = registerKey("add_tree_jaffa");
    public static final ResourceKey<BiomeModifier> ADD_TREE_JAFFA_SAVANNA = registerKey("add_tree_jaffa_savanna");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

//        context.register(ADD_TREE_JAFFA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_DRY),
//                HolderSet.direct(placedFeatures.getOrThrow(JaffaPlacedFeatures.JAFFA_TREE_PLACED_KEY)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_JAFFA_SAVANNA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(JaffaPlacedFeatures.JAFFA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(JaffactoryMod.MOD_ID, name));
    }
}
