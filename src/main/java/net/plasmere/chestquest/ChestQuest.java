package net.plasmere.chestquest;

import net.plasmere.chestquest.handlers.GameHandler;
import net.plasmere.chestquest.utils.ConfigUtils;
import net.plasmere.chestquest.utils.SQLUtils;
import org.bukkit.plugin.java.JavaPlugin;
import net.plasmere.chestquest.handlers.ConfigHandler;

import java.sql.*;

public class ChestQuest extends JavaPlugin {

    private static ChestQuest instance;

    private ConfigHandler configHandler;
    private GameHandler gameHandler;

    private Statement statement;

    public ConfigHandler getConf() {
        return configHandler;
    }

    public void executeSQL(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet querySQL(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.configHandler = new ConfigHandler();
        this.gameHandler = new GameHandler();

        SQLUtils.initialize(ConfigUtils.sqlHost, ConfigUtils.sqlPort, ConfigUtils.sqlDatabase, ConfigUtils.sqlUsername, ConfigUtils.sqlPassword);
    }

    @Override
    public void onDisable() {

    }

    public static ChestQuest getInstance() {
        return instance;
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}
