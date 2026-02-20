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
        END_ORE_BLOCK = new EndOreBlock(Material.ROCK)
                .setRegistryName(EndOreMod.MODID, "end_ore_block")
                .setUnlocalizedName(EndOreMod.MODID + ".end_ore_block")
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
                .setHardness(3.0F)
                .setResistance(15.0F)
                .setHarvestLevel("pickaxe", 2);

        event.getRegistry().register(END_ORE_BLOCK);
    }
}
