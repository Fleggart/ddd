package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemEndOreHoe extends ItemHoe {
    
    public ItemEndOreHoe() {
        super(EndOreToolMaterial.END_ORE);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_hoe");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_hoe");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
