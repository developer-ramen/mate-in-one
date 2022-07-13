package me.ramendev.mateinone.engine.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import me.ramendev.mateinone.engine.exception.IncompatibleColorException;

class ValueTest {
    @Test
    void getAbsoluteValueReturnsExpectedProperty() {
        Assertions.assertEquals(0, Value.EMPTY.getAbsoluteValue(), "The value of Empty is 0");
        Assertions.assertEquals(0, Value.ILLEGAL.getAbsoluteValue(), "The value of Illegal is 0");
        Assertions.assertEquals(3, Value.KNIGHT.getAbsoluteValue(), "The value of Knight is 3");
        Assertions.assertEquals(Integer.MAX_VALUE, Value.KING.getAbsoluteValue(), "The value of King is the maximum Integer value");
    }

    @Test
    @SneakyThrows
    void getColoredValueReturnsExpectedValue() {
        Assertions.assertEquals(0, Value.EMPTY.getColoredValue(Color.NEUTRAL), "The value of Empty is 0");
        Assertions.assertEquals(0, Value.ILLEGAL.getColoredValue(Color.NEUTRAL), "The value of Illegal is 0");
        Assertions.assertEquals(3, Value.KNIGHT.getColoredValue(Color.WHITE), "The value of a white Knight is 3");
        Assertions.assertEquals(Integer.MIN_VALUE, Value.KING.getColoredValue(Color.BLACK), "The value of a black King is the minimum Integer value");
    }

    @Test
    @SneakyThrows
    void getColoredValueWithWrongColorThrowsException() {
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Value.EMPTY.getColoredValue(Color.WHITE),
            "The Empty piece is a neutral piece and has no white or colored value"
        );
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Value.ILLEGAL.getColoredValue(Color.BLACK),
            "The Illegal piece is a neutral piece and has no black or colored value"
        );
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Value.KNIGHT.getColoredValue(Color.NEUTRAL),
            "The Knight is not a neutral piece and has no neutral value"
        );
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Value.KING.getColoredValue(Color.NEUTRAL),
            "The King is not a neutral piece and has no neutral value"
        );
    }
}
