package com.example.endore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {

    public static Block BROKEN_ORE;

    public static void init() {

        BROKEN_ORE = new BlockBrokenOre();

        ForgeRegistries.BLOCKS.register(BROKEN_ORE);
    }
}
