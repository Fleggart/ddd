package com.example.endore.world;

import com.example.endore.registration.ModBlocks;
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
        if (world.provider.getDimension() == 1) {
            // 每个区块强制生成10次，确保能看到
            for (int i = 0; i < 10; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = 40 + random.nextInt(40);
                int z = chunkZ * 16 + random.nextInt(16);
                
                BlockPos pos = new BlockPos(x, y, z);
                
                // 直接在世界中放置方块（调试用）
                if (world.getBlockState(pos).getBlock() == Blocks.END_STONE) {
                    world.setBlockState(pos, ModBlocks.END_ORE_BLOCK.getDefaultState());
                }
            }
        }
    }
}
