package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEndOreArmor extends ItemArmor {
    
    public ItemEndOreArmor(EntityEquipmentSlot slot) {
        super(EndOreArmorMaterial.END_ORE, getRenderIndex(slot), slot);
        
        String name = getArmorName(slot);
        this.setRegistryName(EndOreMod.MODID, name);
        this.setTranslationKey(EndOreMod.MODID + "." + name);
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
    
    private static int getRenderIndex(EntityEquipmentSlot slot) {
        switch(slot) {
            case HEAD: return 1;
            case CHEST: return 1;
            case LEGS: return 2;
            case FEET: return 1;
            default: return 1;
        }
    }
    
    private static String getArmorName(EntityEquipmentSlot slot) {
        switch(slot) {
            case HEAD: return "end_ore_helmet";
            case CHEST: return "end_ore_chestplate";
            case LEGS: return "end_ore_leggings";
            case FEET: return "end_ore_boots";
            default: return "end_ore_armor";
        }
    }
}