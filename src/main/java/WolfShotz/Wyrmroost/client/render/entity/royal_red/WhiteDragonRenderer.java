package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.WhiteDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class WhiteDragonRenderer extends AbstractDragonRenderer<WhiteDragonEntity, WhiteDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/white_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/white_female.png");

    public WhiteDragonRenderer(EntityRendererManager manager) { super(manager, new WhiteDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(WhiteDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
