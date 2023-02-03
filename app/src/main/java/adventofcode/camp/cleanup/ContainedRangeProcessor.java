package adventofcode.camp.cleanup;

public class ContainedRangeProcessor {
    private int containedNumber = 0;
    private int overlappingNumber = 0;

    public int getContainedRangeNumber() {
        return containedNumber;
    }

    public void process(String s) {
        String[] representations = s.split(",");
        assert representations.length == 2;
        CleaningRange first = new CleaningRange(representations[0]);
        CleaningRange next = new CleaningRange(representations[1]);

        if (first.contains(next) || next.contains(first)) {
            containedNumber += 1;
        }

        if (first.overlap(next) || next.overlap(first)) {
            overlappingNumber += 1;
        }
    }

    public int getOverlappingRangeNumber() {
        return overlappingNumber;
    }
}
