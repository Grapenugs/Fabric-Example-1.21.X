package net.grapenugs.examplemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.grapenugs.examplemod.ExampleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block MOONSTONE_ORE_BLOCK = registerBlock("moonstone_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static Block MOONSTONE_BLOCK = registerBlock("moonstone_block", new Block(AbstractBlock.Settings.create().strength(3f)
            .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.MOD_ID, name), block);
    }

    //Helper function
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        ExampleMod.LOGGER.info("Registering Mod Blocks for " +ExampleMod.MOD_ID);

        //Adds block to creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->{
            entries.add(MOONSTONE_ORE_BLOCK);
            entries.add(MOONSTONE_BLOCK);
        });
    }
}
