package com.example.endore.blocks;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;

import java.util.Random;

public class EndOreBlock extends Block {

    public EndOreBlock(Material material) {
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
        return 1;
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return 5;
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (!world.isRemote && willHarvest) {
            world.playEvent(2001, pos, Block.getStateId(state));
        }
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }

    // 修复：正确的爆炸处理方法 - 方块被爆炸破坏时调用
    @Override
    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
        if (!world.isRemote) {
            // 爆炸后有50%几率转化为破损矿石
            if (world.rand.nextBoolean()) {
                world.setBlockState(pos, ModBlocks.DAMAGED_END_ORE_BLOCK.getDefaultState());
            } else {
                // 另外50%几率掉落物品
                this.dropBlockAsItem(world, pos, this.getDefaultState(), 0);
            }
        }
    }

    // 修复：正确的爆炸处理方法 - 当爆炸发生时调用（1.12.2中的正确方法）
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        // 先处理转化逻辑
        if (!world.isRemote) {
            if (world.rand.nextBoolean()) {
                world.setBlockState(pos, ModBlocks.DAMAGED_END_ORE_BLOCK.getDefaultState());
                // 不调用父方法，因为我们保留了方块
                world.playEvent(2001, pos, Block.getStateId(this.getDefaultState()));
                return;
            }
        }
        // 否则正常爆炸破坏
        super.onBlockExploded(world, pos, explosion);
    }
}
