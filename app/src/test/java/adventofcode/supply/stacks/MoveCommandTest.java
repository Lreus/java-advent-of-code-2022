package adventofcode.supply.stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveCommandTest {
    @ParameterizedTest
    @CsvSource({
            "1, 8, 4",
            "10, 2, 3"
    })
    void itTranslateInputIntoData(int quantity, int start, int target) {
        String commandMessage = String.format("move %d from %d to %d", quantity, start, target);
        MoveCommand command = new MoveCommand(commandMessage);

        assertEquals(quantity, command.getQuantity());
        assertEquals(start, command.getStart());
        assertEquals(target, command.getTarget());
    }
}
