package adventofcode.rucksack.reorganisation;

public class PriorityCalculator {
    private final Splitter splitter;
    private final StringComparator comparator;
    private final PriorityMapper mapper;

    private int score = 0;

    public PriorityCalculator(
        Splitter splitter,
        StringComparator comparator,
        PriorityMapper mapper
    ) {
        this.splitter = splitter;
        this.comparator = comparator;
        this.mapper = mapper;
    }

    public int getScore() {
        return score;
    }

    public void process (String ruckSack) {
        String[] list = splitter.split(ruckSack);
        char letter = comparator.findMatch(list[0], list[1]);
        score += mapper.getPriority(letter);
    }
}
