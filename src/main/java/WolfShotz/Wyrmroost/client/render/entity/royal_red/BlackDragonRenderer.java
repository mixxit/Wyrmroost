package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.BlackDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BlackDragonRenderer extends AbstractDragonRenderer<BlackDragonEntity, BlackDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/black_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/black_female.png");

    public BlackDragonRenderer(EntityRendererManager manager) { super(manager, new BlackDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(BlackDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
