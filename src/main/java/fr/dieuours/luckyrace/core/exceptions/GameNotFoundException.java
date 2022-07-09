package fr.dieuours.luckyrace.core.exceptions;

public class GameNotFoundException extends Exception {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public GameNotFoundException() {
        super("LuckyError | UUID of the game not found in pl.getLuckyGames()");
    }

    /**
     * @param message String
     */
    public GameNotFoundException(String message) {
        super(message);
    }
}
