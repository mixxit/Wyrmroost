package WolfShotz.Wyrmroost.event;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan.ButterflyLeviathanEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan.ButterflyLeviathanRenderer;
import WolfShotz.Wyrmroost.content.entities.dragon.minutus.MinutusEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.minutus.MinutusRenderer;
import WolfShotz.Wyrmroost.content.entities.dragon.owdrake.OWDrakeEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.owdrake.OWDrakeRenderer;
import WolfShotz.Wyrmroost.content.entities.dragon.rooststalker.RoostStalkerEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.rooststalker.RoostStalkerRenderer;
import WolfShotz.Wyrmroost.content.entities.dragon.sliverglider.SilverGliderEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.sliverglider.SilverGliderRenderer;
import WolfShotz.Wyrmroost.content.entities.dragonegg.DragonEggEntity;
import WolfShotz.Wyrmroost.content.entities.dragonegg.DragonEggRenderer;
import WolfShotz.Wyrmroost.util.utils.ModUtils;
import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Objects;
import java.util.Set;

import static net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Created by WolfShotz - 7/3/19 19:03 <p>
 *
 * Class responsible for the setup and registration of entities, and their spawning.
 */
@Mod.EventBusSubscriber(modid = Wyrmroost.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEntities
{
    private static final String ID = Wyrmroost.MOD_ID + ":";
    
    // Entity List Start
    @ObjectHolder(ID + "dragon_egg")            public static EntityType<DragonEggEntity>           dragonEgg;
    
    @ObjectHolder(ID + "overworld_drake")       public static EntityType<OWDrakeEntity>             overworldDrake;
    @ObjectHolder(ID + "minutus")               public static EntityType<MinutusEntity>             minutus;
    @ObjectHolder(ID + "silver_glider")         public static EntityType<SilverGliderEntity>        silverGlider;
    @ObjectHolder(ID + "roost_stalker")         public static EntityType<RoostStalkerEntity>        roostStalker;
    @ObjectHolder(ID + "butterfly_leviathan")   public static EntityType<ButterflyLeviathanEntity>  butterflyLeviathan;
    // Entity List End
    
    /**
     * Method called in before item registry event to instatiate these fields.
     * It is important that these fields are populated BEFORE item registration so spawn eggs are registered properly.
     * TODO Not ideal. use this until forge reevaluates
     */
    public static void buildEntities() {
        dragonEgg           = buildEntity("dragon_egg", DragonEggEntity::new, EntityClassification.CREATURE, 1f, 1f);
        overworldDrake      = buildEntity("overworld_drake", OWDrakeEntity::new, EntityClassification.CREATURE, 2.376f, 2.45f);
        minutus             = buildEntity("minutus", MinutusEntity::new, EntityClassification.CREATURE, 0.6f, 0.2f);
        silverGlider        = buildEntity("silver_glider", SilverGliderEntity::new, EntityClassification.CREATURE, 1.5f, 0.75f);
        roostStalker        = buildEntity("roost_stalker", RoostStalkerEntity::new, EntityClassification.CREATURE, 0.65f, 0.5f);
        butterflyLeviathan  = buildEntity("butterfly_leviathan", ButterflyLeviathanEntity::new, EntityClassification.CREATURE, 3.25f, 3.25f);
    }
    
    /**
     * Registers World Spawning for entities
     */
    private static void registerEntityWorldSpawns() {
        registerSpawning(overworldDrake, 8, 1, 3, getDrakeBiomes());
        registerSpawning(minutus, 35, 1, 1, getMinutusBiomes());
        registerSpawning(silverGlider, 2, 2, 5, getSilverGliderBiomes());
        registerSpawning(roostStalker, 9, 3, 18, getStalkerBiomes());
        EntitySpawnPlacementRegistry.register(silverGlider, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SilverGliderEntity::canSpawnHere);
    }

    /**
     * Registers Model Rendering and animation for entities
     */
    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders() {
//        RenderingRegistry.registerEntityRenderingHandler(PartEntity.class, MultiPartRenderer::new);
        
        RenderingRegistry.registerEntityRenderingHandler(DragonEggEntity.class, DragonEggRenderer::new);
        
        RenderingRegistry.registerEntityRenderingHandler(OWDrakeEntity.class, OWDrakeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(MinutusEntity.class, MinutusRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(SilverGliderEntity.class, SilverGliderRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(RoostStalkerEntity.class, RoostStalkerRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ButterflyLeviathanEntity.class, ButterflyLeviathanRenderer::new);
    }

    @SubscribeEvent
    public static void entitySetup(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll (
                dragonEgg,

                overworldDrake,
                minutus,
                silverGlider,
                roostStalker,
                butterflyLeviathan
        );
        registerEntityWorldSpawns();
    }

    // ================================
    //   Entity Biome Spawn Locations
    // ================================
    // Use Biome Dictionary for overworld
    // dragons for compabitility with
    // custom biomes.
    //
    // Dimension dragons will have spawns
    // in our custom biomes, so they wont be
    // needing this.

    private static Set<Biome> getDrakeBiomes() {
        return ModUtils.collectAll(
                BiomeDictionary.getBiomes(Type.SAVANNA),
                BiomeDictionary.getBiomes(Type.PLAINS)
        );
    }
    
    private static Set<Biome> getSilverGliderBiomes() {
        return ModUtils.collectAll(
                BiomeDictionary.getBiomes(Type.BEACH),
                BiomeDictionary.getBiomes(Type.OCEAN)
        );
    }
    
    private static Set<Biome> getStalkerBiomes() {
        return ModUtils.collectAll(
                BiomeDictionary.getBiomes(Type.FOREST),
                BiomeDictionary.getBiomes(Type.PLAINS),
                BiomeDictionary.getBiomes(Type.MOUNTAIN)
        );
    }
    
    private static Set<Biome> getMinutusBiomes() {
        Set<Biome> biomes = Sets.newHashSet();
        for (Biome biome : BiomeDictionary.getBiomes(Type.SANDY))
            if (!BiomeDictionary.hasType(biome, Type.MESA)) biomes.add(biome);
        
        return biomes;
    }

    // ================================
    //   SetupEntity Helper Functions
    // ================================

    /**
     * Helper Function that turns this stupidly long line into something more nicer to look at
     */
    private static <T extends Entity> EntityType<T> buildEntity(String name, EntityType.IFactory<T> entity, EntityClassification classify, float width, float height) {
        EntityType<T> builder = EntityType.Builder.create(entity, classify).size(width, height).build(Wyrmroost.MOD_ID + ":" + name);
        builder.setRegistryName(name);
        return builder;
    }
    
    /**
     * Builder w/out size
     */
    private static <T extends Entity> EntityType<T> buildEntity(String name, EntityType.IFactory<T> entity, EntityClassification classify) {
        EntityType<T> builder = EntityType.Builder.create(entity, classify).build(Wyrmroost.MOD_ID + ":" + name);
        builder.setRegistryName(name);
        return builder;
    }

    /**
     * Helper method allowing for easier entity world spawning setting
     */
    private static void registerSpawning(EntityType<?> entity, int frequency, int minAmount, int maxAmount, Set<Biome> biomes) {
        biomes.stream()
                .filter(Objects::nonNull)
                .forEach(biome -> biome
                         .getSpawns(entity.getClassification())
                         .add(new Biome.SpawnListEntry(entity, frequency, minAmount, maxAmount)));
    }

}
