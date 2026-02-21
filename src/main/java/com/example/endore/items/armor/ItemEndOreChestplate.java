
package com.example.endore.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreChestplate extends ItemArmor {
    
    public ItemEndOreChestplate() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.CHEST);
        
        this.setRegistryName("end_ore_chestplate");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_chestplate");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
