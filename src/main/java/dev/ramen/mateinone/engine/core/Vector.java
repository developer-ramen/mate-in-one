package dev.ramen.mateinone.core;

import dev.ramen.mateinone.constant.Direction;
import lombok.Value;

@Value
public class Vector {
    int rank, file;

    public Vector translate(final Vector factor) {
        return new Vector(getRank() + factor.getRank(), getFile() + factor.getFile());
    }

    public Vector translate(final Direction direction) {
        return translate(direction);
    }

    public Vector scale(final int scalar) {
        return new Vector(getRank() * scalar, getFile() * scalar);
    }
}
