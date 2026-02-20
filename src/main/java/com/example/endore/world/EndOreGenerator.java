package com.example.endore.world;

import com.example.endore.EndOreMod;
import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class EndOreGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, 
                         IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        // 只在末地生成（维度ID = 1）
        if (world.provider.getDimension() == 1) {
            generateEndOre(world, random, chunkX, chunkZ);
        }
    }

    private void generateEndOre(World world, Random random, int chunkX, int chunkZ) {
        // 正确的WorldGenMinable构造函数
        WorldGenMinable endOreGenerator = new WorldGenMinable(
            ModBlocks.END_ORE_BLOCK.getDefaultState(),
            5,  // 矿脉大小
            Blocks.END_STONE.getDefaultState()  // 替换末地石
        );
        
        int successCount = 0;
        int attempts = 5; // 每个区块尝试5次
        
        for (int i = 0; i < attempts; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = 30 + random.nextInt(50);
            int z = chunkZ * 16 + random.nextInt(16);
            
            BlockPos pos = new BlockPos(x, y, z);
            
            // 检查该位置是否是末地石（可选，WorldGenMinable内部会检查）
            if (world.getBlockState(pos).getBlock() == Blocks.END_STONE) {
                boolean generated = endOreGenerator.generate(world, random, pos);
                if (generated) {
                    successCount++;
                    // 打印生成成功的信息（会显示在控制台）
                    EndOreMod.logger.info("末地矿石在 " + pos.toString() + " 生成成功");
                }
            }
        }
        
        if (successCount > 0) {
            EndOreMod.logger.info("区块 [" + chunkX + "," + chunkZ + "] 生成了 " + successCount + " 处末地矿石");
        }
    }
}
