package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.GameException;
import fr.dieuours.luckyrace.core.exceptions.GameNotFoundException;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyPlayerLeaveGameEvent extends Event {

    private static final LuckyRace pl = LuckyRace.getInstance();
    private static final HandlerList handlers = new HandlerList();
    private final LuckyPlayerInGame luckyPlayerInGame;
    private final LuckyGame luckyGame;

    public LuckyPlayerLeaveGameEvent(LuckyPlayerInGame luckyPlayerInGame) throws GameException {
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(luckyPlayerInGame.getGameUUID())))
            throw new GameNotFoundException();
        this.luckyGame = pl.getLuckyGames().stream().filter(x -> x.getUuid().equals(luckyPlayerInGame.getGameUUID())).findFirst().get();
        this.luckyPlayerInGame = luckyPlayerInGame;
        Bukkit.getServer().getPluginManager().callEvent(new LuckyGameRemovePlayerEvent(this.luckyGame, luckyPlayerInGame));
    }

    //NOT DELETE
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public LuckyGame getLuckyGame() {
        return luckyGame;
    }

    public LuckyPlayerInGame getLuckyPlayerInGame() {
        return luckyPlayerInGame;
    }
}
