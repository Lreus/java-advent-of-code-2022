package adventofcode.no.space.left;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
    private Directory root;

    @BeforeEach
    void buildTestedDirectory() {
        root = new Directory("/");
    }
    @Test
    void initialSize() {
        assertEquals(0, root.size());
    }

    @Test
    void appendingFileIncreaseSize() {
        root.append(new File(5, "b.txt"));
        root.append(new File(1, "c.txt"));

        assertEquals(6, root.size());
    }

    @Test
    void appendingDirectoryIncreaseSizeWithSubdirectorySize() {
        Directory subDirectory = new Directory("sub0");
        subDirectory.append(new File(6, "sub.txt"));

        root.append(new File(5, "b.txt"));
        root.append(new File(1, "c.txt"));
        root.append(subDirectory);

        assertEquals(12, root.size());
    }

    @Test
    void rootDirectoryHasNoParent() {
        assertTrue(root.getParent().isEmpty());
    }

    @Test
    void appendingDirectoryCreatesAHierarchy() {
        Directory subDirectory = new Directory("sub0");
        root.append(subDirectory);

        assertTrue(subDirectory.getParent().isPresent());
        assertSame(root, subDirectory.getParent().get());
    }

    @Test
    void findingDirectoryByName() {
        Directory subDirectory = new Directory("sub0");
        Directory nextDirectory = new Directory("scorpion");

        root.append(subDirectory);
        root.append(nextDirectory);

        assertSame(nextDirectory, root.changeDirectory("scorpion"));
    }

    @Test
    void changingForAMissingDirectoryThrowsException() {
        assertThrows(RuntimeException.class, () -> root.changeDirectory("mortalKombat"));
    }

    @Test
    void newInstanceIsRoot() {
        assertSame(root, root.getRoot());
    }

    @Test
    void appendedDirectoryGetsParentRoot() {
        Directory level1 = new Directory("sub0");
        Directory level2 = new Directory("scorpion");

        root.append(level1);
        level1.append(level2);

        assertSame(level2.getRoot(), root.getRoot());
    }

    @Test
    void appendedHierarchyGetsParentRoot() {
        Directory level1 = new Directory("sub0");
        Directory level2 = new Directory("scorpion");
        level1.append(level2);

        root.append(level1);

        assertSame(level2.getRoot(), root.getRoot());
    }
}
