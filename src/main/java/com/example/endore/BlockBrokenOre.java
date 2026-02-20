package com.example.endore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBrokenOre extends Block {

    public BlockBrokenOre() {
        super(Material.ROCK);

        this.setTranslationKey("broken_ore");
        this.setUnlocalizedName("broken_ore");

        this.setHardness(ConfigHandler.oreHardness);
        this.setHarvestLevel("pickaxe", ConfigHandler.harvestLevel);
    }
}
