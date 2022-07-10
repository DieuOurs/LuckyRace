package fr.dieuours.luckyrace.core.listeners;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.events.LuckyGameStatusChangeEvent;
import fr.dieuours.luckyrace.core.timers.LuckyLobbyGameTimer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @see Listener
 */
public class LuckyGameStatusListener implements Listener {

    private final static LuckyRace pl = LuckyRace.getInstance();

    /**
     * @param e LuckyGameStatusChangeEvent
     * @see LuckyGameStatusChangeEvent
     */
    @EventHandler
    public void onLuckyGameStatusChangeEvent(LuckyGameStatusChangeEvent e) {
        switch (e.getStatus()) {
            case LOBBY:
                e.getLuckyGame().sendMessageToEveryPlayerInGame("The lobby timer start...");
                new LuckyLobbyGameTimer(e.getLuckyGame()).runTaskTimer(pl, 20L, 20L);
                break;
            case WAITING:
                e.getLuckyGame().sendMessageToEveryPlayerInGame("The game will be start when the size of minimum of players reach " + e.getLuckyGame().getMinPlayers());
                break;
            case END:
                e.getLuckyGame().sendMessageToEveryPlayerInGame("The game will be ended");
                e.getLuckyGame().getLuckyPlayerInGames().forEach(x -> Bukkit.getPlayer(x.getUuid()).setGameMode(GameMode.SPECTATOR));
                break;
            case IN_GAME:
                break;
        }
    }
}
