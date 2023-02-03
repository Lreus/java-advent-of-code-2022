package adventofcode.rucksack.reorganisation;

public class BadgeCalculator {
    private final StringComparator comparator;
    private final PriorityMapper mapper;
    private int score = 0;

    public BadgeCalculator(StringComparator comparator, PriorityMapper mapper) {
        this.comparator = comparator;
        this.mapper = mapper;
    }

    public void process(String first, String next, String third) {
        char commonLetter = comparator.findMatch(first, next, third);
        score += mapper.getPriority(commonLetter);
    }

    public int getScore() {
        return score;
    }
}
