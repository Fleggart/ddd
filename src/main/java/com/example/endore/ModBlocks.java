package com.example.endore;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {

    public static Block BROKEN_ORE;

    public static void init() {

        BROKEN_ORE = new BlockBrokenOre()
                .setRegistryName("broken_ore")
                .setUnlocalizedName("broken_ore")
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ForgeRegistries.BLOCKS.register(BROKEN_ORE);
    }
}
