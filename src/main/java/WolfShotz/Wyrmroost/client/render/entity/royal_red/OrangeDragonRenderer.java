package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.OrangeDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class OrangeDragonRenderer extends AbstractDragonRenderer<OrangeDragonEntity, OrangeDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/orange_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/orange_female.png");

    public OrangeDragonRenderer(EntityRendererManager manager) { super(manager, new OrangeDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(OrangeDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
