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
        
        // 在 1.12.2 中，击退抗性需要通过属性修饰符在装备时动态添加
        // 或者通过其他方式实现，这里暂时移除 setKnockbackResistance
    }
}
