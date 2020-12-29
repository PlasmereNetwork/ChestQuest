package net.plasmere.chestquest;

import net.plasmere.chestquest.objects.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestQuest extends JavaPlugin {

    private Config config;

    public Config getConf() {
        return config;
        // test
    }

    public void setup(){
        this.config = new Config();
    }

    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {

    }

}
