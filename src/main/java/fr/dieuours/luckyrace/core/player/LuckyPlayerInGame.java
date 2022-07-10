package fr.dieuours.luckyrace.core.player;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.GameNotFoundException;

import java.util.UUID;

/**
 * @see fr.dieuours.luckyrace.core.player.LuckyPlayer
 */
public class LuckyPlayerInGame extends LuckyPlayer {

    private final static LuckyRace pl = LuckyRace.getInstance();
    private final UUID gameUUID;
    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
    private int totalDeathInGame;


    /**
     * @param luckyPlayer      LuckyPlayer
     * @param gameUUID         UUID
     * @param totalDeathInGame int
     * @throws GameNotFoundException if not x -> x.getUuid().equals(gameUUID))
     * @see LuckyPlayer
     * @see GameNotFoundException
     */
    public LuckyPlayerInGame(LuckyPlayer luckyPlayer, UUID gameUUID, int totalDeathInGame) throws GameNotFoundException {
        super(luckyPlayer.getUuid(), luckyPlayer.getTotalDeaths(), luckyPlayer.getTotalWins());
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(gameUUID))) {
            throw new GameNotFoundException();
        }
        this.gameUUID = gameUUID;
        this.totalDeathInGame = totalDeathInGame;
    }

    public UUID getGameUUID() {
        return gameUUID;
    }
}
