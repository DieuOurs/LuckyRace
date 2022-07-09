package fr.dieuours.luckyrace.core.player;

import java.util.UUID;

public class LuckyPlayerInGame extends LuckyPlayer {

    private final UUID gameUUID;
    private int totalDeathInGame;

    /**
     * @param uuid             UUID
     * @param totalDeaths      int
     * @param totalWins        int
     * @param gameUUID         UUID
     * @param totalDeathInGame int
     */
    public LuckyPlayerInGame(UUID uuid, int totalDeaths, int totalWins, UUID gameUUID, int totalDeathInGame) {
        super(uuid, totalDeaths, totalWins);
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
