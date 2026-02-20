package com.example.endore.blocks;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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

    // 【关键方法1】爆炸抗性 - 返回正值让爆炸能处理这个方块
    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        // 返回一个普通值，让爆炸系统认为这个方块可以被破坏
        return 30.0F;
    }

    // 【关键方法2】爆炸时100%转化为破损矿石
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if (!world.isRemote) {
            // 添加调试输出（在控制台查看）
            System.out.println("[EndOre] 爆炸触发！位置: " + pos.toString());
            
            // 设置为破损矿石
            world.setBlockState(pos, ModBlocks.DAMAGED_END_ORE_BLOCK.getDefaultState());
            
            // 播放爆炸粒子效果
            world.playEvent(2001, pos, Block.getStateId(this.getDefaultState()));
        }
        // 【重要】不调用 super.onBlockExploded，防止方块被移除
    }

    // 【关键方法3】确保方块被爆炸标记为可破坏
    @Override
    public boolean canDropFromExplosion(Explosion explosion) {
        // 返回true让爆炸系统认为这个方块可以被处理
        return true;
    }
}
