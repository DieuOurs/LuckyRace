package fr.dieuours.luckyrace.core.events;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.*;
import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayer;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LuckyPlayerJoinGameEvent extends Event {

    private final static LuckyRace pl = LuckyRace.getInstance();
    private static final HandlerList handlers = new HandlerList();
    private final LuckyPlayer luckyPlayer;
    private final LuckyGame luckyGame;

    /**
     * @param luckyPlayer LuckyPlayer
     * @param luckyGame   LuckyGame
     * @see Bukkit
     */
    public LuckyPlayerJoinGameEvent(LuckyPlayer luckyPlayer, LuckyGame luckyGame) throws GameException, PlayerException {
        this.luckyPlayer = luckyPlayer;
        this.luckyGame = luckyGame;
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(luckyGame.getUuid()))) {
            throw new GameNotFoundException();
        }
        if (luckyGame.getStatus() == LuckyGame.Status.LOBBY && luckyGame.getLuckyPlayerInGames().size() == luckyGame.getMaxPlayers()) {
            throw new GameFullException();
        }
        if (pl.getLuckyPlayers().stream().noneMatch(x -> x.getUuid().equals(luckyPlayer.getUuid()))) {
            throw new PlayerNotFoundException();
        }
        if (luckyPlayer.isInGame()) {
            throw new PlayerException("LuckyError | You are already in game...");
        }
        LuckyPlayerInGame luckyPlayerInGame = new LuckyPlayerInGame(luckyPlayer, luckyGame.getUuid(), 0);
        try {
            Bukkit.getServer().getPluginManager().callEvent(new LuckyGameAddPlayerEvent(luckyGame, luckyPlayerInGame));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //NOT DELETE
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public LuckyPlayer getLuckyPlayer() {
        return luckyPlayer;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public LuckyGame getLuckyGame() {
        return luckyGame;
    }
}
