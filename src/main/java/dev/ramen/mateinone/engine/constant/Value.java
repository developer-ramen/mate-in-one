package dev.ramen.mateinone.engine.constant;

// TODO Add Javadoc about Piece.value property
// TODO Add @sees to corresponding pieces.

import dev.ramen.mateinone.engine.exception.IncompatibleColorException;

/**
 * Provides standard, non-gameplay semantic "values" based on a piece's strategic
 * and usefulness (and other factors) value. This enumeration only contains data
 * widely agreed upon.
 */
public enum Value {
    /**
     * The value of the Illegal "piece". Since it cannot be a move and cannot be
     * factored in any kind of analysis, it has a default value of 0.
     */
    ILLEGAL(0),

    /**
     * The value of the Empty "piece".
     */
    EMPTY(0),

    /**
     * The value of the Pawn piece.
     */
    PAWN(1),

    /**
     * The value of the Knight piece.
     */
    KNIGHT(3),

    /**
     * The value of the Bishop piece.
     */
    BISHOP(3),

    /**
     * The value of the Rook piece.
     */
    ROOK(5),

    /**
     * The value of the Queen piece.
     */
    QUEEN(9),

    /**
     * The value of the King piece. Since it is the most important piece on the board,
     * its value is set to an arbitrarily high number, such as {@link Integer#MAX_VALUE}.
     */
    KING(Integer.MAX_VALUE);

    /**
     * The semantic absolute "value" of a piece. This is a number that, according to general standards,
     * is based on how good a piece is. It does not have an effect on normal gameplay.
     */
    private final int value;

    /**
     * Trivial getter for {@link #value}
     * @return The value of this instance.
     */
    public final int getAbsoluteValue() { return value; }

    /**
     * Gets the value of a piece, based on its color.
     * @param color The color of the piece.
     * @return The value of the piece with that color.
     * @throws IncompatibleColorException when an incompatible color is used for a value that is associated to an identifier
     *                                    which the color itself is incompatible with.
     * @apiNote When getting a piece's value, always use this method over the {@link #getAbsoluteValue()} method.
     */
    public final int getColoredValue(final Color color) throws IncompatibleColorException {
        if (getAbsoluteValue() == 0) {
            if (!color.equals(Color.NEUTRAL)) {
                throw new IncompatibleColorException(
                    "Value comes from a neutral piece " + name() + " and expected the color NEUTRAL, got " + color.name() + " instead"
                );
            }
        } else if (color.equals(Color.NEUTRAL)) {
            throw new IncompatibleColorException(
                "Value comes from a non-neutral piece " + name() + " and expected colors other than NEUTRAL, got NEUTRAL instead"
            );
        }
        return color.equals(Color.WHITE) ? getAbsoluteValue() : equals(KING) ? Integer.MIN_VALUE : -getAbsoluteValue();
    }

    /**
     * Trivial all arguments constructor.
     * @param value The absolute value of the piece.
     */
    Value(final int value) { this.value = value; }
}
