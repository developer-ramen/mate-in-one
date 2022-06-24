package dev.ramen.mateinone.engine.constant;

import dev.ramen.mateinone.engine.core.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class DirectionTest {
    @Test
    void equalsComparesDiagonalDirectionsWithDirectionCombinations() {
        Assertions.assertEquals(
            Direction.NORTHWEST,
            Direction.NORTH.translate(Direction.WEST),
            "The Northwest direction is North + West"
        );
        Assertions.assertEquals(
            Direction.NORTHEAST,
            Direction.NORTH.translate(Direction.EAST),
            "The Northeast is North + East"
        );
        Assertions.assertEquals(
            Direction.SOUTHWEST,
            Direction.SOUTH.translate(Direction.WEST),
            "The Southwest is South + West"
        );
        Assertions.assertEquals(
            Direction.SOUTHEAST,
            Direction.SOUTH.translate(Direction.EAST),
            "The Southwest is South + East"
        );
    }

    @Test
    void equalsComparesSameVectorsWithDirections() {
        Assertions.assertEquals(new Vector(-1, 0), Direction.NORTH, "The North direction moves one cell up");
        Assertions.assertEquals(new Vector(1, 0), Direction.SOUTH, "The South direction moves one cell down");
        Assertions.assertEquals(new Vector(0, -1), Direction.WEST, "The West direction moves one cell left");
        Assertions.assertEquals(new Vector(0, 1), Direction.EAST, "The East direction moves one cell right");
    }

    @Test
    void equalsComparesDirectionCollections() {
        Assertions.assertEquals(
            Set.of(
                Direction.NORTH,
                Direction.SOUTH,
                Direction.WEST,
                Direction.EAST
            ),
            Direction.ORTHOGONAL,
            "Orthogonal directions are North, South, West and East"
        );
        Assertions.assertEquals(
            Set.of(
                Direction.NORTHWEST,
                Direction.NORTHEAST,
                Direction.SOUTHWEST,
                Direction.SOUTHEAST
            ),
            Direction.DIAGONAL,
            "Diagonal directions are Northwest, Northeast, Southwest, Southeast"
        );
        Assertions.assertEquals(
            Set.of(
                Direction.NORTH,
                Direction.SOUTH,
                Direction.WEST,
                Direction.EAST,
                Direction.NORTHWEST,
                Direction.NORTHEAST,
                Direction.SOUTHWEST,
                Direction.SOUTHEAST
            ),
            Direction.COMPASS,
            "Compass directions are every direction on a compass, or the combination of orthogonal and diagonal directions."
        );
    }
}