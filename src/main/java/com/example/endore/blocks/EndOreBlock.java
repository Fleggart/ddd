package com.example.endore.blocks;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;

public class EndOreBlock extends Block {

    public EndOreBlock(Material material) {
        super(material);
    }

    // 玩家无法挖掘
    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return false;
    }

    // 爆炸时100%转化为破损矿石
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if (!world.isRemote) {
            // 设置为破损矿石
            world.setBlockState(pos, ModBlocks.DAMAGED_END_ORE_BLOCK.getDefaultState());
            // 播放爆炸效果
            world.playEvent(2001, pos, Block.getStateId(this.getDefaultState()));
        }
    }

    // 设置极高的抗爆性
    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return 3600000.0F;
    }
}
