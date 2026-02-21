
package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemEndOreShovel extends ItemSpade {
    
    public ItemEndOreShovel() {
        super(EndOreToolMaterial.END_ORE);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_shovel");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_shovel");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
