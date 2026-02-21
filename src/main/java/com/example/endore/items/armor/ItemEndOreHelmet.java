
package com.example.endore.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreHelmet extends ItemArmor {
    
    public ItemEndOreHelmet() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.HEAD);
        
        this.setRegistryName("end_ore_helmet");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_helmet");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
