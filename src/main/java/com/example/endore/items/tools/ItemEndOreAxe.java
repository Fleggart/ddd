package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemEndOreAxe extends ItemAxe {
    
    public ItemEndOreAxe() {
        super(EndOreToolMaterial.END_ORE, 9.0F, -3.0F);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_axe");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_axe");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
