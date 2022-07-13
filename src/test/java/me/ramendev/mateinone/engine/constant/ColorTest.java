package me.ramendev.mateinone.engine.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorTest {
    @Test
    void getIndexReturnsExpectedProperty() {
        Assertions.assertEquals(0, Color.WHITE.getIndex(), "The index of White is 0");
        Assertions.assertEquals(1, Color.BLACK.getIndex(), "The index of Black is 1");
        Assertions.assertEquals(2, Color.NEUTRAL.getIndex(), "The index of Neutral is 2");
    }
}
