package fr.dieuours.luckyrace.core.game;

import fr.dieuours.luckyrace.core.FinalLine;
import org.bukkit.Location;

public class LuckyGame extends LuckyNewGame {


    private Location waitingLobby;
    private FinalLine finalLine;

    /**
     * @param waitingLobby Location
     * @param finalLine    FinalLine
     * @param luckyNewGame LuckyNewGame
     * @see FinalLine
     * @see LuckyNewGame
     */
    public LuckyGame(Location waitingLobby, FinalLine finalLine, LuckyNewGame luckyNewGame) {
        super(luckyNewGame.getUuid(), luckyNewGame.getMaxPlayers(), luckyNewGame.getMinPlayers(),
                luckyNewGame.getPlayersSpawn(), luckyNewGame.getLuckyChests(), luckyNewGame.getLuckyPlayerInGames());
        this.waitingLobby = waitingLobby;
        this.finalLine = finalLine;
    }

    public Location getWaitingLobby() {
        return waitingLobby;
    }

    public void setWaitingLobby(Location waitingLobby) {
        this.waitingLobby = waitingLobby;
    }

    public FinalLine getFinalLine() {
        return finalLine;
    }

    public void setFinalLine(FinalLine finalLine) {
        this.finalLine = finalLine;
    }
}
