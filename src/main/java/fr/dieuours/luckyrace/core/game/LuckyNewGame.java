package fr.dieuours.luckyrace.core.game;

import fr.dieuours.luckyrace.core.LuckyChest;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import fr.dieuours.luckyrace.utils.ClassSerializer;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @since T0.0.3
 */
public class LuckyNewGame extends ClassSerializer {

    private final UUID uuid;
    private int maxPlayers, minPlayers;
    private List<Location> playersSpawn;
    private List<LuckyChest> luckyChests;
    private List<LuckyPlayerInGame> luckyPlayerInGames;

    /**
     * @param uuid               UUID
     * @param maxPlayers         int
     * @param minPlayers         int
     * @param playersSpawn       List<Location>
     * @param luckyChests        List<fr.dieuours.luckyrace.core.LuckyChest>
     * @param luckyPlayerInGames List<fr.dieuours.luckyrace.core.player.LuckyPlayerInGame> LuckyPlayerInGame extends of fr.dieuours.luckyrace.core.player.LuckyPlayer
     */
    public LuckyNewGame(UUID uuid, int maxPlayers, int minPlayers, List<Location> playersSpawn, List<LuckyChest> luckyChests, List<LuckyPlayerInGame> luckyPlayerInGames) {
        this.uuid = uuid;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.playersSpawn = playersSpawn;
        this.luckyChests = luckyChests;
        this.luckyPlayerInGames = luckyPlayerInGames;
    }

    /**
     * Default constructor
     */
    public LuckyNewGame() {
        this.uuid = UUID.randomUUID();
        this.maxPlayers = 2;
        this.minPlayers = 2;
        this.playersSpawn = new ArrayList<>();
        this.luckyChests = new ArrayList<>();
        this.luckyPlayerInGames = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public List<Location> getPlayersSpawn() {
        return playersSpawn;
    }

    public void setPlayersSpawn(List<Location> playersSpawn) {
        this.playersSpawn = playersSpawn;
    }

    public List<LuckyChest> getLuckyChests() {
        return luckyChests;
    }

    public void setLuckyChests(List<LuckyChest> luckyChests) {
        this.luckyChests = luckyChests;
    }

    public List<LuckyPlayerInGame> getLuckyPlayerInGames() {
        return luckyPlayerInGames;
    }

    public void setLuckyPlayerInGames(List<LuckyPlayerInGame> luckyPlayerInGames) {
        this.luckyPlayerInGames = luckyPlayerInGames;
    }

    /**
     * @return getGson().toJson(this);
     * @see ClassSerializer
     */
    @Override
    public String toString() {
        return getGson().toJson(this);
    }
}
