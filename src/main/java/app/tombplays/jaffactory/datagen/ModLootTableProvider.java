package app.tombplays.jaffactory.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import app.tombplays.jaffactory.datagen.loot.ModBlockLootTables;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(
                output,
                Collections.emptySet(),
                List.of( new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)),
                lookupProvider
                );
    }


}
