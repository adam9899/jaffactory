package app.tombplays.jaffactory.item;

import app.tombplays.jaffactory.JaffactoryMod;
import app.tombplays.jaffactory.fluid.ModFluids;
import app.tombplays.jaffactory.util.ModTags.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JaffactoryMod.MOD_ID);

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food((ModFoods.ORANGE))));

    public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new Item(new Item.Properties().food((ModFoods.ORANGE_JUICE))));

    public static final RegistryObject<Item> ORANGE_JUICE_BUCKET = ITEMS.register("orange_juice_bucket",
        () -> new BucketItem(ModFluids.ORANGE_JUICE_SOURCE,
                new Item.Properties()
                .stacksTo(1)));

    public static final RegistryObject<Item> JAFFA_SLIME = ITEMS.register("jaffa_slime",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JAFFA_CHOCOLATE = ITEMS.register("jaffa_chocolate",
            () -> new Item(new Item.Properties().food((ModFoods.JAFFA_CHOCOLATE))));

    public static final RegistryObject<Item> JAFFA_BASE = ITEMS.register("jaffa_base",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JAFFA_SLIME_BASE = ITEMS.register("jaffa_slime_base",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JAFFA_CAKE = ITEMS.register("jaffa_cake",
            () -> new Item(new Item.Properties().food((ModFoods.JAFFA_CAKE))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
