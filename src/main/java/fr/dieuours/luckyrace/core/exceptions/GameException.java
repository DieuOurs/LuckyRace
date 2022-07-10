package fr.dieuours.luckyrace.core.exceptions;

public class GameException extends Exception {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public GameException() {
        super("LuckyError | GameException...");
    }

    /**
     * @param message String
     */
    public GameException(String message) {
        super(message);
    }
}
