package app.tombplays.jaffactorymod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Objects;

public class OrangeFruitItem extends Item {

    public OrangeFruitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();

            Objects.requireNonNull(player).sendSystemMessage(Component.literal("Mmm, Zesty!"));
        }

        return super.useOn(pContext);
    }
}
