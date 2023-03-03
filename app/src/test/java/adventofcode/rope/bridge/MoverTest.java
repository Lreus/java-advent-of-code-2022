package adventofcode.rope.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoverTest {
    private Mover head;

    @BeforeEach
    void buildMover() {
        head = new Mover(0, 0);
    }
    @Test
    void instantiateMover() {
        Mover head = new Mover(5, 7);
        assertEquals(5, head.getPosition().row());
        assertEquals(7, head.getPosition().column());
    }

    @Test
    void movingRight() {
        head.move("R 2");
        assertEquals(0, head.getPosition().row());
        assertEquals(2, head.getPosition().column());
    }

    @Test
    void movingLeft() {
        head.move("L 2");
        assertEquals(0, head.getPosition().row());
        assertEquals(-2, head.getPosition().column());
    }

    @Test
    void movingUp() {
        head.move("U 5");
        assertEquals(5, head.getPosition().row());
        assertEquals(0, head.getPosition().column());
    }

    @Test
    void movingDown() {
        head.move("D 7");
        assertEquals(-7, head.getPosition().row());
        assertEquals(0, head.getPosition().column());
    }


    @Test
    void movingOverTen() {
        head.move("R 10");
        assertEquals(0, head.getPosition().row());
        assertEquals(10, head.getPosition().column());
    }
}
