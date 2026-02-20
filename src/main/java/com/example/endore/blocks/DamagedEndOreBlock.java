package com.example.endore.blocks;

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
        return Items.ENDER_PEARL;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0) i = 0;
            return this.quantityDropped(random) * (i + 1);
        }
        return this.quantityDropped(random);
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextBoolean() ? 1 : 0;
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return 2;
    }

    // 破损矿石被爆炸破坏时，100%掉落物品
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        // 先掉落物品
        this.dropBlockAsItem(world, pos, this.getDefaultState(), 0);
        // 然后正常移除方块
        super.onBlockExploded(world, pos, explosion);
    }
}
