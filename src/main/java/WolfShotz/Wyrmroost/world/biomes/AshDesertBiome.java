//package WolfShotz.Wyrmroost.world.biomes;
//
//import WolfShotz.Wyrmroost.world.features.AshTreeFeature;
//import WolfShotz.Wyrmroost.world.features.ListisCactusFeature;
//import WolfShotz.Wyrmroost.util.world.WRBiome;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.World;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.DefaultBiomeFeatures;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.IFeatureConfig;
//import net.minecraft.world.gen.feature.structure.MineshaftConfig;
//import net.minecraft.world.gen.feature.structure.MineshaftStructure;
//import net.minecraft.world.gen.placement.FrequencyConfig;
//import net.minecraft.world.gen.placement.Placement;
//
//public class AshDesertBiome extends WRBiome
//{
//    public float prevSunBrightness;
//
//    public AshDesertBiome()
//    {
//        super(10, new Biome.Builder()
////                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(WRBlocks.ASH.get().getDefaultState(), WRBlocks.ASH_BLOCK.get().getDefaultState(), Blocks.GRAVEL.getDefaultState()))
//                .precipitation(Biome.RainType.NONE)
//                .category(Biome.Category.DESERT)
//                .depth(0.125F)
//                .scale(0.05F)
//                .temperature(2.0F)
//                .downfall(0.0F)
//                .waterColor(0x7a7a7a)
//                .waterFogColor(0xa1a1a1));
//
//        addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
//        addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
//        DefaultBiomeFeatures.addCarvers(this);
//        DefaultBiomeFeatures.addStructures(this);
//        DefaultBiomeFeatures.addDesertLakes(this);
//        DefaultBiomeFeatures.addMonsterRooms(this);
//        DefaultBiomeFeatures.addStoneVariants(this);
//        DefaultBiomeFeatures.addOres(this);
//        DefaultBiomeFeatures.addSedimentDisks(this);
//        DefaultBiomeFeatures.addDeadBushes(this);
//        DefaultBiomeFeatures.addMushrooms(this);
//        DefaultBiomeFeatures.addSprings(this);
//        DefaultBiomeFeatures.addDesertFeatures(this);
//        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new AshTreeFeature(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(15)));
//        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new CinisRootFeature(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(9)));
//        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new ListisCactusFeature(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(14)));
//
//        addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
//        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.HUSK, 80, 4, 4));
//    }
//
//    @Override
//    public Vec3d getFogColor(float celestialAngle, float partialTicks)
//    {
//        float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
//        f = MathHelper.clamp(f, 0.0F, 0.1F);
//        return new Vec3d(f, f, f);
//    }
//
//    @Override
//    public float getSunBrightness(World world, float partialTicks)
//    {
//        return super.getSunBrightness(world, partialTicks) - 0.5f;
//    }
//
//    @Override
//    public boolean doesXZShowFog(int x, int z) { return true; }
//
//    @Override
//    public int getSkyColorByTemp(float currentTemperature) { return 0x525252; }
//
//    @Override
//    public int getGrassColor(BlockPos pos) { return super.getGrassColor(pos) - 12; }
//
//    @Override
//    public int getFoliageColor(BlockPos pos) { return super.getFoliageColor(pos); }
//}
