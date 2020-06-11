package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.RoyalRedEntity;
import WolfShotz.Wyrmroost.entities.dragon.SilverDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SilverDragonRenderer extends AbstractDragonRenderer<SilverDragonEntity, SilverDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/silver_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/silver_female.png");

    public SilverDragonRenderer(EntityRendererManager manager) { super(manager, new SilverDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(SilverDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
