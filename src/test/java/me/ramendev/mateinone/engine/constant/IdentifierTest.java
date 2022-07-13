package me.ramendev.mateinone.engine.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import me.ramendev.mateinone.engine.exception.IncompatibleColorException;

class IdentifierTest {
    @Test
    void isPieceReturnsExpectedProperty() {
        Assertions.assertFalse(Identifier.EMPTY.isPiece(), "The Empty abstraction is not a real piece");
        Assertions.assertFalse(Identifier.ILLEGAL.isPiece(), "The Illegal abstraction is not a real piece");
        Assertions.assertTrue(Identifier.KNIGHT.isPiece(), "The Knight is a piece");
        Assertions.assertTrue(Identifier.KING.isPiece(), "The King is a piece");
    }

    @Test
    void getCharactersReturnsExpectedProperty() {
        Assertions.assertEquals("  _", Identifier.EMPTY.getCharacters(), "Empty is represented with \"_\"");
        Assertions.assertEquals("  !", Identifier.ILLEGAL.getCharacters(), "Empty is represented with \"!\"");
        Assertions.assertEquals("Nn ", Identifier.KNIGHT.getCharacters(), "Empty is represented with \"Nn\"");
        Assertions.assertEquals("Kk ", Identifier.KING.getCharacters(), "Empty is represented with \"Kk\"");
    }

    @Test
    @SneakyThrows
    void getIdentifierCharacterReturnsExpectedCharacter() {
        Assertions.assertEquals('_', Identifier.EMPTY.getIdentifierCharacter(Color.NEUTRAL), "Empty is neutral and represented with \"_\"");
        Assertions.assertEquals('!', Identifier.ILLEGAL.getIdentifierCharacter(Color.NEUTRAL), "Illegal is neutral and represented with \"_\"");
        Assertions.assertEquals('N', Identifier.KNIGHT.getIdentifierCharacter(Color.WHITE), "Knight's white representation is \"N\"");
        Assertions.assertEquals('k', Identifier.KING.getIdentifierCharacter(Color.BLACK), "King's black representation is \"k\"");
    }

    @Test
    @SneakyThrows
    void getIdentifierCharacterWithWrongColorThrowsException() {
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Identifier.EMPTY.getIdentifierCharacter(Color.WHITE),
            "Empty is neutral and does not have a White representation");
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Identifier.ILLEGAL.getIdentifierCharacter(Color.BLACK),
            "Illegal is neutral and does not have a Black representation");
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Identifier.KNIGHT.getIdentifierCharacter(Color.NEUTRAL),
            "Knight is a real piece and does not have a Neutral representation");
        Assertions.assertThrows(
            IncompatibleColorException.class,
            () -> Identifier.KING.getIdentifierCharacter(Color.NEUTRAL),
            "King is a real piece and does not have a Neutral representation");
    }
}
