package dev.ramen.mateinone.core;

import lombok.Data;

@Data
public final class Cell {
    private final Vector position;
    private Piece piece;
}
