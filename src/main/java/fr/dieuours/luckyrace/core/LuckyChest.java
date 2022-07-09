package fr.dieuours.luckyrace.core;

import fr.dieuours.luckyrace.LuckyRace;
import fr.dieuours.luckyrace.core.exceptions.GameNotFoundException;
import org.bukkit.Location;

import java.util.UUID;

public class LuckyChest {

    private final static LuckyRace pl = LuckyRace.getInstance();
    private final UUID gameUUID, uuid;
    private Location location;
    private Chance chance;

    /**
     * @param gameUUID UUID
     * @param uuid     UUID
     * @param location Location
     * @param chance   Chance is enum of this class
     */
    public LuckyChest(UUID gameUUID, UUID uuid, Location location, Chance chance) throws GameNotFoundException {
        if (pl.getLuckyGames().stream().noneMatch(x -> x.getUuid().equals(gameUUID))) {
            throw new GameNotFoundException();
        }
        this.gameUUID = gameUUID;
        this.uuid = uuid;
        this.location = location;
        this.chance = chance;
    }

    public UUID getGameUUID() {
        return gameUUID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Chance getChance() {
        return chance;
    }

    public void setChance(Chance chance) {
        this.chance = chance;
    }

    public enum Chance {
        I,
        II,
        III;
    }
}
