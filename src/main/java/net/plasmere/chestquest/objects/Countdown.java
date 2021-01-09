package net.plasmere.chestquest.objects;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class Countdown extends BukkitRunnable {

    public int countdown;
    public boolean running;

    public Countdown(int seconds) {
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

    }

    public void broadcast() {

    }

    public void cancel(){
        this.running = false;
    }
}
