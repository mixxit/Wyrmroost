package WolfShotz.Wyrmroost.data;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.registry.WREntities;
import WolfShotz.Wyrmroost.registry.WRItems;
import WolfShotz.Wyrmroost.util.ModUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.NBTPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.EntityHasProperty;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.LootingEnchantBonus;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.Smelt;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static WolfShotz.Wyrmroost.registry.WRBlocks.*;

public class LootTables extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = ImmutableList.of(
            Pair.of(BlockLoot::new, LootParameterSets.BLOCK),
            Pair.of(EntityLoot::new, LootParameterSets.ENTITY)
    );

    public LootTables(DataGenerator gen)
    {
        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {}

    public static class BlockLoot extends BlockLootTables
    {
        public static final LootFunction.Builder<?> FORTUNE = ApplyBonus.uniformBonusCount(Enchantments.FORTUNE);

        public final Map<Block, LootTable.Builder> lootTables = Maps.newHashMap();

        @Override
        @SuppressWarnings("ConstantConditions")
        protected void addTables()
        {
//            registerLootTable(ASH.get(), block -> droppingWithSilkTouchOrRandomly(block, WRItems.ASH_PILE.get(), RandomValueRange.of(3f, 5f)));

            registerOre(BLUE_GEODE_ORE.get(), WRItems.BLUE_GEODE.get());
            registerOre(RED_GEODE_ORE.get(), WRItems.RED_GEODE.get());
            registerOre(PURPLE_GEODE_ORE.get(), WRItems.PURPLE_GEODE.get());

//            registerOre(BLUE_CRYSTAL_ORE.get(), WRItems.BLUE_SHARD.get());
//            registerLootTable(BLUE_CRYSTAL.get(), crystal -> droppingWithSilkTouch(crystal, withExplosionDecay(crystal, item(WRItems.BLUE_SHARD.get(), 1).acceptFunction(FORTUNE))));
//
//            registerOre(GREEN_CRYSTAL_ORE.get(), WRItems.GREEN_SHARD.get());
//            registerLootTable(GREEN_CRYSTAL.get(), crystal -> droppingWithSilkTouch(crystal, withExplosionDecay(crystal, item(WRItems.GREEN_SHARD.get(), 1).acceptFunction(FORTUNE))));
//
//            registerOre(ORANGE_CRYSTAL_ORE.get(), WRItems.ORANGE_SHARD.get());
//            registerLootTable(ORANGE_CRYSTAL.get(), crystal -> droppingWithSilkTouch(crystal, withExplosionDecay(crystal, item(WRItems.ORANGE_SHARD.get(), 1).acceptFunction(FORTUNE))));
//
//            registerOre(YELLOW_CRYSTAL_ORE.get(), WRItems.YELLOW_SHARD.get());
//            registerLootTable(YELLOW_CRYSTAL.get(), crystal -> droppingWithSilkTouch(crystal, withExplosionDecay(crystal, item(WRItems.YELLOW_SHARD.get(), 1).acceptFunction(FORTUNE))));
//
//            registerSilkTouch(CANARI_LEAVES.get());

            // All blocks that have not been given special treatment above, drop themselves!
            for (Block block : getKnownBlocks())
            {
                if (!lootTables.containsKey(block) && block.getLootTable() != net.minecraft.world.storage.loot.LootTables.EMPTY) // Loottable is already set to not have one, ignore.
                    registerDropSelfLootTable(block);
            }
        }

        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer)
        {
            addTables();

            for (Block block : getKnownBlocks())
            {
                ResourceLocation loot = block.getLootTable();
                if (loot == net.minecraft.world.storage.loot.LootTables.EMPTY)
                    continue; // Loottable is already set to not have one, ignore.
                if (!lootTables.containsKey(block))
                    throw new IllegalStateException(String.format("Missing loottable '%s' for '%s', How the fuck did this happen?", loot, Registry.BLOCK.getKey(block)));
                consumer.accept(loot, lootTables.remove(block));
            }

            if (!lootTables.isEmpty())
                throw new IllegalStateException("Created block loot tables for non-blocks: " + lootTables.keySet());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() { return ModUtils.getRegistryEntries(BLOCKS); }

        private void registerOre(Block ore, Item output)
        {
            registerLootTable(ore, block -> droppingItemWithFortune(block, output));
        }

        @Override
        protected void registerLootTable(Block blockIn, LootTable.Builder table) { lootTables.put(blockIn, table); }
    }

    public static class EntityLoot extends EntityLootTables
    {
        private static final ILootCondition.IBuilder UNTAMED_AND_ADULT = EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(new EntityFlagsPredicate(null, null, null, null, false)).nbt(new NBTPredicate(Util.make(new CompoundNBT(), c -> c.putString("OwnerUUID", "")))));
        private static final LootFunction.Builder<?> ON_FIRE_SMELT = Smelt.func_215953_b().acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).build())));

        private final Map<EntityType<?>, LootTable.Builder> lootTables = Maps.newHashMap();

        /**
         * Our way is much neater and cooler anyway. fuck mojang
         */
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer)
        {
            addTables();

            for (EntityType<?> entity : getKnownEntities())
            {
                if (!lootTables.containsKey(entity))
                {
                    if (entity.getClassification() == EntityClassification.MISC) continue;
                    throw new IllegalArgumentException(String.format("Missing Loottable for entry: '%s'", entity.getRegistryName()));
                }
                consumer.accept(entity.getLootTable(), lootTables.remove(entity));
            }
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities()
        {
            return ModUtils.getRegistryEntries(WREntities.ENTITIES);
        }

        /**
         * @param types the types to register an empty loot tables
         * @deprecated SHOULD ONLY USE THIS WHEN AN ENTITY ABSOLUTELY DOES NOT HAVE ONE, OR IN TESTING!
         */
        public void registerEmptyTables(EntityType<?>... types)
        {
            for (EntityType<?> type : types)
            {
                Wyrmroost.LOG.warn("Registering EMPTY Loottable for: '{}'", type.getRegistryName());
                registerLootTable(type, LootTable.builder());
            }
        }

        @Override
        protected void registerLootTable(EntityType<?> type, LootTable.Builder table)
        {
            lootTables.put(type, table);
        }

        private static LootingEnchantBonus.Builder looting(float min, float max)
        {
            return LootingEnchantBonus.builder(RandomValueRange.of(min, max));
        }

        private static ItemLootEntry.Builder<?> item(IItemProvider itemIn, float minIn, float maxIn)
        {
            return ItemLootEntry.builder(itemIn).acceptFunction(SetCount.builder(RandomValueRange.of(minIn, maxIn)));
        }

        private static ItemLootEntry.Builder<?> item(IItemProvider itemIn, int amount)
        {
            return ItemLootEntry.builder(itemIn).acceptFunction(SetCount.builder(ConstantRange.of(amount)));
        }

        @Override
        protected void addTables()
        {
            registerLootTable(WREntities.LESSER_DESERTWYRM.get(), LootTable.builder().addLootPool(singleRollPool().addEntry(item(WRItems.LDWYRM.get(), 1).acceptFunction(ON_FIRE_SMELT))));

            registerLootTable(WREntities.OVERWORLD_DRAKE.get(), LootTable.builder()
                    .addLootPool(singleRollPool().addEntry(item(Items.LEATHER, 5, 10).acceptFunction(looting(1, 4))))
                    .addLootPool(singleRollPool().addEntry(meat(WRItems.RAW_COMMON_MEAT.get(), 1, 7, 2, 3)))
                    .addLootPool(singleRollPool().addEntry(item(WRItems.DRAKE_BACKPLATE.get(), 1)).acceptCondition(KilledByPlayer.builder()).acceptCondition(UNTAMED_AND_ADULT).acceptCondition(RandomChance.builder(0.25f))));

            registerLootTable(WREntities.ROOSTSTALKER.get(), LootTable.builder()
                    .addLootPool(singleRollPool().addEntry(meat(WRItems.RAW_LOWTIER_MEAT.get(), 0, 3, 1, 3)))
                    .addLootPool(singleRollPool().addEntry(item(Items.GOLD_NUGGET, 0, 2)).acceptCondition(KilledByPlayer.builder())));
            registerLootTable(WREntities.DRAGON_FRUIT_DRAKE.get(), LootTable.builder().addLootPool(singleRollPool().addEntry(item(Items.APPLE, 0, 6))));

            registerLootTable(WREntities.CANARI_WYVERN.get(), LootTable.builder()
                    .addLootPool(singleRollPool().addEntry(meat(WRItems.RAW_COMMON_MEAT.get(), 0, 3, 1, 2)))
                    .addLootPool(singleRollPool().addEntry(item(Items.FEATHER, 1, 4).acceptFunction(looting(2, 6)))));

            registerLootTable(WREntities.SILVER_GLIDER.get(), LootTable.builder().addLootPool(singleRollPool().addEntry(meat(WRItems.RAW_LOWTIER_MEAT.get(), 0, 5, 1, 3))));

            registerLootTable(WREntities.BUTTERFLY_LEVIATHAN.get(), LootTable.builder()
                    .addLootPool(singleRollPool().addEntry(meat(WRItems.RAW_APEX_MEAT.get(), 4, 6, 2, 4)))
                    .addLootPool(LootPool.builder().rolls(RandomValueRange.of(1, 4)).addEntry(item(Items.SEA_PICKLE, 0, 2).acceptFunction(looting(1, 2))).addEntry(item(Items.SEAGRASS, 4, 14)).addEntry(item(Items.KELP, 16, 24)))
                    .addLootPool(singleRollPool().addEntry(item(Items.HEART_OF_THE_SEA, 1).acceptCondition(RandomChance.builder(0.1f))).addEntry(item(Items.NAUTILUS_SHELL, 1).acceptCondition(RandomChance.builder(0.4f)))));
        }

        private static ItemLootEntry.Builder<?> meat(IItemProvider itemIn, int minAmount, int maxAmount, int lootingMin, int lootingMax)
        {
            return item(itemIn, minAmount, maxAmount).acceptFunction(ON_FIRE_SMELT).acceptFunction(looting(lootingMin, lootingMax));
        }

        private static LootPool.Builder singleRollPool() { return LootPool.builder().rolls(ConstantRange.of(1)); }
    }
}
