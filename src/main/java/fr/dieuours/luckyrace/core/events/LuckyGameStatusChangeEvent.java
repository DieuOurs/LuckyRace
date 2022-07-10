package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.core.exceptions.GameException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyGameStatusChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
    private final LuckyGame.Status previousStatus, status;
    private final LuckyGame luckyGame;

    public LuckyGameStatusChangeEvent(LuckyGame luckyGame, LuckyGame.Status status) throws GameException {
        if (luckyGame.getStatus() == status) throw new GameException("Previous status is the same has new status");
        this.previousStatus = luckyGame.getStatus();
        this.status = status;
        this.luckyGame = luckyGame;
    }

    //NOT DELETE
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public LuckyGame getLuckyGame() {
        return luckyGame;
    }

    public LuckyGame.Status getStatus() {
        return status;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
