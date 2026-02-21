package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreHelmet extends ItemArmor {
    
    public ItemEndOreHelmet() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.HEAD);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_helmet");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_helmet");
        this.setCreativeTab(CreativeTabs.COMBAT);
        
        // 设置击退抗性
        this.setKnockbackResistance(0.4F);
    }
}
