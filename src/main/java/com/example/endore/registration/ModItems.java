package com.example.endore.registration;

import com.example.endore.EndOreMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // 注册方块的物品形式
        ItemBlock itemBlock = new ItemBlock(ModBlocks.END_ORE_BLOCK);
        itemBlock.setRegistryName(ModBlocks.END_ORE_BLOCK.getRegistryName());
        event.getRegistry().register(itemBlock);
    }
}
