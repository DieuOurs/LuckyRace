package fr.dieuours.luckyrace.core.game;

import fr.dieuours.luckyrace.core.FinalLine;
import fr.dieuours.luckyrace.core.events.LuckyGameStatusChangeEvent;
import fr.dieuours.luckyrace.core.exceptions.GameException;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LuckyGame extends LuckyNewGame {

    //TODO GETTER AND SETTER BUT THEY MIGHT BE USED
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

    public Location getWaitingLobby() {
        return waitingLobby;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * NEED BUKKIT
     *
     * @param status Status
     * @throws GameException if (this.getStatus() == status)
     * @see Bukkit
     * @see LuckyGameStatusChangeEvent
     */
    public void setStatus(Status status) throws GameException {
        Bukkit.getServer().getPluginManager().callEvent(new LuckyGameStatusChangeEvent(this, status));
        this.status = status;
    }

    public void sendMessageToEveryPlayerInGame(String message) {
        this.getLuckyPlayerInGames().forEach(x -> Bukkit.getPlayer(x.getUuid()).sendMessage(message));
    }

    public Location getLobbyWhenGameEnd() {
        return lobbyWhenGameEnd;
    }

    public enum Status {
        WAITING,
        LOBBY,
        IN_GAME,
        END
        /*RESET,
        ERROR,*/
    }
}
