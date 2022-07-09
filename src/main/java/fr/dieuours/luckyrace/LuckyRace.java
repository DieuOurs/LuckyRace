package fr.dieuours.luckyrace;

import fr.dieuours.luckyrace.core.game.LuckyGame;
import fr.dieuours.luckyrace.core.player.LuckyPlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @see JavaPlugin
 */
public class LuckyRace extends JavaPlugin {

    private static LuckyRace instance;
    private List<LuckyGame> luckyGames;
    private List<LuckyPlayer> luckyPlayers;

    public static LuckyRace getInstance() {
        return instance;
    }

    /**
     * When plugin start, this method is called
     *
     * @see JavaPlugin
     */
    @Override
    public void onLoad() {
        super.onLoad();
    }

    /**
     * When plugin stop, this method is called
     *
     * @see JavaPlugin
     */
    @Override
    public void onDisable() {
        super.onDisable();
    }

    /**
     * When plugin is load, this method is called
     *
     * @see JavaPlugin
     */
    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        this.luckyGames = new ArrayList<>();
        this.luckyPlayers = new ArrayList<>();
    }

    public List<LuckyGame> getLuckyGames() {
        return this.luckyGames;
    }

    public List<LuckyPlayer> getLuckyPlayers() {
        return luckyPlayers;
    }
}
