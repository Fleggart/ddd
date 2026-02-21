package com.example.endore.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent event) {
    }
    
    public void init(FMLInitializationEvent event) {
    }
    
    public void postInit(FMLPostInitializationEvent event) {
    }
    
    public void registerItemRenderer(Item item, int meta, String id) {
        // 服务端不执行任何操作
    }
}
