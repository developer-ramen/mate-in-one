package me.ramendev.mateinone.engine.core;

import lombok.Value;
import lombok.experimental.NonFinal;
import me.ramendev.mateinone.engine.constant.Direction;

@Value
@NonFinal
public class Vector {
    int rank, file;

    public Vector translate(final Vector factor) {
        return new Vector(getRank() + factor.getRank(), getFile() + factor.getFile());
    }

    public Vector translate(final Direction direction) {
        return direction.translate(this);
    }

    public Vector scale(final int scalar) {
        return new Vector(getRank() * scalar, getFile() * scalar);
    }
}
