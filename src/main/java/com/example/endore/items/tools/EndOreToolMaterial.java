package com.example.endore.items.tools;

import com.example.endore.EndOreMod;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class EndOreToolMaterial {
    
    public static final ToolMaterial END_ORE = EnumHelper.addToolMaterial(
        "END_ORE",           // 名称
        3,                   // 挖掘等级 (0=木, 1=石, 2=铁, 3=钻石, 4=更高)
        1800,                // 耐久度
        8.0F,                // 挖掘速度
        4.0F,                // 攻击伤害加成
        22                   // 附魔能力
    );
}
