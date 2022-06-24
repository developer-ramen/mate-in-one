package dev.ramen.mateinone.engine.constant;

import dev.ramen.mateinone.engine.exception.IncompatibleColorException;
import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO Change the Empty and Illegal text into @links for the documentation below.
// TODO Add the corresponding classes to a @see to every Javadoc entry below.
/**
 * Provides unique identifiers for different pieces of both white and black color.
 * These identifiers provide basic semantic information about chess pieces and
 * the Empty and Illegal "piece" abstractions.
 */
@Getter
@AllArgsConstructor
public enum Identifier {
    /**
     * The identifier for the Empty "piece".
     */
    EMPTY(false, "  _"),

    /**
     * The identifier for the Illegal "piece".
     */
    ILLEGAL(false, "  !"),

    /**
     * The identifier for the Pawn piece.
     */
    PAWN(true, "Pp "),

    /**
     * The identifier for the Knight piece.
     */
    KNIGHT(true, "Nn "),

    /**
     * The identifier for the Bishop piece.
     */
    BISHOP(true, "Bb "),

    /**
     * The identifier for the Rook piece.
     */
    ROOK(true, "Rr "),

    /**
     * The identifier for the Queen piece.
     */
    QUEEN(true, "Qq "),

    /**
     * The identifier for the King piece.
     */
    KING(true, "Kk ");

    // TODO Add Javadoc about future implemented method Cell.isOccupied()
    /**
     * Specifies whether the identifier stands for a real piece that can exist ON the board.
     * This excludes the Empty and the Illegal piece.
     */
    final boolean piece;

    // TODO Add Javadoc about future implemented property Piece.identifier
    /**
     * The characters that contain the unique identification character needed for all colors
     * of that specific piece the identifier is referring to.
     */
    final String characters;

    /**
     * Gets the unique identification character for a color of the piece corresponding to
     * the piece the enumeration is referring to (in their identifier name).
     * @param color The color that contains the index to get the identification character.
     * @return The unique identification character of a piece with the certain color.
     * @throws IncompatibleColorException when an incompatible color is used for this identifier.
     */
    public char getIdentifierCharacter(Color color) throws IncompatibleColorException {
         char character = getCharacters().charAt(color.getIndex());
         if (character == ' ') {
             throw new IncompatibleColorException("Wrong color " + color.name() + " used for identifier " + name());
         }
         return character;
    }
}
