package net.plasmere.chestquest;

import org.bukkit.plugin.java.JavaPlugin;
import net.plasmere.chestquest.handlers.ConfigHandler;

import java.sql.*;

public class ChestQuest extends JavaPlugin {

    private ConfigHandler configHandler;
    private Statement statement;

    public ConfigHandler getConf() {
        return configHandler;
    }

    public void setup(){
        this.configHandler = new ConfigHandler();

        try {
            sqlInit("localhost", 3306, "", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sqlInit(String host, int port, String database, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        statement = connection.createStatement();
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
        setup();
    }

    @Override
    public void onDisable() {

    }

}
