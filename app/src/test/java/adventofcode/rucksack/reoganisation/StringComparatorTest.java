package adventofcode.rucksack.reoganisation;

import adventofcode.rucksack.reorganisation.StringComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringComparatorTest {

    private StringComparator comparator;

    @BeforeEach
    void beforeEach() {
        comparator = new StringComparator();
    }
    @Test
    void emptyStringsWhenProvidedDifferentChars() {
        assertEquals('0', comparator.findMatch("", ""));
    }

    @Test
    void singleCharGetsReturnedOnMatch() {
        assertEquals('a', comparator.findMatch("a", "a"));
    }

    @Test
    void singleCharGetsReturnedIfFound() {
        assertEquals('v', comparator.findMatch("v", "victory"));
        assertEquals('v', comparator.findMatch("v", "traverse"));
        assertEquals('0', comparator.findMatch("v", "Violation"));

        assertEquals('m', comparator.findMatch("mario", "m"));
        assertEquals('m', comparator.findMatch("bambi", "m"));
        assertEquals('0', comparator.findMatch("Mario", "m"));
    }

    @Test
    void singleCommonCharIsFoundBetweenTwoWords() {
        assertEquals('t', comparator.findMatch("therapy", "longitude"));
        assertEquals('G', comparator.findMatch("ponG", "Girly"));
        assertEquals('0', comparator.findMatch("Greed", "long"));
    }

    @Test
    void singleCommonCharIsFoundBetweenThreeWords() {
        assertEquals('t', comparator.findMatch("ant", "true", "still"));
    }
}
