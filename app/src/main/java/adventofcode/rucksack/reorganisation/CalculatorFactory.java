package adventofcode.rucksack.reorganisation;

public class CalculatorFactory {
    public static PriorityCalculator getCalculator() {
        return new PriorityCalculator(
                new Splitter(),
                new StringComparator(),
                new PriorityMapper()
        );
    }

    public static BadgeCalculator getBadgeCalculator() {
        return new BadgeCalculator(
                new StringComparator(),
                new PriorityMapper()
        );
    }
}
