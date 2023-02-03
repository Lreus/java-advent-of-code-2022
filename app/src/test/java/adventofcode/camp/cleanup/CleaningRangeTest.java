package adventofcode.camp.cleanup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CleaningRangeTest {
    @Test
    void buildingFromString() {
        CleaningRange range = new CleaningRange("1-5");
        assertEquals(1, range.min);
        assertEquals(5, range.max);
    }

    @Test
    void testContain() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange contained = new CleaningRange("2-4");

        assertTrue(first.contains(contained));
    }

    @Test
    void testLowerRangeIsNotContained() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange lower = new CleaningRange("0-4");

        assertFalse(first.contains(lower));
    }

    @Test
    void testHigherRangeIsNotContained() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange higher = new CleaningRange("2-6");

        assertFalse(first.contains(higher));
    }

    @Test
    void testNotOverLapping() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange next = new CleaningRange("6-8");

        assertFalse(first.overlap(next));
    }

    @Test
    void testOverLappingByRight() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange next = new CleaningRange("4-8");

        assertTrue(first.overlap(next));
    }

    @Test
    void testOverLappingByLeft() {
        CleaningRange first = new CleaningRange("1-5");
        CleaningRange next = new CleaningRange("0-2");

        assertTrue(first.overlap(next));
    }
}
