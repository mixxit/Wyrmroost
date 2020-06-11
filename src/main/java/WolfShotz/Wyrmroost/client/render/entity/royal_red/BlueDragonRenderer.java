package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.BlueDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BlueDragonRenderer extends AbstractDragonRenderer<BlueDragonEntity, BlueDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/blue_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/blue_female.png");

    public BlueDragonRenderer(EntityRendererManager manager) { super(manager, new BlueDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(BlueDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
