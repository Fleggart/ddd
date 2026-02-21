package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemEndOreSword extends ItemSword {
    
    public ItemEndOreSword() {
        super(EndOreToolMaterial.END_ORE);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_sword");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_sword");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
