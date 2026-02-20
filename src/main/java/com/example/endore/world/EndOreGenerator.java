package com.example.endore.world;

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
        // 正确的WorldGenMinable构造函数：需要指定替换的目标方块（末地石）
        WorldGenMinable endOreGenerator = new WorldGenMinable(
            ModBlocks.END_ORE_BLOCK.getDefaultState(),  // 要生成的方块
            5,                                          // 矿脉大小
            Blocks.END_STONE.getDefaultState()          // 要替换的方块（末地石）
        );
        
        // 每个区块生成3-5次
        int veinsPerChunk = 3 + random.nextInt(3);
        
        for (int i = 0; i < veinsPerChunk; i++) {
            // 计算生成坐标（注意：要使用实际的区块坐标）
            int x = chunkX * 16 + random.nextInt(16);
            int y = 30 + random.nextInt(50);  // 生成高度 30-80
            int z = chunkZ * 16 + random.nextInt(16);
            
            BlockPos pos = new BlockPos(x, y, z);
            
            // 在指定位置生成矿脉
            endOreGenerator.generate(world, random, pos);
        }
    }
}
