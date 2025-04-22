package app.tombplays.jaffactory.fluid;

import app.tombplays.jaffactory.block.ModBlocks;
import app.tombplays.jaffactory.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import app.tombplays.jaffactory.JaffactoryMod;



public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, JaffactoryMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> ORANGE_JUICE_SOURCE = FLUIDS.register("orange_juice_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ORANGE_JUICE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> ORANGE_JUICE_FLOWING = FLUIDS.register("orange_juice_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ORANGE_JUICE_PROPERTIES));  
            
    public static final ForgeFlowingFluid.Properties ORANGE_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ORANGE_JUICE_TYPE, ORANGE_JUICE_SOURCE, ORANGE_JUICE_FLOWING)
            .slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(ModBlocks.ORANGE_JUICE_BLOCK)
            .bucket(ModItems.ORANGE_JUICE_BUCKET);

    public static final RegistryObject<FlowingFluid> CHOCOLATE_SOURCE = FLUIDS.register("chocolate_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CHOCOLATE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> CHOCOLATE_FLOWING = FLUIDS.register("chocolate_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CHOCOLATE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties CHOCOLATE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CHOCOLATE_TYPE, CHOCOLATE_SOURCE, CHOCOLATE_FLOWING)
            .slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(ModBlocks.CHOCOLATE_BLOCK)
            .bucket(ModItems.JAFFA_CHOCOLATE);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
