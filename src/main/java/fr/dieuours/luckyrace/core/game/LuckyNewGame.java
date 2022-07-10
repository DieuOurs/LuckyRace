package fr.dieuours.luckyrace.core.game;

import fr.dieuours.luckyrace.core.LuckyChest;
import fr.dieuours.luckyrace.core.player.LuckyPlayerInGame;
import fr.dieuours.luckyrace.utils.ClassSerializer;
import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

/**
 * @see ClassSerializer
 */
public class LuckyNewGame extends ClassSerializer {

    private final UUID uuid;
    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
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
     * <p>
     * public LuckyNewGame() {
     * this.uuid = UUID.randomUUID();
     * this.maxPlayers = 2;
     * this.minPlayers = 2;
     * this.playersSpawn = new ArrayList<>();
     * this.luckyChests = new ArrayList<>();
     * this.luckyPlayerInGames = new ArrayList<>();
     * }
     */

    public UUID getUuid() {
        return uuid;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public List<Location> getPlayersSpawn() {
        return playersSpawn;
    }

    public List<LuckyChest> getLuckyChests() {
        return luckyChests;
    }

    public List<LuckyPlayerInGame> getLuckyPlayerInGames() {
        return luckyPlayerInGames;
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
