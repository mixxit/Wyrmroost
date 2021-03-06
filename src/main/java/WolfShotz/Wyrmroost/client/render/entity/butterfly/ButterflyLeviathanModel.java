package WolfShotz.Wyrmroost.client.render.entity.butterfly;

import WolfShotz.Wyrmroost.client.model.ModelAnimator;
import WolfShotz.Wyrmroost.client.model.WREntityModel;
import WolfShotz.Wyrmroost.client.model.WRModelRenderer;
import WolfShotz.Wyrmroost.entities.dragon.ButterflyLeviathanEntity;
import WolfShotz.Wyrmroost.util.QuikMaths;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.tags.FluidTags;

/**
 * butterfly leviathan - Kingdomall
 * Created using Tabula 7.1.0
 */
public class ButterflyLeviathanModel extends WREntityModel<ButterflyLeviathanEntity>
{
    private final WRModelRenderer[] headArray;
    public WRModelRenderer body1;
    public WRModelRenderer body2;
    public WRModelRenderer neck1;
    public WRModelRenderer topWingFinPhalangeR1;
    public WRModelRenderer bottomWingFinPhalangeR1;
    public WRModelRenderer topWingFinPhalangeL1;
    public WRModelRenderer bottomWingFinPhalangeL1;
    public WRModelRenderer tail1;
    public WRModelRenderer legThighR1;
    public WRModelRenderer legThighL1;
    public WRModelRenderer tail2;
    public WRModelRenderer tail3;
    public WRModelRenderer tail4;
    public WRModelRenderer tail5;
    public WRModelRenderer tail6;
    public WRModelRenderer tailFinTop;
    public WRModelRenderer tailFinBottom;
    public WRModelRenderer legSegmentR1;
    public WRModelRenderer legSegmentR2;
    public WRModelRenderer footR;
    public WRModelRenderer legSegmentL1;
    public WRModelRenderer legSegmentL2;
    public WRModelRenderer footL;
    public WRModelRenderer neck2;
    public WRModelRenderer neck3;
    public WRModelRenderer head;
    public WRModelRenderer mouthTop;
    public WRModelRenderer mouthBottom;
    public WRModelRenderer headFrillR;
    public WRModelRenderer headFrillL;
    public WRModelRenderer eyeR;
    public WRModelRenderer eyeL;
    public WRModelRenderer teethTop;
    public WRModelRenderer teethBottom;
    public WRModelRenderer topWingFinPhalangeR2;
    public WRModelRenderer topWingFinMembraneR1;
    public WRModelRenderer topWingFinMembraneR2;
    public WRModelRenderer topWingFinMembraneR3;
    public WRModelRenderer bottomWingFinPhalangeR2;
    public WRModelRenderer bottomWingFinMembraneR1;
    public WRModelRenderer bottomWingFinMembraneR2;
    public WRModelRenderer bottomWingFinMembraneR3;
    public WRModelRenderer topWingFinPhalangeL2;
    public WRModelRenderer topWingFinMembraneL1;
    public WRModelRenderer topWingFinPhalangeL2_1;
    public WRModelRenderer topWingFinMembrane3L;
    public WRModelRenderer bottomWingFinPhalangeL2;
    public WRModelRenderer bottomWingFinMembraneL1;
    public WRModelRenderer bottomWingFinMembraneL2;
    public WRModelRenderer bottomWingFinMembraneL3;
    public WRModelRenderer[] tailArray;

    public ModelAnimator animator;

    public ButterflyLeviathanModel()
    {
        textureWidth = 150;
        textureHeight = 250;
        headFrillL = new WRModelRenderer(this, 31, 12);
        headFrillL.setRotationPoint(-3.4F, -4.0F, -3.1F);
        headFrillL.addBox(0.0F, -4.3F, -4.5F, 0, 5, 9, 0.0F);
        setRotateAngle(headFrillL, 0.0F, 0.0F, -0.875631685725555F);
        bottomWingFinMembraneR2 = new WRModelRenderer(this, 92, 200);
        bottomWingFinMembraneR2.setRotationPoint(5.9F, 0.0F, 0.4F);
        bottomWingFinMembraneR2.addBox(-5.9F, 0.0F, -0.8F, 11, 0, 9, 0.0F);
        bottomWingFinPhalangeR2 = new WRModelRenderer(this, 32, 187);
        bottomWingFinPhalangeR2.setRotationPoint(11.0F, -0.1F, -0.4F);
        bottomWingFinPhalangeR2.addBox(0.0F, -1.1F, -0.9F, 14, 2, 2, 0.0F);
        setRotateAngle(bottomWingFinPhalangeR2, 0.0F, 0.0F, -0.3490658503988659F);
        bottomWingFinPhalangeL1 = new WRModelRenderer(this, 0, 187);
        bottomWingFinPhalangeL1.setRotationPoint(-5.1F, -0.8F, -1.9F);
        bottomWingFinPhalangeL1.addBox(-11.9F, -1.1F, -1.5F, 12, 2, 3, 0.0F);
        setRotateAngle(bottomWingFinPhalangeL1, 0.0F, 0.0F, -0.3490658503988659F);
        mouthBottom = new WRModelRenderer(this, 0, 55);
        mouthBottom.setRotationPoint(0.0F, 1.4F, -6.2F);
        mouthBottom.addBox(-3.0F, -1.3F, -7.1F, 6, 4, 8, 0.0F);
        bottomWingFinMembraneR3 = new WRModelRenderer(this, 67, 200);
        bottomWingFinMembraneR3.setRotationPoint(11.0F, 0.0F, 0.3F);
        bottomWingFinMembraneR3.addBox(0.0F, 0.0F, -0.2F, 11, 0, 8, 0.0F);
        setRotateAngle(bottomWingFinMembraneR3, 0.0F, 0.0F, -0.17453292519943295F);
        bottomWingFinPhalangeL2 = new WRModelRenderer(this, 32, 187);
        bottomWingFinPhalangeL2.setRotationPoint(-11.0F, -0.1F, -0.4F);
        bottomWingFinPhalangeL2.addBox(-13.8F, -1.1F, -0.9F, 14, 2, 2, 0.0F);
        setRotateAngle(bottomWingFinPhalangeL2, 0.0F, 0.0F, 0.3490658503988659F);
        topWingFinPhalangeL2_1 = new WRModelRenderer(this, 21, 173);
        topWingFinPhalangeL2_1.setRotationPoint(5.8F, 0.0F, 0.4F);
        topWingFinPhalangeL2_1.addBox(-5.8F, 0.0F, -10.7F, 13, 0, 11, 0.0F);
        bottomWingFinMembraneR1 = new WRModelRenderer(this, 115, 200);
        bottomWingFinMembraneR1.setRotationPoint(4.7F, -0.1F, -0.4F);
        bottomWingFinMembraneR1.addBox(-5.7F, 0.0F, -0.8F, 12, 0, 10, 0.0F);
        bottomWingFinPhalangeR1 = new WRModelRenderer(this, 0, 187);
        bottomWingFinPhalangeR1.setRotationPoint(5.1F, -0.8F, -1.9F);
        bottomWingFinPhalangeR1.addBox(0.0F, -1.1F, -1.5F, 12, 2, 3, 0.0F);
        setRotateAngle(bottomWingFinPhalangeR1, 0.0F, 0.0F, 0.3490658503988659F);
        tail1 = new WRModelRenderer(this, 106, 57);
        tail1.setRotationPoint(0.0F, -2.0F, 10.2F);
        tail1.addBox(-4.5F, -4.1F, -2.2F, 9, 11, 13, 0.0F);
        topWingFinMembrane3L = new WRModelRenderer(this, 50, 173);
        topWingFinMembrane3L.setRotationPoint(13.0F, 0.0F, 0.1F);
        topWingFinMembrane3L.addBox(0.0F, 0.0F, -9.4F, 13, 0, 10, 0.0F);
        setRotateAngle(topWingFinMembrane3L, 0.0F, 0.0F, -0.2617993877991494F);
        body1 = new WRModelRenderer(this, 96, 0);
        body1.setRotationPoint(0.0F, 4.0F, 0.0F);
        body1.addBox(-5.5F, -6.3F, -4.6F, 11, 13, 15, 0.0F);
        tailFinBottom = new WRModelRenderer(this, 0, 108);
        tailFinBottom.setRotationPoint(-0.2F, 1.6F, 5.4F);
        tailFinBottom.addBox(0.0F, -0.5F, -6.2F, 0, 5, 16, 0.0F);
        footL = new WRModelRenderer(this, 74, 56);
        footL.setRotationPoint(0.0F, 3.7F, 0.0F);
        footL.addBox(-1.5F, -0.3F, -1.1F, 3, 3, 2, 0.0F);
        setRotateAngle(footL, 0.5337216852598659F, 0.0F, 0.0F);
        tail4 = new WRModelRenderer(this, 82, 129);
        tail4.setRotationPoint(0.0F, -0.1F, 10.2F);
        tail4.addBox(-3.0F, -3.7F, -2.2F, 6, 8, 13, 0.0F);
        topWingFinPhalangeL1 = new WRModelRenderer(this, 113, 155);
        topWingFinPhalangeL1.setRotationPoint(-5.0F, -3.7F, -1.9F);
        topWingFinPhalangeL1.addBox(0.0F, -1.1F, -1.5F, 14, 2, 3, 0.0F);
        setRotateAngle(topWingFinPhalangeL1, 0.0F, 3.141592653589793F, 0.3490658503988659F);
        topWingFinPhalangeR2 = new WRModelRenderer(this, 80, 155);
        topWingFinPhalangeR2.setRotationPoint(13.0F, -0.1F, -0.4F);
        topWingFinPhalangeR2.addBox(0.0F, -1.1F, -0.9F, 14, 2, 2, 0.0F);
        setRotateAngle(topWingFinPhalangeR2, 0.0F, 0.0F, 0.3490658503988659F);
        teethTop = new WRModelRenderer(this, 29, 40);
        teethTop.setRotationPoint(0.0F, -0.3F, -5.9F);
        teethTop.addBox(-2.5F, 0.3F, -0.7F, 5, 1, 8, 0.0F);
        legSegmentL2 = new WRModelRenderer(this, 76, 46);
        legSegmentL2.setRotationPoint(0.1F, 3.7F, 0.1F);
        legSegmentL2.addBox(-1.5F, -0.8F, -1.0F, 3, 5, 2, 0.0F);
        setRotateAngle(legSegmentL2, -0.5330235535590682F, 0.0F, 0.0F);
        tail5 = new WRModelRenderer(this, 44, 130);
        tail5.setRotationPoint(0.1F, 0.3F, 10.2F);
        tail5.addBox(-2.6F, -3.9F, -2.2F, 5, 7, 13, 0.0F);
        body2 = new WRModelRenderer(this, 102, 30);
        body2.setRotationPoint(0.0F, 0.1F, 10.2F);
        body2.addBox(-5.0F, -6.3F, -2.2F, 10, 12, 13, 0.0F);
        eyeR = new WRModelRenderer(this, 1, 19);
        eyeR.setRotationPoint(2.8F, -1.5F, -5.5F);
        eyeR.addBox(0.1F, -0.5F, -0.6F, 1, 1, 1, 0.0F);
        headFrillR = new WRModelRenderer(this, 31, 12);
        headFrillR.setRotationPoint(3.2F, -4.0F, -3.1F);
        headFrillR.addBox(0.1F, -4.3F, -4.5F, 0, 5, 9, 0.0F);
        setRotateAngle(headFrillR, 0.0F, 0.0F, 0.875631685725555F);
        bottomWingFinMembraneL2 = new WRModelRenderer(this, 22, 210);
        bottomWingFinMembraneL2.setRotationPoint(-5.3F, 0.0F, 0.4F);
        bottomWingFinMembraneL2.addBox(-5.7F, 0.0F, -0.8F, 11, 0, 9, 0.0F);
        legSegmentR1 = new WRModelRenderer(this, 75, 36);
        legSegmentR1.setRotationPoint(1.4F, 4.2F, -0.3F);
        legSegmentR1.addBox(-1.5F, 0.1F, -1.6F, 3, 4, 3, 0.0F);
        setRotateAngle(legSegmentR1, 1.0112596867176926F, 0.0F, 0.0F);
        neck1 = new WRModelRenderer(this, 62, 0);
        neck1.setRotationPoint(0.0F, -1.5F, -2.9F);
        neck1.addBox(-4.0F, -4.1F, -7.1F, 8, 10, 8, 0.0F);
        mouthTop = new WRModelRenderer(this, 0, 40);
        mouthTop.setRotationPoint(0.0F, 0.1F, -6.2F);
        mouthTop.addBox(-3.0F, -4.0F, -7.1F, 6, 4, 8, 0.0F);
        eyeL = new WRModelRenderer(this, 1, 19);
        eyeL.setRotationPoint(-2.8F, -1.5F, -5.5F);
        eyeL.addBox(-1.1F, -0.5F, -0.6F, 1, 1, 1, 0.0F);
        tail6 = new WRModelRenderer(this, 6, 130);
        tail6.setRotationPoint(0.1F, 0.1F, 10.0F);
        tail6.addBox(-2.2F, -3.9F, -2.2F, 4, 6, 14, 0.0F);
        topWingFinMembraneR3 = new WRModelRenderer(this, 58, 162);
        topWingFinMembraneR3.setRotationPoint(13.0F, 0.0F, 0.1F);
        topWingFinMembraneR3.addBox(0.0F, 0.0F, -0.5F, 13, 0, 10, 0.0F);
        setRotateAngle(topWingFinMembraneR3, 0.0F, 0.0F, -0.2617993877991494F);
        legThighL1 = new WRModelRenderer(this, 73, 21);
        legThighL1.setRotationPoint(-3.9F, 2.1F, 7.7F);
        legThighL1.addBox(-2.2F, -1.4F, -2.0F, 3, 7, 4, 0.0F);
        setRotateAngle(legThighL1, 0.5687630079445055F, 0.0F, 0.0F);
        neck2 = new WRModelRenderer(this, 30, 0);
        neck2.setRotationPoint(0.0F, 0.0F, -4.7F);
        neck2.addBox(-3.5F, -4.0F, -7.1F, 7, 9, 8, 0.0F);
        legSegmentL1 = new WRModelRenderer(this, 75, 36);
        legSegmentL1.setRotationPoint(-0.6F, 4.2F, -0.3F);
        legSegmentL1.addBox(-1.5F, 0.1F, -1.6F, 3, 4, 3, 0.0F);
        setRotateAngle(legSegmentL1, 0.9261035373325488F, 0.0F, 0.0F);
        tail2 = new WRModelRenderer(this, 106, 82);
        tail2.setRotationPoint(0.0F, 0.0F, 10.2F);
        tail2.addBox(-4.0F, -3.9F, -2.2F, 8, 10, 13, 0.0F);
        bottomWingFinMembraneL3 = new WRModelRenderer(this, 49, 210);
        bottomWingFinMembraneL3.setRotationPoint(-11.0F, 0.0F, 0.1F);
        bottomWingFinMembraneL3.addBox(-11.0F, 0.0F, 0.0F, 11, 0, 8, 0.0F);
        setRotateAngle(bottomWingFinMembraneL3, 0.0F, 0.0F, 0.17453292519943295F);
        legThighR1 = new WRModelRenderer(this, 73, 21);
        legThighR1.setRotationPoint(3.1F, 2.1F, 7.7F);
        legThighR1.addBox(0.0F, -1.4F, -2.0F, 3, 7, 4, 0.0F);
        setRotateAngle(legThighR1, 0.4836068585593608F, 0.0F, 0.0F);
        topWingFinMembraneR1 = new WRModelRenderer(this, 110, 162);
        topWingFinMembraneR1.setRotationPoint(4.6F, -0.1F, -0.4F);
        topWingFinMembraneR1.addBox(-5.6F, 0.0F, -0.8F, 14, 0, 12, 0.0F);
        head = new WRModelRenderer(this, 0, 21);
        head.setRotationPoint(0.0F, 0.0F, -6.2F);
        head.addBox(-3.5F, -4.0F, -7.1F, 7, 8, 8, 0.0F);
        neck3 = new WRModelRenderer(this, 0, 0);
        neck3.setRotationPoint(0.0F, 0.0F, -4.7F);
        neck3.addBox(-3.0F, -3.9F, -7.1F, 6, 8, 8, 0.0F);
        bottomWingFinMembraneL1 = new WRModelRenderer(this, -7, 210);
        bottomWingFinMembraneL1.setRotationPoint(-5.9F, -0.1F, -0.4F);
        bottomWingFinMembraneL1.addBox(-5.1F, 0.0F, -0.8F, 12, 0, 10, 0.0F);
        topWingFinMembraneR2 = new WRModelRenderer(this, 84, 162);
        topWingFinMembraneR2.setRotationPoint(6.0F, 0.0F, 0.4F);
        topWingFinMembraneR2.addBox(-6.0F, 0.0F, -0.8F, 13, 0, 11, 0.0F);
        topWingFinPhalangeR1 = new WRModelRenderer(this, 113, 155);
        topWingFinPhalangeR1.setRotationPoint(5.0F, -3.7F, -1.9F);
        topWingFinPhalangeR1.addBox(0.0F, -1.1F, -1.5F, 14, 2, 3, 0.0F);
        setRotateAngle(topWingFinPhalangeR1, 0.0F, 0.0F, -0.3490658503988659F);
        topWingFinPhalangeL2 = new WRModelRenderer(this, 80, 155);
        topWingFinPhalangeL2.setRotationPoint(13.1F, -0.1F, 0.2F);
        topWingFinPhalangeL2.addBox(-0.1F, -1.1F, -0.9F, 14, 2, 2, 0.0F);
        setRotateAngle(topWingFinPhalangeL2, 0.0F, 0.0F, 0.3490658503988659F);
        legSegmentR2 = new WRModelRenderer(this, 76, 46);
        legSegmentR2.setRotationPoint(-0.1F, 3.7F, 0.1F);
        legSegmentR2.addBox(-1.5F, -0.8F, -1.0F, 3, 5, 2, 0.0F);
        setRotateAngle(legSegmentR2, -0.5330235535590682F, 0.0F, 0.0F);
        footR = new WRModelRenderer(this, 74, 56);
        footR.setRotationPoint(0.0F, 3.7F, 0.0F);
        footR.addBox(-1.5F, -0.3F, -1.1F, 3, 3, 2, 0.0F);
        setRotateAngle(footR, 0.5337216852598659F, 0.0F, 0.0F);
        teethBottom = new WRModelRenderer(this, 29, 55);
        teethBottom.setRotationPoint(0.0F, -1.6F, -5.9F);
        teethBottom.addBox(-2.5F, -0.7F, -0.7F, 5, 1, 8, 0.0F);
        topWingFinMembraneL1 = new WRModelRenderer(this, -10, 173);
        topWingFinMembraneL1.setRotationPoint(4.8F, -0.1F, -0.4F);
        topWingFinMembraneL1.addBox(-5.7F, 0.0F, -10.3F, 14, 0, 12, 0.0F);
        tail3 = new WRModelRenderer(this, 108, 107);
        tail3.setRotationPoint(0.0F, 0.1F, 10.2F);
        tail3.addBox(-3.5F, -3.9F, -2.2F, 7, 9, 13, 0.0F);
        tailFinTop = new WRModelRenderer(this, 0, 97);
        tailFinTop.setRotationPoint(-0.2F, -3.4F, 5.4F);
        tailFinTop.addBox(0.0F, -6.8F, -6.2F, 0, 7, 16, 0.0F);
        head.addChild(headFrillL);
        bottomWingFinPhalangeR2.addChild(bottomWingFinMembraneR2);
        bottomWingFinPhalangeR1.addChild(bottomWingFinPhalangeR2);
        body1.addChild(bottomWingFinPhalangeL1);
        head.addChild(mouthBottom);
        bottomWingFinPhalangeR2.addChild(bottomWingFinMembraneR3);
        bottomWingFinPhalangeL1.addChild(bottomWingFinPhalangeL2);
        topWingFinPhalangeL2.addChild(topWingFinPhalangeL2_1);
        bottomWingFinPhalangeR1.addChild(bottomWingFinMembraneR1);
        body1.addChild(bottomWingFinPhalangeR1);
        body2.addChild(tail1);
        topWingFinPhalangeL2.addChild(topWingFinMembrane3L);
        tail6.addChild(tailFinBottom);
        legSegmentL2.addChild(footL);
        tail3.addChild(tail4);
        body1.addChild(topWingFinPhalangeL1);
        topWingFinPhalangeR1.addChild(topWingFinPhalangeR2);
        mouthTop.addChild(teethTop);
        legSegmentL1.addChild(legSegmentL2);
        tail4.addChild(tail5);
        body1.addChild(body2);
        head.addChild(eyeR);
        head.addChild(headFrillR);
        bottomWingFinPhalangeL2.addChild(bottomWingFinMembraneL2);
        legThighR1.addChild(legSegmentR1);
        body1.addChild(neck1);
        head.addChild(mouthTop);
        head.addChild(eyeL);
        tail5.addChild(tail6);
        topWingFinPhalangeR2.addChild(topWingFinMembraneR3);
        body2.addChild(legThighL1);
        neck1.addChild(neck2);
        legThighL1.addChild(legSegmentL1);
        tail1.addChild(tail2);
        bottomWingFinPhalangeL2.addChild(bottomWingFinMembraneL3);
        body2.addChild(legThighR1);
        topWingFinPhalangeR1.addChild(topWingFinMembraneR1);
        neck3.addChild(head);
        neck2.addChild(neck3);
        bottomWingFinPhalangeL1.addChild(bottomWingFinMembraneL1);
        topWingFinPhalangeR2.addChild(topWingFinMembraneR2);
        body1.addChild(topWingFinPhalangeR1);
        topWingFinPhalangeL1.addChild(topWingFinPhalangeL2);
        legSegmentR1.addChild(legSegmentR2);
        legSegmentR2.addChild(footR);
        mouthBottom.addChild(teethBottom);
        topWingFinPhalangeL1.addChild(topWingFinMembraneL1);
        tail2.addChild(tail3);
        tail6.addChild(tailFinTop);

        animator = ModelAnimator.create();
        tailArray = new WRModelRenderer[] {tail1, tail2, tail3, tail4, tail5, tail6};
        headArray = new WRModelRenderer[] {neck1, neck2, neck3, head};
        setDefaultPose();
    }

    @Override
    public void render(MatrixStack ms, IVertexBuilder buffer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        ms.push();
        ms.scale(3, 3, 3);
        ms.translate(0, -0.17f, 0);
        body1.render(ms, buffer, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        ms.pop();
    }

    @Override
    public void setRotationAngles(ButterflyLeviathanEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if (netHeadYaw < -180) netHeadYaw += 360;
        else if (netHeadYaw > 180) netHeadYaw -= 360;
        if (entity.areEyesInFluid(FluidTags.WATER) && !entityIn.isSitting())
            body1.rotateAngleX = headPitch * (QuikMaths.PI / 180f);
        else faceTarget(netHeadYaw, headPitch, 1, head, neck3, neck2, neck1);
    }

    private float globalSpeed = 0.5f;
    private float globalDegree = 0.5f;

    @Override
    public void setLivingAnimations(ButterflyLeviathanEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick)
    {
        entity = entityIn;
        float frame = entity.ticksExisted + partialTick;
        globalDegree = 0.5f;
        globalSpeed = 0.5f;

        resetToDefaultPose();
        animator.update(entityIn);
        setInitialPositions();

        if (!entity.isSitting())
        {
            if (entity.isInWater())
            {
                chainSwing(tailArray, globalSpeed - 0.1f, globalDegree - 0.4f, -2, limbSwing, limbSwingAmount);
                chainSwing(headArray, globalSpeed - 0.2f, globalDegree - 0.4f, 3f, limbSwing, limbSwingAmount);
                walk(legThighL1, globalSpeed - 0.4f, 0.1f, false, 0, 0, limbSwing, limbSwingAmount);
                walk(legThighR1, globalSpeed - 0.4f, 0.1f, false, 0, 0, limbSwing, limbSwingAmount);

                float wingSpeed = globalSpeed - 0.37f;

                flap(topWingFinPhalangeL1, wingSpeed, globalDegree + 0.1f, false, 0, 0.25f, limbSwing, limbSwingAmount);
                flap(topWingFinPhalangeL2, wingSpeed, globalDegree - 0.1f, false, 1, -0.2f, limbSwing, limbSwingAmount);
                flap(topWingFinMembrane3L, wingSpeed, globalDegree - 0.35f, false, 2, 0, limbSwing, limbSwingAmount);

                flap(bottomWingFinPhalangeL1, wingSpeed, globalDegree - 0.1f, false, 0, 0.25f, limbSwing, limbSwingAmount);
                flap(bottomWingFinPhalangeL2, wingSpeed, globalDegree - 0.1f, true, 1, 0.2f, limbSwing, limbSwingAmount);
                flap(bottomWingFinMembraneL3, wingSpeed, globalDegree - 0.35f, true, 2, 0, limbSwing, limbSwingAmount);

                flap(topWingFinPhalangeR1, wingSpeed, globalDegree + 0.1f, true, 0, 0.25f, limbSwing, limbSwingAmount);
                flap(topWingFinPhalangeR2, wingSpeed, globalDegree - 0.1f, false, 1, -0.2f, limbSwing, limbSwingAmount);
                flap(topWingFinMembraneR3, wingSpeed, globalDegree - 0.35f, false, 2, 0, limbSwing, limbSwingAmount);

                flap(bottomWingFinPhalangeR1, wingSpeed, globalDegree - 0.1f, true, 0, 0.25f, limbSwing, limbSwingAmount);
                flap(bottomWingFinPhalangeR2, wingSpeed, globalDegree - 0.1f, false, 1, 0, limbSwing, limbSwingAmount);
                flap(bottomWingFinMembraneR3, wingSpeed, globalDegree - 0.35f, false, 2, 0, limbSwing, limbSwingAmount);
            }
            else if (Math.abs(entity.getMotion().y) < 0.09)
            {
                flap(bottomWingFinPhalangeL1, globalSpeed - 0.1f, 0.5f, true, 0.75f, -0.25f, limbSwing, limbSwingAmount);
                swing(bottomWingFinPhalangeL1, globalSpeed - 0.1f, 0.5f, false, 0, 0, limbSwing, limbSwingAmount);
                flap(bottomWingFinPhalangeL2, globalSpeed - 0.1f, 1f, false, 0.5f, 0, limbSwing, limbSwingAmount);
                walk(bottomWingFinPhalangeL2, globalSpeed - 0.1f, 0, false, 0.5f, 0.5f, limbSwing, limbSwingAmount);

                flap(bottomWingFinPhalangeR1, globalSpeed - 0.1f, 0.5f, true, 0.75f, 0.25f, limbSwing, limbSwingAmount);
                swing(bottomWingFinPhalangeR1, globalSpeed - 0.1f, 0.5f, false, 0, 0, limbSwing, limbSwingAmount);
                flap(bottomWingFinPhalangeR2, globalSpeed - 0.1f, 1f, false, 0.5f, 0, limbSwing, limbSwingAmount);
                walk(bottomWingFinPhalangeR2, globalSpeed - 0.1f, 0, false, 0.5f, 0.5f, limbSwing, limbSwingAmount);
            }
        }

        if (animator.setAnimation(ButterflyLeviathanEntity.CONDUIT_ANIMATION) || animator.setAnimation(ButterflyLeviathanEntity.ROAR_ANIMATION))
            roarAnim();
        if (animator.setAnimation(ButterflyLeviathanEntity.BITE_ANIMATION)) biteAnim();

        idle(frame);
    }

    private void setInitialPositions()
    {
        if (!entity.isUnderWater())
        {
            neck1.rotateAngleX = -0.6f;
            neck2.rotateAngleX = 0.15f;
            neck3.rotateAngleX = 0.2f;
            head.rotateAngleX = 0.3f;

            topWingFinPhalangeL1.rotateAngleY = 4.25f;
            topWingFinPhalangeL2.rotateAngleY = 0.5f;
            bottomWingFinPhalangeL1.rotateAngleY = -0.5f;
            bottomWingFinPhalangeL1.rotateAngleZ = -0.6f;
            bottomWingFinPhalangeL2.rotateAngleY = 0.7f;
            bottomWingFinPhalangeL2.rotateAngleZ = 0.6f;
            bottomWingFinPhalangeL2.rotateAngleX = 0.2f;

            topWingFinPhalangeR1.rotateAngleY = -1.05f;
            topWingFinPhalangeR2.rotateAngleY = -0.5f;
            bottomWingFinPhalangeR1.rotateAngleY = 0.5f;
            bottomWingFinPhalangeR1.rotateAngleZ = 0.6f;
            bottomWingFinPhalangeR2.rotateAngleY = -0.7f;
            bottomWingFinPhalangeR2.rotateAngleZ = -0.6f;
            bottomWingFinPhalangeR2.rotateAngleX = 0.2f;
        }

        if (!entity.isInWater())
        {
            legThighL1.rotateAngleX = -1.55f;
            legThighL1.rotateAngleY = 0.5f;
            legSegmentL1.rotateAngleX = 1.6f;
            legSegmentL2.rotateAngleX = -1.6f;
            footL.rotateAngleX = 0f;

            legThighR1.rotateAngleX = -1.55f;
            legThighR1.rotateAngleY = -0.5f;
            legSegmentR1.rotateAngleX = 1.6f;
            legSegmentR2.rotateAngleX = -1.6f;
            footR.rotateAngleX = 0f;

            if (entity.isSitting())
            {
                bottomWingFinPhalangeL1.rotateAngleY = 0.75f;
                bottomWingFinPhalangeL2.rotateAngleX = 0.1f;
                bottomWingFinPhalangeL2.rotateAngleZ = -0.1f;

                bottomWingFinPhalangeR1.rotateAngleY = -0.75f;
                bottomWingFinPhalangeR2.rotateAngleX = 0.1f;
                bottomWingFinPhalangeR2.rotateAngleZ = 0.1f;
            }
        }
    }

    @Override
    public void idle(float frame)
    {
        if (!entity.isUnderWater())
        {
            flap(topWingFinPhalangeL1, 0.05f, 0.1f, false, 0, 0, frame, 0.5f);
            swing(topWingFinPhalangeL1, 0.045f, 0.025f, false, 0.5f, 0, frame, 0.5f);
            swing(topWingFinPhalangeL2, 0.045f, 0.05f, false, 0.75f, 0, frame, 0.5f);

            flap(topWingFinPhalangeR1, 0.05f, 0.1f, true, 0, 0, frame, 0.5f);
            swing(topWingFinPhalangeR1, 0.045f, 0.025f, true, 0.5f, 0, frame, 0.5f);
            swing(topWingFinPhalangeR2, 0.045f, 0.05f, true, 0.75f, 0, frame, 0.5f);

            swing(bottomWingFinPhalangeL1, globalSpeed - 0.45f, 0.05f, false, 0, 0, frame, 0.5f);
            swing(bottomWingFinPhalangeL2, globalSpeed - 0.45f, -0.1f, false, 0, 0, frame, 0.5f);
            walk(bottomWingFinPhalangeL2, globalSpeed - 0.45f, -0.05f, false, 0, 0, frame, 0.5f);

            swing(bottomWingFinPhalangeR1, 0.05f, 0.05f, true, 0, 0, frame, 0.5f);
            swing(bottomWingFinPhalangeR2, 0.05f, -0.1f, true, 0, 0, frame, 0.5f);
            walk(bottomWingFinPhalangeR2, 0.05f, -0.05f, false, 0, 0, frame, 0.5f);
        }

        globalDegree = 0.5f;
        chainWave(headArray, globalSpeed - 0.45f, globalDegree - 0.46f, entity.isUnderWater()? 3 : -3, frame, 0.5f);
        walk(mouthBottom, globalSpeed - 0.45f, 0.15f, false, -0.6f, 0.15f, frame, 0.5f);

        float degree = entity.isInWater()? 0.1f : 0.6f;
        chainSwing(tailArray, globalSpeed - 0.47f, degree, -2, frame, 0.5f);
        chainWave(tailArray, globalSpeed - 0.47f, 0.05f, -2, frame, 0.5f);

    }

    public void roarAnim() // 46
    {
        animator.startKeyframe(8);
        for (WRModelRenderer box : headArray)
        {
            animator.rotate(box, -0.15f, 0, 0);
        }
        animator.rotate(mouthBottom, 0.5f, 0, 0);
        animator.rotate(topWingFinPhalangeL1, 0, -0.2f, 0);
        animator.rotate(topWingFinPhalangeL2, 0, 0, -0.5f);
        animator.rotate(topWingFinPhalangeR1, 0, 0.2f, 0);
        animator.rotate(topWingFinPhalangeR2, 0, 0, -0.5f);
        animator.rotate(headFrillL, 0, 0, 0.8f);
        animator.rotate(headFrillR, 0, 0, -0.8f);
        animator.endKeyframe();
        animator.setStaticKeyframe(30);
        animator.resetKeyframe(8);
    }

    public void biteAnim() // 20
    {
        animator.startKeyframe(10);
        animator.rotate(neck1, -0.4f, 0, 0);
        animator.rotate(head, 0.4f, 0, 0);
        animator.rotate(mouthBottom, 0.65f, 0, 0);
        animator.endKeyframe();
        animator.startKeyframe(4);
        animator.rotate(neck1, 0.4f, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(5);
    }

}
