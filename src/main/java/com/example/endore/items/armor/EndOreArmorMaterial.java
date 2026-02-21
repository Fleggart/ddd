package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class EndOreArmorMaterial {
    
    public static final ArmorMaterial END_ORE = EnumHelper.addArmorMaterial(
        "END_ORE",                          // 名称
        EndOreMod.MODID + ":end_ore",       // 纹理名称
        40,                                 // 耐久度倍数
        new int[]{4, 9, 7, 4},              // 护甲值 [靴子, 护腿, 胸甲, 头盔]
        25,                                 // 附魔能力
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,   // 装备音效
        4.5F                                 // 盔甲韧性
    );

}
