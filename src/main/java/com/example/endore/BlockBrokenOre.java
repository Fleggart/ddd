package com.example.endore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBrokenOre extends Block {

    public BlockBrokenOre() {
        super(Material.ROCK);

        setRegistryName("broken_ore");
        setUnlocalizedName("broken_ore");

        setHardness(ConfigHandler.oreHardness);
        setHarvestLevel("pickaxe", ConfigHandler.harvestLevel);
    }
}
