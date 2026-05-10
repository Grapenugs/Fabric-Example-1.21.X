package net.grapenugs.examplemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.grapenugs.examplemod.ExampleMod;
import net.grapenugs.examplemod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOONSTONE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID, "moonstone_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAW_MOONSTONE_ORE))
                    .displayName(Text.translatable("itemgroup.examplemod.moonstone_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_MOONSTONE_ORE);
                        entries.add(ModItems.MOONSTONE_INGOT);
                        entries.add(ModItems.MAGIC_WAND);
                    }).build());

    public static final ItemGroup MOONSTONE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID, "moonstone_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MOONSTONE_BLOCK))
                    .displayName(Text.translatable("itemgroup.examplemod.moonstone_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MOONSTONE_BLOCK);
                        entries.add(ModBlocks.MOONSTONE_ORE_BLOCK);
                    }).build());


    public static void registerItemGroups(){
        ExampleMod.LOGGER.info("Register Item Groups for " + ExampleMod.MOD_ID);
    }
}
