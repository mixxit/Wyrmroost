package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.YellowDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class YellowDragonRenderer extends AbstractDragonRenderer<YellowDragonEntity, YellowDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/yellow_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/yellow_female.png");

    public YellowDragonRenderer(EntityRendererManager manager) { super(manager, new YellowDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(YellowDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
