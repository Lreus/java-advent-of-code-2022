package adventofcode.supply.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageIdentifierTest {

    private MessageIdentifier identifier;

    @BeforeEach
    void buildIdentifier() {
        identifier = new MessageIdentifier();
    }


    @ParameterizedTest
    @ValueSource(strings = {"[J]", "    [J]", "[V]     [B] "})
    void itDetectsStackLine(String candidate) {
        assertTrue(identifier.isStackLine(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 2 3", "move 1 from 8 to 4"})
    void itDetectsInvalidStackLine(String candidate) {
        assertFalse(identifier.isStackLine(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[J]", "    [J]", "[V]     [B] ", "", "1 2 3"})
    void itDetectsInvalidMoveCommand(String candidate) {
        assertFalse(identifier.isMoveCommand(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {"move 1 from 8 to 4", "move 10 from 9 to 4"})
    void itDetectsValidMoveCommand(String candidate) {
        assertTrue(identifier.isMoveCommand(candidate));
    }
}
