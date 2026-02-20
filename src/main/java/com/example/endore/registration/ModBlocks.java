package com.example.endore.registration;

import com.example.endore.EndOreMod;
import com.example.endore.blocks.EndOreBlock;
import com.example.endore.blocks.DamagedEndOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID)
public class ModBlocks {
    
    public static Block END_ORE_BLOCK;
    public static Block DAMAGED_END_ORE_BLOCK;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        // 注册普通末地矿石 - 不可挖掘
        END_ORE_BLOCK = new EndOreBlock(Material.ROCK)
                .setRegistryName(EndOreMod.MODID, "end_ore_block")
                .setTranslationKey(EndOreMod.MODID + ".end_ore_block")
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
                .setHardness(-1.0F) // 负数表示不可破坏
                .setResistance(3600000.0F); // 极高的抗爆性
        
        // 不需要设置挖掘等级，因为不可挖掘

        // 注册破损末地矿石 - 可挖掘，掉落自身
        DAMAGED_END_ORE_BLOCK = new DamagedEndOreBlock(Material.ROCK)
                .setRegistryName(EndOreMod.MODID, "damaged_end_ore_block")
                .setTranslationKey(EndOreMod.MODID + ".damaged_end_ore_block")
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
                .setHardness(1.5F)
                .setResistance(5.0F);
        
        DAMAGED_END_ORE_BLOCK.setHarvestLevel("pickaxe", 1);

        // 注册所有方块
        event.getRegistry().registerAll(
            END_ORE_BLOCK,
            DAMAGED_END_ORE_BLOCK
        );
    }
}
