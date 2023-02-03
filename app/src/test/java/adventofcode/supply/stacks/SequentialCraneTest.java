package adventofcode.supply.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialCraneTest {
    private Cargo cargo;
    private SequentialCrane crane;
    @BeforeEach
    void buildEmptyCargo() {
        cargo = new Cargo();
        crane = new SequentialCrane(cargo);
    }
    @Test
    void movesCrateOneByOne() {
        cargo.load("[N] [Q] [W]     [Z]");
        cargo.load("[S] [J] [C]     [F] [C]");
        cargo.load("[P] [L] [D] [C] [T] [Q] [R]");

        crane.move(new MoveCommand("move 1 from 1 to 2"));
        crane.move(new MoveCommand("move 4 from 2 to 4"));

        assertEquals(List.of("[P]", "[S]"), getStack(0));
        assertEquals(0, getStack(1).size());
        assertEquals(List.of("[C]", "[N]", "[Q]", "[J]", "[L]"), getStack(3));
    }

    private List<String> getStack(int stackPosition) {
        return cargo.getStack().get(stackPosition);
    }

    @Test
    void attemptingToMoveCratesWhichNameAppearsFurtherInStack() {
        cargo.load("[N]");
        cargo.load("[N] [J]");

        crane.move(new MoveCommand("move 1 from 1 to 2"));
        assertEquals(List.of("[N]"), getStack(0));
        assertEquals(List.of("[J]", "[N]"), getStack(1));
    }
}
