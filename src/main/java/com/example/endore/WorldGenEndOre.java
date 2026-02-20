package com.example.endore;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenEndOre implements IWorldGenerator {

    private WorldGenMinable generator;

    public WorldGenEndOre() {
        generator = new WorldGenMinable(
                ModBlocks.BROKEN_ORE.getDefaultState(),
                ConfigHandler.veinSize,
                block -> block.getBlock() == Blocks.END_STONE
        );
    }

    @Override
    public void generate(
            Random rand,
            int chunkX,
            int chunkZ,
            World world,
            IChunkProvider chunkGenerator,
            IChunkProvider chunkProvider
    ) {

        if (!(world.provider instanceof WorldProviderEnd)) return;

        int baseX = chunkX * 16;
        int baseZ = chunkZ * 16;

        for (int i = 0; i < ConfigHandler.spawnTries; i++) {

            int x = baseX + rand.nextInt(16);
            int y = ConfigHandler.minY + rand.nextInt(ConfigHandler.maxY - ConfigHandler.minY + 1);
            int z = baseZ + rand.nextInt(16);

            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
