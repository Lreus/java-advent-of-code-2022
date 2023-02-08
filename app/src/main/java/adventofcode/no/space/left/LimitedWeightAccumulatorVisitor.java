package adventofcode.no.space.left;

public class LimitedWeightAccumulatorVisitor implements DirectoryVisitor {
    private final int limit;
    private int load = 0;

    LimitedWeightAccumulatorVisitor(int limit) {
        this.limit = limit;
    }
    public int getLoad() {
        return load;
    }

    @Override
    public void handle(Directory directory) {
        if (directory.size() <= limit) {
            load += directory.size();
        }
    }
}
