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

    // 不可挖掘：玩家无法破坏
    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return false; // 玩家无法采集
    }

    // 不可挖掘：设置无限大的硬度，玩家无法破坏
    @Override
    public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World world, BlockPos pos) {
        return 0.0F; // 玩家无法减少方块硬度
    }

    // 爆炸处理：100%转化为破损矿石
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if (!world.isRemote) {
            // 100%转化为破损矿石
            world.setBlockState(pos, ModBlocks.DAMAGED_END_ORE_BLOCK.getDefaultState());
            // 播放破坏效果
            world.playEvent(2001, pos, Block.getStateId(this.getDefaultState()));
        }
    }

    // 设置极高的抗爆性
    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return 3600000.0F;
    }

    // 防止物品掉落（玩家无法挖掘，所以不应该掉落任何东西）
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null; // 不掉落物品
    }

    @Override
    public int quantityDropped(Random random) {
        return 0; // 不掉落
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return 0; // 没有经验
    }
}
