package WolfShotz.Wyrmroost.event;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.content.entities.dragon.owdrake.OWDrakeEntity;
import WolfShotz.Wyrmroost.content.io.container.OWDrakeInvContainer;
import WolfShotz.Wyrmroost.content.io.screen.OWDrakeInvScreen;
import WolfShotz.Wyrmroost.util.utils.ModUtils;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Wyrmroost.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupIO
{
    private static final String ID = Wyrmroost.MOD_ID + ":";
    
    @ObjectHolder(ID + "owdrake_inv")   public static ContainerType<OWDrakeInvContainer> owDrakeContainer;
    
    @SubscribeEvent
    public static void containerSetup(RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().registerAll(
                IForgeContainerType.create((windowId, inv, buf) -> {
                    Entity drake = ModUtils.getClientWorld().getEntityByID(buf.readInt());
                    return new OWDrakeInvContainer(windowId, inv, (OWDrakeEntity) drake);
                }).setRegistryName("owdrake_inv")
        );
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void screenSetup() {
        ScreenManager.registerFactory(owDrakeContainer, OWDrakeInvScreen::new);
    }
}
