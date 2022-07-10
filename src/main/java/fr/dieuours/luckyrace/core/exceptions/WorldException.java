package fr.dieuours.luckyrace.core.exceptions;

public class WorldException extends GameConfigException {

    /**
     * Default constructor
     *
     * @see Exception
     */
    public WorldException() {
        super("LuckyError | World of one position is not the same of World of second position");
    }
}
