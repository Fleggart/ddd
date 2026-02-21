package com.example.endore.items.armor;

import com.example.endore.EndOreMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEndOreArmor extends ItemArmor {
    
    @SideOnly(Side.CLIENT)
    private ModelEndOreArmor model;
    
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
    
    /**
     * 返回3D盔甲模型 - 关键方法[citation:3]
     */
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, 
                                     ItemStack itemStack, 
                                     EntityEquipmentSlot armorSlot, 
                                     ModelBiped defaultModel) {
        if (model == null) {
            model = new ModelEndOreArmor();
        }
        
        // 根据装备部位控制模型显示[citation:3]
        if (model.bone != null) {
            // 只显示当前装备部位的部件
            // 这里简单起见让所有部件都显示
            // 实际可以根据 armorSlot 控制特定部件的显示
        }
        
        // 复制玩家姿态[citation:1]
        model.isSneak = defaultModel.isSneak;
        model.isRiding = defaultModel.isRiding;
        model.isChild = defaultModel.isChild;
        model.rightArmPose = defaultModel.rightArmPose;
        model.leftArmPose = defaultModel.leftArmPose;
        
        return model;
    }
}
