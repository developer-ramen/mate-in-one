package dev.ramen.mateinone.engine.constant;

import dev.ramen.mateinone.engine.core.Vector;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides semantic "meaning" for {@link Vector}s, which are used to describe
 * positions on the board and specifically movement, which this class' provided
 * static instances achieve.
 * TODO Add to docs about Pieces using Direction to move, do after the implementation of Piece
 */
public class Direction extends Vector {
    /**
     * Trivial constructor inherited from {@link Vector}.
     * @param rank The change in rank that the direction creates.
     * @param file The change is file that the direction creates.
     */
    private Direction(int rank, int file) {
        super(rank, file);
    }

    /**
     * Trivial copy constructor from a {@link Vector} instance.
     * @param vector The original vector to be copied to this instance of Direction.
     */
    private Direction(Vector vector) {
        this(vector.getRank(), vector.getFile());
    }

    public static Direction
        /*
          Should not be used. Is an empty Direction that does not make a change in rank
          or file, and thus does not make a change in position and is effectively useless.
          Also, Javadoc seems to only work after the first variable in a multi-line multiple
          variable declaration.
        */
        PLACEHOLDER,

        /**
         * The north direction, which travels one cell up, or -1 rank.
         */
        NORTH,

        /**
         * The north direction, which travels one cell down, or +1 rank.
         */
        SOUTH,

        /**
         * The west direction, which travels one cell left, or -1 file.
         */
        WEST,

        /**
         * The east direction, which travels one cell right, or +1 file.
         */
        EAST,

        /**
         * The northwest direction, which is a combination of {@link Direction#NORTH}
         * and {@link Direction#WEST}.
         */
        NORTHWEST,

        /**
         * The northwest direction, which is a combination of {@link Direction#NORTH}
         * and {@link Direction#EAST}.
         */
        NORTHEAST,

        /**
         * The northwest direction, which is a combination of {@link Direction#SOUTH}
         * and {@link Direction#WEST}.
         */
        SOUTHWEST,

        /**
         * The northwest direction, which is a combination of {@link Direction#SOUTH}
         * and {@link Direction#EAST}.
         */
        SOUTHEAST;

    public static Set<Direction>
        /*
          Should not be used. Same as above.
          TODO For each of the collections below, document their specific uses (like the Rook to the orthogonal list) after implementation of Bishop, Rook and Queen.
        */
        LPLACEHOLDER,

        /**
         * The collection of directions that describe "horizontal" and "vertical" movement,
         * in technical terms. It contains {@link Direction#NORTH}, {@link Direction#SOUTH},
         * {@link Direction#WEST}, and {@link Direction#EAST}.
         */
        ORTHOGONAL,

        /**
         * The collection of directions that describe "diagonal" movement,
         * in technical terms. It contains {@link Direction#NORTHWEST}, {@link Direction#NORTHEAST},
         * {@link Direction#SOUTHWEST}, and {@link Direction#SOUTHEAST}.
         */
        DIAGONAL,

        /**
         * The collection of directions that describe every direction that is necessary
         * for chess piece movement, but also every direction on a compass. Its content is
         * {@link Direction#ORTHOGONAL} and {@link Direction#DIAGONAL}'s elements.
         */
        COMPASS;

    static {
        PLACEHOLDER = new Direction(0, 0);
        NORTH = new Direction(-1, 0);
        SOUTH = new Direction(1, 0);
        WEST = new Direction(0, -1);
        EAST = new Direction(0, 1);
        NORTHWEST = new Direction(NORTH.translate(WEST));
        NORTHEAST = new Direction(NORTH.translate(EAST));
        SOUTHWEST = new Direction(SOUTH.translate(WEST));
        SOUTHEAST = new Direction(SOUTH.translate(EAST));

        LPLACEHOLDER = Set.of();
        ORTHOGONAL = Set.of(NORTH, SOUTH, WEST, EAST);
        DIAGONAL = Set.of(NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST);
        COMPASS = Stream.concat(ORTHOGONAL.stream(), DIAGONAL.stream()).collect(Collectors.toSet());
    }
}
