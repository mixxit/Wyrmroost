package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.RedDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RedDragonRenderer extends AbstractDragonRenderer<RedDragonEntity, RedDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/red_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/red_female.png");

    public RedDragonRenderer(EntityRendererManager manager) { super(manager, new RedDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(RedDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
