package fr.dieuours.luckyrace.core.listeners;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.events.LuckyGameStatusChangeEvent;
import fr.dieuours.luckyrace.core.timers.LuckyLobbyGameTimer;
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
                new LuckyLobbyGameTimer(e.getLuckyGame()).runTaskTimer(pl, 20L, 20L);
                break;
            case WAITING:
                break;
        }
    }
}
