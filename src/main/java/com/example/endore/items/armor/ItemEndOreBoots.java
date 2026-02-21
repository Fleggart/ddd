package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreBoots extends ItemArmor {
    
    public ItemEndOreBoots() {
        super(EndOreArmorMaterial.END_ORE, 1, EntityEquipmentSlot.FEET);
        
        this.setRegistryName(EndOreMod.MODID, "end_ore_boots");
        this.setTranslationKey(EndOreMod.MODID + ".end_ore_boots");
        this.setCreativeTab(CreativeTabs.COMBAT);
        
        // 设置击退抗性
        this.setKnockbackResistance(0.4F);
    }
}
