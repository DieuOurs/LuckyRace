package fr.dieuours.luckyrace.core.player;

import fr.dieuours.luckyrace.utils.ClassSerializer;

import java.util.UUID;

public class LuckyPlayer extends ClassSerializer {

    private final UUID uuid;
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

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return getGson().toJson(this);
    }
}