package net.plasmere.chestquest.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtils {

    public static String parse(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(parse(message));
    }

    public static void sendMessage(String message, Player player) {
        player.sendMessage(parse(message));
    }

    public static void sendBroadcast(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) player.sendMessage(parse(message));
    }

    public static void sendBroadcast(String message, String permission) {
        for (Player player : Bukkit.getOnlinePlayers()) if (player.hasPermission(permission)) player.sendMessage(parse(message));
    }

}
