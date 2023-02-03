package adventofcode.supply.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomaticCraneTest {
    private Cargo cargo;
    private AutomaticCrane crane;
    @BeforeEach
    void buildEmptyCargo() {
        cargo = new Cargo();
        crane = new AutomaticCrane(cargo);
    }

    @Test
    void movingCrateAllAtOnce() {
        cargo.load("[N] [Q] [W]     [Z]");
        cargo.load("[S] [J] [C]     [F] [C]");
        cargo.load("[P] [L] [D] [C] [T] [Q] [R]");

        crane.move(new MoveCommand("move 1 from 1 to 2"));
        crane.move(new MoveCommand("move 4 from 2 to 4"));

        assertEquals(List.of("[P]", "[S]"), getStack(0));
        assertEquals(0, getStack(1).size());
        assertEquals(List.of("[C]", "[L]", "[J]", "[Q]", "[N]"), getStack(3));
    }

    private List<String> getStack(int stackPosition) {
        return cargo.getStack().get(stackPosition);
    }
}
