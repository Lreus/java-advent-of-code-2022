package adventofcode.rucksack.reoganisation;

import adventofcode.rucksack.reorganisation.CalculatorFactory;
import adventofcode.rucksack.reorganisation.PriorityCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityCalculatorTest {

    private PriorityCalculator calculator;

    @BeforeEach
    void buildCalculator() {
        calculator = CalculatorFactory.getCalculator();
    }
    @Test
    void initialScoreIsZero() {
        assertEquals(0, calculator.getScore());
    }

    @Test
    void itAddScoreBasedOnCommonCharLetter() {
        String[] ruckSacks = {
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw",
        };

        for (String sack : ruckSacks) {
            calculator.process(sack);
        }

        assertEquals(157, calculator.getScore());
    }
}
