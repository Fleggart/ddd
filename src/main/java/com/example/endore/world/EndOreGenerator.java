package com.example.endore.world;

import com.example.endore.registration.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
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
            generateEndOre(world, random, chunkX, chunkZ);
        }
    }

    private void generateEndOre(World world, Random random, int chunkX, int chunkZ) {
        WorldGenMinable endOreGenerator = new WorldGenMinable(
            ModBlocks.END_ORE_BLOCK.getDefaultState(),
            5,
            BlockMatcher.forBlock(Blocks.END_STONE)
        );
        
        int veinsPerChunk = 3 + random.nextInt(3);
        
        for (int i = 0; i < veinsPerChunk; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = 30 + random.nextInt(50);
            int z = chunkZ * 16 + random.nextInt(16);
            
            BlockPos pos = new BlockPos(x, y, z);
            endOreGenerator.generate(world, random, pos);
        }
    }
}
