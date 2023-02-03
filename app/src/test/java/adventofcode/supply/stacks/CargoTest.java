package adventofcode.supply.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CargoTest {

    private Cargo cargo;

    @BeforeEach
    void buildEmptyCargo() {
        cargo = new Cargo();
    }

    @Test
    void newCargoIsEmpty() {
        assertEquals(0, cargo.getStackNumber());
    }

    @Test
    void loadingOneCrateCreateOneStack() {
        cargo.load("[J]");
        assertEquals(List.of("[J]"), getStack(0));
    }

    private List<String> getStack(int stackPosition) {
        return cargo.getStack().get(stackPosition);
    }

    private int getStackSize(int stackPosition) {
        return getStack(stackPosition).size();
    }

    @Test
    void loadingOneCratesInSecondStack() {
        cargo.load("    [S]");
        assertEquals(2, cargo.getStackNumber());
        assertEquals(0, getStackSize(0));
        assertEquals(List.of("[S]"), getStack(1));
    }

    @Test
    void loadingTwoCratesBetweenAnEmptyStack() {
        cargo.load("[J]     [S]");

        assertEquals(3, cargo.getStackNumber());

        assertEquals(List.of("[J]"), getStack(0));
        assertEquals(0, getStackSize(1));
        assertEquals(List.of("[S]"), getStack(2));
    }

    @Test
    void stackingCratesOnAColumnFromTopToBottom() {
        cargo.load("[J]");
        cargo.load("[S]");
        assertEquals(List.of("[S]", "[J]"), getStack(0));
    }

    @Test
    void extendingLoad() {
        cargo.load("[J]");
        cargo.load("[V] [S]");

        assertEquals(2, cargo.getStackNumber());
        assertEquals(List.of("[V]", "[J]"), getStack(0));
        assertEquals(List.of("[S]"), getStack(1));
    }

    @Test
    void functionalLoading() {
        cargo.load("[N] [Q] [W]     [Z]");
        cargo.load("[S] [J] [C]     [F] [C]");
        cargo.load("[P] [L] [D] [C] [T] [Q] [R]");

        assertEquals(7, cargo.getStackNumber());

        assertEquals(List.of("[P]", "[S]", "[N]"), getStack(0));
        assertEquals(List.of("[L]", "[J]", "[Q]"), getStack(1));
        assertEquals(List.of("[D]", "[C]", "[W]"), getStack(2));
        assertEquals(List.of("[C]"), getStack(3));
        assertEquals(List.of("[T]", "[F]", "[Z]"), getStack(4));
        assertEquals(List.of("[Q]", "[C]"), getStack(5));
        assertEquals(List.of("[R]"), getStack(6));
    }

    @Test
    void printTopCrates() {
        cargo.load("[S] [J] [C]     [F] [C]");
        cargo.load("[P] [L] [D] [C] [T] [Q] [R]");
        assertEquals("SJCCFCR", cargo.getTopCrates());
    }
}
