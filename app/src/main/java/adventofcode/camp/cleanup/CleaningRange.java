package adventofcode.camp.cleanup;

public class CleaningRange {
    public final int min;
    public final int max;
//    private final Range<Integer> range;

    public CleaningRange(String representation) {
        String[] values  = representation.split("-");

        min = Integer.parseInt(values[0]);
        max = Integer.parseInt(values[1]);
//        range = Range.between(min, max);
    }

    public boolean contains(CleaningRange other) {
        return other.min >= min && other.max <= max;
//        return range.contains(other.min) && range.contains(other.max);
    }

    public boolean overlap(CleaningRange other) {
        return (other.min >= min && other.min <= max) || (other.max >= min && other.max <= max);
//        return range.contains(other.min) || range.contains(other.max);
    }
}
