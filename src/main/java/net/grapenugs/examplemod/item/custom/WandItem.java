package net.grapenugs.examplemod.item.custom;

import net.grapenugs.examplemod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.DIAMOND_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.DIRT,
                    Blocks.OAK_LEAVES, ModBlocks.MOONSTONE_BLOCK,
                    Blocks.GRASS_BLOCK, Blocks.PEARLESCENT_FROGLIGHT
            );

    public WandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(WAND_MAP.containsKey(clickedBlock)) {
            if(!world.isClient) {
                world.setBlockState(context.getBlockPos(), WAND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS);

            }

        }

        return ActionResult.SUCCESS;
    }
}
