package adventofcode.rucksack.reoganisation;

import adventofcode.rucksack.reorganisation.BadgeCalculator;
import adventofcode.rucksack.reorganisation.CalculatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeCalculatorTest {

    private BadgeCalculator calculator;

    @BeforeEach
    void buildCalculator() {
        calculator = CalculatorFactory.getBadgeCalculator();
    }

    @Test
    void testInitialScore() {
        assertEquals(0, calculator.getScore());
    }

    @Test
    void testItAddUpBadgeValueToCurrentScore() {
        calculator.process(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg"
        );

        assertEquals(18, calculator.getScore());
    }
}
