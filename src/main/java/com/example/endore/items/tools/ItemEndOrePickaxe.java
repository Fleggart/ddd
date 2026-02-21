package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemEndOrePickaxe extends ItemPickaxe {
    
    public ItemEndOrePickaxe() {
        super(EndOreToolMaterial.END_ORE);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_pickaxe");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_pickaxe");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
