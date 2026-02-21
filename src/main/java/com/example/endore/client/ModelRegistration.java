package com.example.endore.client;

import com.example.endore.EndOreMod;
import com.example.endore.registration.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID, value = Side.CLIENT)
public class ModelRegistration {
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        // 注册方块物品模型
        registerItemModel(ModItems.END_ORE_ITEM_BLOCK, 0);
        registerItemModel(ModItems.DAMAGED_END_ORE_ITEM_BLOCK, 0);
        
        // 注册盔甲模型
        registerItemModel(ModItems.END_ORE_HELMET, 0);
        registerItemModel(ModItems.END_ORE_CHESTPLATE, 0);
        registerItemModel(ModItems.END_ORE_LEGGINGS, 0);
        registerItemModel(ModItems.END_ORE_BOOTS, 0);
    }
    
    private static void registerItemModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
            new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
