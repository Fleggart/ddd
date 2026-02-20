package com.example.endore;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {

    public static Block BROKEN_ORE;

    public static void init() {
        BROKEN_ORE = new BlockBrokenOre();
        ForgeRegistries.BLOCKS.register(BROKEN_ORE);

        // 注册对应的 ItemBlock
        ItemBlock itemBlock = new ItemBlock(BROKEN_ORE);
        itemBlock.setRegistryName(BROKEN_ORE.getRegistryName()); // 使用相同的注册名
        ForgeRegistries.ITEMS.register(itemBlock);
    }
}
