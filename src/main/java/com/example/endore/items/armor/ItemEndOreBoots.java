
package com.example.endore.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreBoots extends ItemArmor {
    
    public ItemEndOreBoots() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.FEET);
        
        this.setRegistryName("end_ore_boots");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_boots");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
