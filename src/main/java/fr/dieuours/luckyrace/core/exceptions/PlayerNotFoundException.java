package fr.dieuours.luckyrace.core.exceptions;

public class PlayerNotFoundException extends PlayerException {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public PlayerNotFoundException() {
        super("LuckyError | UUID of the player not found in pl.getLuckyPlayers()");
    }

    /**
     * @param message String
     */
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
