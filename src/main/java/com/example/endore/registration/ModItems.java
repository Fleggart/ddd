package com.example.endore.registration;

import com.example.endore.EndOreMod;
import com.example.endore.items.armor.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndOreMod.MODID)
public class ModItems {

    // 方块物品
    public static Item END_ORE_ITEM_BLOCK;
    public static Item DAMAGED_END_ORE_ITEM_BLOCK;

    // 盔甲物品
    public static Item END_ORE_HELMET;
    public static Item END_ORE_CHESTPLATE;
    public static Item END_ORE_LEGGINGS;
    public static Item END_ORE_BOOTS;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // 注册方块物品
        END_ORE_ITEM_BLOCK = new ItemBlock(ModBlocks.END_ORE_BLOCK)
                .setRegistryName(ModBlocks.END_ORE_BLOCK.getRegistryName());
        
        DAMAGED_END_ORE_ITEM_BLOCK = new ItemBlock(ModBlocks.DAMAGED_END_ORE_BLOCK)
                .setRegistryName(ModBlocks.DAMAGED_END_ORE_BLOCK.getRegistryName());

        // 创建盔甲物品
        END_ORE_HELMET = new ItemEndOreHelmet();
        END_ORE_CHESTPLATE = new ItemEndOreChestplate();
        END_ORE_LEGGINGS = new ItemEndOreLeggings();
        END_ORE_BOOTS = new ItemEndOreBoots();

        // 注册所有物品
        event.getRegistry().registerAll(
            END_ORE_ITEM_BLOCK,
            DAMAGED_END_ORE_ITEM_BLOCK,
            END_ORE_HELMET,
            END_ORE_CHESTPLATE,
            END_ORE_LEGGINGS,
            END_ORE_BOOTS
        );
    }
}
