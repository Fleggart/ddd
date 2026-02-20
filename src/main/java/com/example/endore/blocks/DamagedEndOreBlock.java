package com.example.endore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;

import java.util.Random;

public class DamagedEndOreBlock extends Block {

    public DamagedEndOreBlock(Material material) {
        super(material);
    }

    // 掉落自身
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    // 爆炸时掉落自身
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if (!world.isRemote) {
            // 掉落自身物品
            spawnAsEntity(world, pos, new ItemStack(this));
        }
        // 移除方块
        world.setBlockToAir(pos);
    }
}
