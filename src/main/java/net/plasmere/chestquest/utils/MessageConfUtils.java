package net.plasmere.chestquest.utils;

import org.bukkit.configuration.Configuration;

public class MessageConfUtils {
    private static Configuration mess = PluginUtils.getPlugin().getConf().getMess();

    public static void updateMess(Configuration m){
        mess = m;
    }

    public static String version = mess.getString("version");
    public static String countdown = mess.getString("countdown");
    public static String start = mess.getString("start");
    public static String join = mess.getString("join");
    public static String leave = mess.getString("leave");
}
