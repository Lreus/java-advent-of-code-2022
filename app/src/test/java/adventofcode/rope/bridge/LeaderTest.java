package adventofcode.rope.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaderTest {
    private Leader head;
    private CommandInterpreter interpreter;

    @BeforeEach
    void buildMover() {
        head = new Leader(0, 0);
        interpreter = new CommandInterpreter(head);
    }
    @Test
    void instantiateMover() {
        Leader head = new Leader(5, 7);
        assertPositionEquals(5, 7, head);
    }

    @Test
    void movingRight() {
        interpreter.run("R 2");
        assertPositionEquals(0, 2, head);
    }

    @Test
    void movingLeft() {
        interpreter.run("L 2");
        assertPositionEquals(0, -2, head);
    }

    @Test
    void movingUp() {
        interpreter.run("U 5");
        assertPositionEquals(5, 0, head);
    }

    @Test
    void movingDown() {
        interpreter.run("D 7");
        assertPositionEquals(-7, 0, head);
    }


    @Test
    void movingOverTen() {
        interpreter.run("R 10");
        assertPositionEquals(0, 10, head);
    }

    private void assertPositionEquals(int row, int column, AbstractFollowableDecorator mover) {
        assertEquals(new Position(row, column), mover.getPosition());
    }
}
