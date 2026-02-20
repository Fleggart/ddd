package com.example.endore.registration;

import com.example.endore.EndOreMod;
import com.example.endore.blocks.EndOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID)
public class ModBlocks {
    
    public static Block END_ORE_BLOCK;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        // 创建方块实例
        END_ORE_BLOCK = new EndOreBlock(Material.ROCK)
                .setRegistryName(EndOreMod.MODID, "end_ore_block")
                .setTranslationKey(EndOreMod.MODID + ".end_ore_block")
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
                .setHardness(3.0F)
                .setResistance(15.0F);
        
        // 单独设置挖掘等级（不能链式调用，因为返回void）
        END_ORE_BLOCK.setHarvestLevel("pickaxe", 2);

        // 注册方块
        event.getRegistry().register(END_ORE_BLOCK);
    }
}
