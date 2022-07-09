package fr.dieuours.luckyrace;

import fr.dieuours.luckyrace.core.game.LuckyNewGame;
import fr.dieuours.luckyrace.utils.ClassSerializer;
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
        //FIXME
        LuckyNewGame luckyNewGame = new LuckyNewGame();
        String json = luckyNewGame.toString();
        System.out.println(json);
        LuckyNewGame luckyNewGame1 = ClassSerializer.deserialize(LuckyNewGame.class, json);
        System.out.println(luckyNewGame1.getUuid());
    }
}
