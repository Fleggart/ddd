
package com.example.endore.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreLeggings extends ItemArmor {
    
    public ItemEndOreLeggings() {
        super(EndOreArmorMaterial.END_ORE, 2, EntityEquipmentSlot.LEGS);
        
        this.setRegistryName("end_ore_leggings");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_leggings");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
