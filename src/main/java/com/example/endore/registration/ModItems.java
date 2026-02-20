package com.example.endore.registration;

import com.example.endore.EndOreMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ItemBlock endOreItemBlock = new ItemBlock(ModBlocks.END_ORE_BLOCK);
        endOreItemBlock.setRegistryName(ModBlocks.END_ORE_BLOCK.getRegistryName());
        
        ItemBlock damagedEndOreItemBlock = new ItemBlock(ModBlocks.DAMAGED_END_ORE_BLOCK);
        damagedEndOreItemBlock.setRegistryName(ModBlocks.DAMAGED_END_ORE_BLOCK.getRegistryName());

        event.getRegistry().registerAll(
            endOreItemBlock,
            damagedEndOreItemBlock
        );
    }
}
