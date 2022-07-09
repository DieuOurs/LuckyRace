package fr.dieuours.luckyrace.core;

import fr.dieuours.luckyrace.core.exceptions.WorldException;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FinalLine {

    private final UUID gameUUID;
    private final Location pos1, pos2;
    private final List<Location> line;


    /**
     * @param gameUUID UUID
     * @param pos1     Location
     * @param pos2     Location
     * @throws WorldException Exception
     */
    public FinalLine(UUID gameUUID, Location pos1, Location pos2) throws WorldException {
        this.gameUUID = gameUUID;
        if (!pos1.getWorld().equals(pos2.getWorld())) {
            throw new WorldException();
        }
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.line = new ArrayList<>();
        double topBlockX = Math.max(pos1.getX(), pos2.getX());
        double bottomBlockX = Math.min(pos1.getX(), pos2.getX());
        double topBlockY = Math.max(pos1.getY(), pos2.getY());
        double bottomBlockY = Math.min(pos1.getY(), pos2.getY());
        double topBlockZ = Math.max(pos1.getZ(), pos2.getZ());
        double bottomBlockZ = Math.min(pos1.getZ(), pos2.getZ());
        for (double xn = bottomBlockX; xn <= topBlockX; xn++) {
            for (double zn = bottomBlockZ; zn <= topBlockZ; zn++) {
                for (double yn = bottomBlockY; yn <= topBlockY; yn++) {
                    this.line.add(new Location(pos1.getWorld(), xn, yn, zn));
                }
            }
        }
    }

    public UUID getGameUUID() {
        return gameUUID;
    }

    public Location getPos1() {
        return pos1;
    }

    public Location getPos2() {
        return pos2;
    }

    public List<Location> getLine() {
        return line;
    }
}
