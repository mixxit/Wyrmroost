package WolfShotz.Wyrmroost.setup;

import WolfShotz.Wyrmroost.Wyrmroost;
import WolfShotz.Wyrmroost.content.blocks.BlockGeodeOre;
import WolfShotz.Wyrmroost.content.blocks.base.BlockBase;
import WolfShotz.Wyrmroost.util.ModUtils;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockSetup
{
    @ObjectHolder(Wyrmroost.modID + ":platinum_ore")
    public static BlockBase blockplatinumore;

    @ObjectHolder(Wyrmroost.modID + ":platinum_block")
    public static Block blockplatinum;

    @ObjectHolder(Wyrmroost.modID + ":geode_ore")
    public static BlockGeodeOre blockgeodeore;

    @ObjectHolder(Wyrmroost.modID + ":geode_block")
    public static BlockBase blockgeode;

    @SubscribeEvent
    public static void blockSetup(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll (
                blockplatinumore = new BlockBase("platinum_ore", Material.ROCK, ToolType.PICKAXE, 1, 3, SoundType.STONE),
                blockplatinum = new BlockBase("platinum_block", Material.IRON, ToolType.PICKAXE, 1, 5, 5, 1, SoundType.METAL, true),

                blockgeodeore = new BlockGeodeOre(),
                blockgeode = new BlockBase("geode_block", Material.IRON, ToolType.PICKAXE, 2, 5, 5, 1, SoundType.METAL, true)
        );

        ModUtils.L.info("Block Setup Complete");
    }
}