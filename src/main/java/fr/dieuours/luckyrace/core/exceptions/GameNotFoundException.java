package fr.dieuours.luckyrace.core.exceptions;

public class GameNotFoundException extends GameException {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public GameNotFoundException() {
        super("LuckyError | UUID of the game not found in pl.getLuckyGames()");
    }
}
