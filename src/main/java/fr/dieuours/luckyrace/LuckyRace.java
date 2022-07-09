package fr.dieuours.luckyrace;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @see JavaPlugin
 */
public class LuckyRace extends JavaPlugin {

    private static LuckyRace instance;

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
    }
}
