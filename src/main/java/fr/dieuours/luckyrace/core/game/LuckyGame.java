package fr.dieuours.luckyrace.core.game;

import fr.dieuours.luckyrace.core.FinalLine;
import org.bukkit.Location;

public class LuckyGame extends LuckyNewGame {

    private Location waitingLobby, lobbyWhenGameEnd;
    private FinalLine finalLine;
    private Status status;

    /**
     * @param waitingLobby     Location
     * @param luckyNewGame     LuckyNewGame
     * @param lobbyWhenGameEnd Location
     * @param finalLine        FinalLine
     * @param status           Status
     * @see FinalLine
     * @see LuckyNewGame
     */
    public LuckyGame(Location waitingLobby, LuckyNewGame luckyNewGame, Location lobbyWhenGameEnd, FinalLine finalLine, Status status) {
        super(luckyNewGame.getUuid(), luckyNewGame.getMaxPlayers(), luckyNewGame.getMinPlayers(),
                luckyNewGame.getPlayersSpawn(), luckyNewGame.getLuckyChests(), luckyNewGame.getLuckyPlayerInGames());
        this.waitingLobby = waitingLobby;
        this.lobbyWhenGameEnd = lobbyWhenGameEnd;
        this.finalLine = finalLine;
        this.status = status;
    }

    public Location getLobbyWhenGameEnd() {
        return lobbyWhenGameEnd;
    }

    public void setLobbyWhenGameEnd(Location lobbyWhenGameEnd) {
        this.lobbyWhenGameEnd = lobbyWhenGameEnd;
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

    public Status getStatus() {
        return status;
    }

    public enum Status {
        WAITING,
        LOBBY,
        IN_GAME,
        RESET,
        ERROR,
    }
}
