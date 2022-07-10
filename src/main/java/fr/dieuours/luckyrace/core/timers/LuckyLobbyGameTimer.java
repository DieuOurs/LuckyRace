package fr.dieuours.luckyrace.core.timers;

import fr.dieuours.luckyrace.core.exceptions.GameException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @see BukkitRunnable
 */
public class LuckyLobbyGameTimer extends BukkitRunnable {

    private final LuckyGame luckyGame;
    private int timer;

    /**
     * @param luckyGame LuckyGame
     * @see LuckyGame
     */
    public LuckyLobbyGameTimer(LuckyGame luckyGame) {
        this.luckyGame = luckyGame;
        this.timer = 0;
    }

    @Override
    public void run() {
        //int finishTheTimerAt = 15;
        if (timer == 15) {
            try {
                luckyGame.setStatus(LuckyGame.Status.IN_GAME);
            } catch (GameException e) {
                e.printStackTrace();
            }
            cancel();
            return;
        }
        timer += 1;
    }

    public LuckyGame getLuckyGame() {
        return luckyGame;
    }
}
