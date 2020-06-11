package WolfShotz.Wyrmroost.client.render.entity.royal_red;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.client.render.entity.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.entities.dragon.PurpleDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PurpleDragonRenderer extends AbstractDragonRenderer<PurpleDragonEntity, PurpleDragonModel>
{
    public static final ResourceLocation MALE = Wyrmroost.rl(BASE_PATH + "royal_red/purple_male.png");
    public static final ResourceLocation FEMALE = Wyrmroost.rl(BASE_PATH + "royal_red/purple_female.png");

    public PurpleDragonRenderer(EntityRendererManager manager) { super(manager, new PurpleDragonModel(), 2.5f); }

    @Override
    public ResourceLocation getEntityTexture(PurpleDragonEntity entity) { return entity.isMale()? MALE : FEMALE; }
}
