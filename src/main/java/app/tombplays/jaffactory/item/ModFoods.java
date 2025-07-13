package app.tombplays.jaffactory.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ORANGE = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.3f).alwaysEat().effect(
                    () -> new MobEffectInstance(MobEffects.GLOWING, 10), 0.1f).build();

    public static final FoodProperties ORANGE_JUICE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.3f).alwaysEat().effect(
                    () -> new MobEffectInstance(MobEffects.GLOWING, 30), 0.3f).build();

    public static final FoodProperties JAFFA_CAKE = new FoodProperties.Builder().nutrition(7).fast()
            .saturationMod(0.8f).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 2), 1f)
                .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2), 1f)
            .build();

    public static final FoodProperties JAFFA_CHOCOLATE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.5f).alwaysEat().effect(
                    () -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30), 0.3f).build();
}
