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
}
