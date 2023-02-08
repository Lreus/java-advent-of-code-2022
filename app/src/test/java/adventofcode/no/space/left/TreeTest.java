package adventofcode.no.space.left;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    private Directory root;
    private Tree tree;

    @BeforeEach
    void buildTestedTree() {
        root = new Directory("/");
        tree = new Tree(root);
    }
    @Test
    void providedDirectoryIsPromotedAsCurrent() {
        assertSame(root, tree.getRoot());
    }

    @Test
    void rootIsCurrentDirectoryOnNewInstance() {
        assertSame(root, tree.getCurrent());
    }

    @Test
    void processingNewDirInput() {
        tree.process("dir a");
        assertInstanceOf(Directory.class,  root.changeDirectory("a"));
    }

    @Test
    void processingNewFileInput() {
        tree.process("152489 b.txt");
        assertEquals(152489, root.size());
    }

    @Test
    void processingChangeDirectoryInput() {
        tree.process("dir a");
        tree.process("$ cd a");

        assertEquals("a", tree.getCurrent().name());
    }

    @Test
    void changingDirectoryForParentDirectory() {
        tree.process("dir a");
        tree.process("$ cd a");
        tree.process("$ cd ..");

        assertEquals("/", tree.getCurrent().name());
    }

    @Test
    void changingDirectoryForRootDirectory() {
        tree.process("dir sub0");
        tree.process("$ cd sub0");
        tree.process("dir sub1");
        tree.process("$ cd sub1");
        tree.process("$ cd /");

        assertSame(root, tree.getCurrent());
    }

    @Test
    void CalculatedSizeWithFunctionalExample() {
        loadFileSystemWithExample();

        tree.process("$ cd a");
        assertEquals(94853, tree.getCurrent().size());

        tree.process("$ cd ..");
        tree.process("$ cd d");
        assertEquals(24933642, tree.getCurrent().size());

        assertEquals(95437, tree.sumDirectoriesBelow(100000));
    }

    private void loadFileSystemWithExample() {
        String inputs = """
                cd /
                $ ls
                dir a
                14848514 b.txt
                8504156 c.dat
                dir d
                $ cd a
                $ ls
                dir e
                29116 f
                2557 g
                62596 h.lst
                $ cd e
                $ ls
                584 i
                $ cd ..
                $ cd ..
                $ cd d
                $ ls
                4060174 j
                8033020 d.log
                5626152 d.ext
                7214296 k
                """;
        Scanner scanner = new Scanner(inputs);
        while (scanner.hasNextLine()) {
            tree.process(scanner.nextLine());
        }

        tree.process("$ cd /");
    }

    @Test
    void bestCandidateForDeletionWithFunctionalExample() {
        loadFileSystemWithExample();

        tree.process("$ cd /");
        assertEquals(48381165, tree.getCurrent().size());

        assertEquals(24933642, tree.getSmallestCandidateSizeForDeletion(30000000));
    }
}
