package adventofcode.no.space.left;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SpaceRequiringVisitorTest {
    @Test
    void firstDirectoryIsSelected() {
        SpaceRequiringVisitor visitor = new SpaceRequiringVisitor(250);
        Directory root = buildNonEmptyDirectory(152);

        root.pass(visitor);

        assertSame(root, visitor.getSelection());
    }

    private static Directory buildNonEmptyDirectory(int size) {
        Directory dir = new Directory(String.format("dir-%d", size));
        dir.append(new File(size, "notImportant"));

        return dir;
    }

    @Test
    void firstDirectoryWithEnoughWeightIsSelected() {
        SpaceRequiringVisitor visitor = new SpaceRequiringVisitor(250);
        Directory root = new Directory("/");

        Directory sub1 = buildNonEmptyDirectory(270);
        Directory sub2 = buildNonEmptyDirectory(280);

        root.append(sub1);
        root.append(sub2);

        root.pass(visitor);
        assertSame(sub1, visitor.getSelection());
    }

    @Test
    void directoryWithNearestWeightIsSelected() {
        SpaceRequiringVisitor visitor = new SpaceRequiringVisitor(250);
        Directory root = new Directory("/");

        Directory sub1 = buildNonEmptyDirectory(270);
        Directory sub2 = buildNonEmptyDirectory(260);

        root.append(sub1);
        root.append(sub2);

        root.pass(visitor);
        assertSame(sub2, visitor.getSelection());
    }

    @Test
    void cumulatedDirectoriesAreSelected() {
        SpaceRequiringVisitor visitor = new SpaceRequiringVisitor(250);
        Directory root = new Directory("/");

        Directory sub1 = buildNonEmptyDirectory(270);
        Directory sub2 = buildNonEmptyDirectory(220);
        Directory sub3 = buildNonEmptyDirectory(30);

        sub2.append(sub3);
        root.append(sub1);
        root.append(sub2);

        root.pass(visitor);
        assertSame(sub2, visitor.getSelection());
    }
}
