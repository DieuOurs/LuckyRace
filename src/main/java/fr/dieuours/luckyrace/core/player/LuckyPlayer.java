package fr.dieuours.luckyrace.core.player;

import java.util.UUID;

public class LuckyPlayer {

    private final UUID uuid;
    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
    private int totalDeaths, totalWins;

    /**
     * @param uuid        UUID
     * @param totalDeaths int
     * @param totalWins   int
     */
    public LuckyPlayer(UUID uuid, int totalDeaths, int totalWins) {
        if (!(totalDeaths > -1 && totalWins > -1)) {
            throw new IllegalArgumentException("arg@totalDeaths and arg@totalWins should be > -1");
        }
        this.uuid = uuid;
        this.totalDeaths = totalDeaths;
        this.totalWins = totalWins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public boolean isInGame() {
        return ((LuckyPlayerInGame) this).getGameUUID() != null;
    }
}