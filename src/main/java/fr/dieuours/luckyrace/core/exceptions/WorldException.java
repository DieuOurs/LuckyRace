package fr.dieuours.luckyrace.core.exceptions;

public class WorldException extends Exception {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public WorldException() {
        super("LuckyError | World of one position is not the same of World of second position");
    }

    /**
     * @param message String
     */
    public WorldException(String message) {
        super(message);
    }
}
