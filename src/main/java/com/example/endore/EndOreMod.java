package com.example.endore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = EndOreMod.MODID, name = EndOreMod.NAME, version = EndOreMod.VERSION)
public class EndOreMod {

    public static final String MODID = "endore";
    public static final String NAME = "End Broken Ore Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigHandler.init(event.getSuggestedConfigurationFile());

        ModBlocks.init();

        GameRegistry.registerWorldGenerator(new WorldGenEndOre(), 0);
    }
}
