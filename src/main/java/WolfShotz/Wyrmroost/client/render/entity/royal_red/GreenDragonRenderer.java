package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.GreenDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class GreenDragonRenderer extends AbstractDragonRenderer<GreenDragonEntity, GreenDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/green_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/green_female.png");

    public GreenDragonRenderer(EntityRendererManager manager) { super(manager, new GreenDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(GreenDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
