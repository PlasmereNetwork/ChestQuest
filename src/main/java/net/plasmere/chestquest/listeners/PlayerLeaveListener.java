package net.plasmere.chestquest.listeners;

import net.plasmere.chestquest.ChestQuest;
import net.plasmere.chestquest.handlers.GameHandler;
import net.plasmere.chestquest.utils.PluginUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    public PlayerLeaveListener(ChestQuest plugin) {
        PluginUtils.registerListener(this);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        GameHandler game = PluginUtils.getPlugin().getGameHandler();

        if (! game.isStarted()) {
            PluginUtils.getPlugin().getGameHandler().removePlayer(event.getPlayer());
        }
    }

}
