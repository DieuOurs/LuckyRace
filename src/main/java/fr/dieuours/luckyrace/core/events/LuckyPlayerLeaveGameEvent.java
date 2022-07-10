package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.GameNotFoundException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyPlayerLeaveGameEvent extends Event {

    private static final LuckyRace pl = LuckyRace.getInstance();
    private static final HandlerList handlers = new HandlerList();
    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
    private final LuckyGame luckyGame;

    public LuckyPlayerLeaveGameEvent(LuckyPlayerInGame luckyPlayerInGame) throws GameNotFoundException {
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(luckyPlayerInGame.getGameUUID())))
            throw new GameNotFoundException();
        this.luckyGame = pl.getLuckyGames().stream().filter(x -> x.getUuid().equals(luckyPlayerInGame.getGameUUID())).findFirst().get();
    }

    //NOT DELETE
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
