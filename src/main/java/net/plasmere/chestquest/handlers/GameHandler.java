package net.plasmere.chestquest.handlers;

import net.plasmere.chestquest.enums.GameState;
import net.plasmere.chestquest.chest.ChestPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {

    private List<ChestPlayer> players;
    private GameState state;

    public GameHandler() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(new ChestPlayer(player));
    }

    public void removePlayer(Player player) {
        if (players.stream().noneMatch(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId()))) return;
        players.remove(players.stream().filter(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId())).findAny().get());
    }

    public ChestPlayer getPlayer(Player player) {
        if (players.stream().noneMatch(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId()))) return null;
        return players.stream().filter(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId())).findAny().get();
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

}
