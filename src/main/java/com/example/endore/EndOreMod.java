package com.example.endore;

import com.example.endore.world.EndOreGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = EndOreMod.MODID, version = EndOreMod.VERSION, name = EndOreMod.NAME)
public class EndOreMod {
    public static final String MODID = "endore";
    public static final String NAME = "End Ore Mod";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        
        // 注册世界生成器
        GameRegistry.registerWorldGenerator(new EndOreGenerator(), 0);
        
        logger.info("末地矿石模组预初始化完成");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("末地矿石模组初始化完成");
    }
}
