package dev.ramen.mateinone.engine.constant;

/**
 * Provides "colors" that represents a player's color and/or a game's end state.
 * There are 4 "colors:
 * <ul>
 *     <li>{@link Color#WHITE} The color of the white player, who goes first in a game</li>
 *     <li>{@link Color#BLACK} The color of the black player, who goes second in a game</li>
 *     <li>{@link Color#NEUTRAL} The miscellaneous "illegal color".</li>
 * </ul>
 * @apiNote The {@link Color#NEUTRAL} color is used to denote the "no one won" game state.
 */
public enum Color {
    /**
     * The White color of a player in a chess game.
     * @apiNote The White color has the identifier char index of 0.
     * @see Identifier
     */
    WHITE(0),

    /**
     * The Black color of a player in a chess game.
     * @apiNote The Black color has the identifier char index of 1.
     * @see Identifier
     */
    BLACK(1),

    /**
     * // TODO Document this after Empty and Illegal implementation
     */
    NEUTRAL(2);

    /**
     * The index in which an {@link Identifier#chars} can get a character from.
     */
    private final int index;

    /**
     * Trivial all arguments constructor.
     * @param index The required index property.
     */
    Color(int index) { this.index = index; }

    /**
     * Trivial getter of {@link #index} of the enum.
     * @return The character index of the enum.
     */
    public int getIndex() { return index; }
}
