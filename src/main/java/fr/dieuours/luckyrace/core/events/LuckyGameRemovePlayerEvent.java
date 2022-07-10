package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.core.exceptions.GameException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyGameRemovePlayerEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public LuckyGameRemovePlayerEvent(LuckyGame luckyGame, LuckyPlayerInGame luckyPlayerInGame) throws GameException {
        luckyGame.getLuckyPlayerInGames().remove(luckyPlayerInGame);
        if (luckyGame.getStatus() == LuckyGame.Status.IN_GAME && luckyGame.getLuckyPlayerInGames().size() == 1) {
            luckyGame.setStatus(LuckyGame.Status.END);
        } else if (luckyGame.getStatus() == LuckyGame.Status.LOBBY && luckyGame.getLuckyPlayerInGames().size() < luckyGame.getMinPlayers()) {
            luckyGame.setStatus(LuckyGame.Status.WAITING);
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
