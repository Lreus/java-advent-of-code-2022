package adventofcode.no.space.left;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LimitedWeightAccumulatorVisitorTest {
    @Test
    void initialLoad() {
        LimitedWeightAccumulatorVisitor visitor = new LimitedWeightAccumulatorVisitor(0);
        assertEquals(0, visitor.getLoad());
    }

    @Test
    void directoriesUnderLimitAreAddedToLoad() {
        LimitedWeightAccumulatorVisitor visitor = new LimitedWeightAccumulatorVisitor(5);
        Directory directory = buildNonEmptyDirectory(5);

        directory.pass(visitor);
        assertEquals(directory.size(), visitor.getLoad());
    }

    private static Directory buildNonEmptyDirectory(int size) {
        Directory dir = new Directory(String.format("dir-%d", size));
        dir.append(new File(size, "notImportant"));

        return dir;
    }

    @Test
    void directoriesOverLimitAreIgnored() {
        LimitedWeightAccumulatorVisitor visitor = new LimitedWeightAccumulatorVisitor(5);
        Directory directory = buildNonEmptyDirectory(6);

        directory.pass(visitor);
        assertEquals(0, visitor.getLoad());
    }

    @Test
    void passingVisitorToDirectoryProcessSubDirectories() {
        LimitedWeightAccumulatorVisitor visitor = new LimitedWeightAccumulatorVisitor(300);

        Directory level1 = buildNonEmptyDirectory(2540);

        Directory level1_2 = buildNonEmptyDirectory(240);

        Directory level2 = buildNonEmptyDirectory(59);
        level1_2.append(level2);

        Directory root = buildNonEmptyDirectory(152);
        root.append(level1);
        root.append(level1_2);

        root.pass(visitor);
        assertEquals(level1_2.size() + level2.size(), visitor.getLoad());
    }
}
