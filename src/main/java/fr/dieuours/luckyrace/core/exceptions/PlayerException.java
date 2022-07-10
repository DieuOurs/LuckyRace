package fr.dieuours.luckyrace.core.exceptions;

public class PlayerException extends Exception {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public PlayerException() {
        super("LuckyError | UUID of the player not found in pl.getLuckyPlayers()");
    }

    /**
     * @param message String
     */
    public PlayerException(String message) {
        super(message);
    }
}
