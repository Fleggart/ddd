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
        // 设置可以被挖掘
        this.setHardness(1.5F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    // 可以被玩家挖掘
    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return true;
    }

    // 掉落自身（用于精准采集）
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    // 掉落数量
    @Override
    public int quantityDropped(Random random) {
        return 1; // 默认掉落1个自身
    }

    // 时运附魔不影响掉落数量（因为掉落的是自身）
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return this.quantityDropped(random);
    }

    // 经验值
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return 2;
    }

    // 破损矿石被爆炸破坏时，掉落自身
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if (!world.isRemote) {
            // 掉落自身
            spawnAsEntity(world, pos, new ItemStack(this));
        }
        // 移除方块
        super.onBlockExploded(world, pos, explosion);
    }

    // 确保精准采集也能获得自身
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }
}
