package fr.dieuours.luckyrace.core.listeners;

import fr.dieuours.luckyrace.core.events.LuckyPlayerJoinGameEvent;
import fr.dieuours.luckyrace.core.events.LuckyPlayerLeaveGameEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @see Listener
 */
public class LuckyPlayerGameListener implements Listener {

    /**
     * @param e LuckyPlayerJoinGameEvent
     * @see LuckyPlayerJoinGameEvent
     */
    @EventHandler
    public void onLuckyPlayerJoinGameEvent(LuckyPlayerJoinGameEvent e) {
        Player p = Bukkit.getPlayer(e.getLuckyPlayer().getUuid());
        p.sendMessage("You join the game!");
        p.teleport(e.getLuckyGame().getWaitingLobby());
        e.getLuckyGame().sendMessageToEveryPlayerInGame(p.getName() + " has join the game!");
    }

    /**
     * @param e LuckyPlayerLeaveGameEvent
     * @see LuckyPlayerLeaveGameEvent
     */
    @EventHandler
    public void onLuckyPlayerLeaveGameEvent(LuckyPlayerLeaveGameEvent e) {
        Player p = Bukkit.getPlayer(e.getLuckyPlayerInGame().getUuid());
        p.sendMessage("You left the game!");
        p.teleport(e.getLuckyGame().getLobbyWhenGameEnd());
        e.getLuckyGame().sendMessageToEveryPlayerInGame(p.getName() + " has leave the game!");
    }
}
