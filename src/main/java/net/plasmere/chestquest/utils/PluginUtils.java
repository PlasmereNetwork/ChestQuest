package net.plasmere.chestquest.utils;

import net.plasmere.chestquest.ChestQuest;
import org.bukkit.event.Listener;

public class PluginUtils {

    public static ChestQuest getPlugin() {
        return ChestQuest.getPlugin(ChestQuest.class);
    }

    public static void registerListener(Listener listener) {
        getPlugin().getServer().getPluginManager().registerEvents(listener, getPlugin());
    }

}
