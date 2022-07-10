package fr.dieuours.luckyrace.core.exceptions;

public class GameConfigException extends GameException {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public GameConfigException() {
        super("LuckyError | GameConfigException...");
    }

    /**
     * @param message String
     */
    public GameConfigException(String message) {
        super(message);
    }
}
