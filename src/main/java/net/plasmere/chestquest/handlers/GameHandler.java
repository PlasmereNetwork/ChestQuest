package net.plasmere.chestquest.handlers;

import net.plasmere.chestquest.enums.GameState;
import net.plasmere.chestquest.objects.ChestPlayer;
import net.plasmere.chestquest.enums.PlayerState;
import net.plasmere.chestquest.objects.GameCountdown;
import net.plasmere.chestquest.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class GameHandler {

    private Map<ChestPlayer, PlayerState> players;
    private GameState state;

    private BukkitTask countdownTask;

    public GameHandler() {
        players = new HashMap<>();
    }

    public void beginCountdown() {
        setState(GameState.STARTING);  // Begin game start
        countdownTask = Bukkit.getScheduler().runTaskTimer(PluginUtils.getPlugin(), new GameCountdown(), 0, 20);
    }

    public void startGame() {
        countdownTask.cancel();
        for (ChestPlayer player : players.keySet()) setPlayerState(player, PlayerState.ALIVE);
        setState(GameState.RUNNING);
    }

    public int playersAlive(){
        int alive = 0;
        for (Player player : players.keySet()){
            if (players.get(player).equals(PlayerState.ALIVE)) alive++;
        }

        return alive;
    }

    public int playersWaiting(){
        int waiting = 0;
        for (Player player : players.keySet()){
            if (players.get(player).equals(PlayerState.WAITING)) waiting++;
        }

        return waiting;
    }

    public void addPlayer(Player player) {
        players.put(new ChestPlayer(player), PlayerState.WAITING);
    }

    public void addSpectator(Player player) {
        players.put(new ChestPlayer(player), PlayerState.SPECTATING);
    }

    public PlayerState getPlayerState(Player player) {
        return players.get(player);
    }

    public void setPlayerState(Player player, PlayerState state) {
        players.put(getPlayer(player), state);
    }

    public boolean isWaiting(Player player){
        return players.get(player).equals(PlayerState.WAITING);
    }

    public boolean isAlive(Player player){
        return players.get(player).equals(PlayerState.ALIVE);
    }

    public boolean isSpectating(Player player){
        return players.get(player).equals(PlayerState.SPECTATING);
    }

    public void removePlayer(Player player) {
        if (players.keySet().stream().noneMatch(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId()))) return;
        players.remove(players.keySet().stream().filter(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId())).findAny().get());
    }

    public ChestPlayer getPlayer(Player player) {
        if (players.keySet().stream().noneMatch(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId()))) return null;
        return players.keySet().stream().filter(chestPlayer -> chestPlayer.getUniqueId().equals(player.getUniqueId())).findAny().get();
    }

    private void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public boolean isStarted(){
        return state.equals(GameState.RUNNING);
    }

}
