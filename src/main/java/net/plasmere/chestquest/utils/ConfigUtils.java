package net.plasmere.chestquest.utils;

import org.bukkit.configuration.Configuration;

public class ConfigUtils {

    private static Configuration config = PluginUtils.getPlugin().getConf().getConf();

    public static void updateConfig(Configuration conf){
        config = conf;
    }

    public static String version = config.getString("version");
}
