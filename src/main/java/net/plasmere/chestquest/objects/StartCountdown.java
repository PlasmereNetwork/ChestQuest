package net.plasmere.chestquest.objects;

import net.plasmere.chestquest.utils.MessageConfUtils;
import net.plasmere.chestquest.utils.MessageUtils;
import net.plasmere.chestquest.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartCountdown extends BukkitRunnable {

    public int countdown;
    public boolean running;

    public StartCountdown(int seconds) {
        this.countdown = seconds;
        this.running = true;
    }

    @Override
    public void run() {
        if (! running) return;

        if (countdown == 0) {
            done();
            return;
        }

        if (countdown == 20 || countdown < 11) {
            broadcast();
        }

        countdown--;
    }

    public void done(){
        PluginUtils.getPlugin().getGameHandler().startGame();
    }

    public void broadcast() {
        Bukkit.broadcastMessage(MessageUtils.parse(MessageConfUtils.countdown
                .replace("%seconds%", String.valueOf(countdown))
                .replace("%totalsec%", String.valueOf(20))
        ));
    }

    public void cancel(){
        this.running = false;
    }
}
