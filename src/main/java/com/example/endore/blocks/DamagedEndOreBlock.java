package com.example.endore.blocks;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;

import java.util.Random;

public class DamagedEndOreBlock extends Block {

    public DamagedEndOreBlock(Material material) {
        super(material);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        // 返回方块本身的物品
        return Item.getItemFromBlock(ModBlocks.DAMAGED_END_ORE_BLOCK);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        // 不受时运影响，总是掉落1个
        return 1;
    }

    @Override
    public int quantityDropped(Random random) {
        // 总是掉落1个
        return 1;
    }

    // 修复：破损矿石被爆炸破坏时，100%掉落物品
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        // 先掉落物品
        this.dropBlockAsItem(world, pos, this.getDefaultState(), 0);
        // 然后调用父方法移除方块
        super.onBlockExploded(world, pos, explosion);
    }
}
