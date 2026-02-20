package com.example.endore;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static int oreHardness;
    public static int harvestLevel;

    public static int veinSize;
    public static int spawnTries;
    public static int minY;
    public static int maxY;

    public static void init(File file) {

        Configuration config = new Configuration(file);
        config.load();

        oreHardness = config.getInt(
                "OreHardness",
                "block",
                5,
                1,
                50,
                "矿石硬度"
        );

        harvestLevel = config.getInt(
                "HarvestLevel",
                "block",
                3,
                0,
                10,
                "挖掘等级"
        );

        veinSize = config.getInt(
                "VeinSize",
                "worldgen",
                6,
                1,
                50,
                "矿脉大小"
        );

        spawnTries = config.getInt(
                "SpawnAttempts",
                "worldgen",
                10,
                1,
                100,
                "每区块生成次数"
        );

        minY = config.getInt(
                "MinY",
                "worldgen",
                0,
                0,
                255,
                "最小高度"
        );

        maxY = config.getInt(
                "MaxY",
                "worldgen",
                128,
                0,
                255,
                "最大高度"
        );

        config.save();
    }
}
