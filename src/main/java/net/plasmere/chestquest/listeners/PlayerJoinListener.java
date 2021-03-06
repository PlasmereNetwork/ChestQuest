package net.plasmere.chestquest.listeners;

import net.plasmere.chestquest.ChestQuest;
import net.plasmere.chestquest.handlers.GameHandler;
import net.plasmere.chestquest.utils.PluginUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener(ChestQuest plugin) {
        PluginUtils.registerListener(this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        GameHandler game = PluginUtils.getPlugin().getGameHandler();

        game.addPlayer(event.getPlayer());
    }

}
