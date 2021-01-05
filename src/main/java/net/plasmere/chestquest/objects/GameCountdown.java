package net.plasmere.chestquest.objects;

import net.plasmere.chestquest.utils.MessageUtils;
import net.plasmere.chestquest.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameCountdown extends BukkitRunnable {

    private int countdown;

    public GameCountdown() {
        this.countdown = 20;
    }

    @Override
    public void run() {
        if (countdown == 0) {
            PluginUtils.getPlugin().getGameHandler().startGame();
            return;
        }

        if (countdown == 20 || countdown < 11) {
            broadcast();
        }

        countdown--;
    }

    private void broadcast() {
        Bukkit.broadcastMessage(MessageUtils.parse("&eThe game starts in &b{countdown} seconds!".replace("{countdown}", String.valueOf(countdown))));
    }

}
