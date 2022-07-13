package me.ramendev.mateinone.engine.constant;

// TODO Write Tests after engine implementation.
/**
 * Provides semantic information about the type of move. This implementation
 * is not intended to affect gameplay.
 */
public enum MoveType {
    /**
     * A normal move, which only changes position of a piece on the board.
     */
    MOVE,

    /**
     * A move which moves a piece to an opposing piece's position and removes
     * it from the board.
     */
    CAPTURE,

    /**
     * A special move, in which the king and the rook change sides and moves
     * next to each other.
     */
    CASTLE,

    /**
     * A special move, in which the pawn moves diagonally and captures an opposing
     * pawn (that just moved two cells) to its side.
     */
    ENPASSANT,

    /**
     * A move which creates a check, which is a position in which the king is
     * "attacked", or more formally it is in the capturing range of the checking
     * piece.
     */
    CHECK,

    /**
     * A move which creates a check, in which the king cannot go anywhere to avoid checking,
     * and the game is over.
     */
    MATE
}
