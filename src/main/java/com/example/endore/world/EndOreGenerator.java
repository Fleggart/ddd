package com.example.endore.world;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.Block;
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
            generateEndOre(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateEndOre(World world, Random random, int blockX, int blockZ) {
        // 每个区块尝试生成3次
        for (int i = 0; i < 3; i++) {
            int x = blockX + random.nextInt(16);
            int y = 40 + random.nextInt(50);  // 生成高度 40-90
            int z = blockZ + random.nextInt(16);

            BlockPos pos = new BlockPos(x, y, z);

            // 生成矿脉，大小为5个方块
            WorldGenMinable generator = new WorldGenMinable(
                ModBlocks.END_ORE_BLOCK.getDefaultState(), 
                5
            );
            generator.generate(world, random, pos);
        }
    }
}
