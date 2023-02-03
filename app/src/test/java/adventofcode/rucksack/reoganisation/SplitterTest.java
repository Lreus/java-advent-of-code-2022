package adventofcode.rucksack.reoganisation;

import adventofcode.rucksack.reorganisation.Splitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SplitterTest {

    private Splitter splitter;

    @BeforeEach
    void beforeEach() {
        splitter = new Splitter();
    }

    @Test
    void itSplitsStringEqually() {
        assertArrayEquals(new String[]{"a", "b"}, splitter.split("ab"));
        assertArrayEquals(new String[]{"PmmdzqPrV", "vPwwTWBwg"}, splitter.split("PmmdzqPrVvPwwTWBwg"));
        assertArrayEquals(new String[]{"vJrwpWtwJgWr", "hcsFMMfFFhFp"}, splitter.split("vJrwpWtwJgWrhcsFMMfFFhFp"));
    }
}
