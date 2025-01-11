package net.grapenugs.examplemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.grapenugs.examplemod.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_MOONSTONE_ORE = registerItem("raw_moonstone_ore", new Item(new Item.Settings()));
    public static final Item MOONSTONE_INGOT = registerItem("moonstone_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(RAW_MOONSTONE_ORE);
            entries.add(MOONSTONE_INGOT);
        });
    }
}
