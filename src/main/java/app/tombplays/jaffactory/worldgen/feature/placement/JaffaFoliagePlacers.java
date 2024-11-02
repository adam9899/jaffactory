package app.tombplays.jaffactory.worldgen.feature.placement;

import app.tombplays.jaffactory.JaffactoryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JaffaFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, JaffactoryMod.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<JaffaFoliagePlacer>> JAFFA_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("jaffa_foliage_placer", () -> new FoliagePlacerType<>(JaffaFoliagePlacer.CODEC));


    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
