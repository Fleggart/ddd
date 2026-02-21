package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreChestplate extends ItemArmor {
    
    public ItemEndOreChestplate() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.CHEST);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_chestplate");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_chestplate");
        this.setCreativeTab(CreativeTabs.COMBAT);
        
        // 设置击退抗性
        this.setKnockbackResistance(0.4F);
    }
}
