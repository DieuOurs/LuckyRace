package fr.dieuours.luckyrace.core.player;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.GameNotFoundException;

import java.util.UUID;

public class LuckyPlayerInGame extends LuckyPlayer {

    private final static LuckyRace pl = LuckyRace.getInstance();
    private final UUID gameUUID;
    private int totalDeathInGame;

    /**
     * @param uuid             UUID
     * @param totalDeaths      int
     * @param totalWins        int
     * @param gameUUID         UUID
     * @param totalDeathInGame int
     */
    public LuckyPlayerInGame(UUID uuid, int totalDeaths, int totalWins, UUID gameUUID, int totalDeathInGame) throws GameNotFoundException {
        super(uuid, totalDeaths, totalWins);
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(gameUUID))) {
            throw new GameNotFoundException();
        }
        this.gameUUID = gameUUID;
        this.totalDeathInGame = totalDeathInGame;
    }

    public UUID getGameUUID() {
        return gameUUID;
    }

    public int getTotalDeathInGame() {
        return totalDeathInGame;
    }

    public void setTotalDeathInGame(int totalDeathInGame) {
        this.totalDeathInGame = totalDeathInGame;
    }
}
