package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.core.exceptions.GameException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyGameAddPlayerEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public LuckyGameAddPlayerEvent(LuckyGame luckyGame, LuckyPlayerInGame luckyPlayerInGame) throws GameException {
        luckyGame.getLuckyPlayerInGames().add(luckyPlayerInGame);
        if (luckyGame.getMinPlayers() == luckyGame.getLuckyPlayerInGames().size()) {
            luckyGame.setStatus(LuckyGame.Status.LOBBY);
        }
    }

    //NOT DELETE
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
