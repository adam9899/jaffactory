package app.tombplays.jaffactorymod.item;

import app.tombplays.jaffactorymod.JaffactoryMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JaffactoryMod.MODID);

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food((ModFoods.ORANGE))));

    public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new Item(new Item.Properties().food((ModFoods.ORANGE_JUICE))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
