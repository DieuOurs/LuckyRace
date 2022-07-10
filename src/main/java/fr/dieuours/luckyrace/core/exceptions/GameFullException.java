package fr.dieuours.luckyrace.core.exceptions;

public class GameFullException extends GameException {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public GameFullException() {
        super("LuckyError | This game is full");
    }

    /**
     * @param message String
     */
    public GameFullException(String message) {
        super(message);
    }
}
