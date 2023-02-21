package adventofcode.treetop.tree.house;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    void gettingTreeInstance() {
        int treeRow = 5;
        int treeCol = 8;
        int treeHeight = 7;
        Tree tree = buildTree(treeRow, treeCol, treeHeight);

        assertEquals(treeRow, tree.getRow());
        assertEquals(treeCol, tree.getColumn());
        assertEquals(treeHeight, tree.getHeight());
    }

    private Tree buildTree(int treeRow, int treeCol, int treeHeight) {
        return new Tree(treeRow, treeCol, treeHeight);
    }

    @Test
    void treesAreEqualByPosition() {
        Tree tree = buildTree(5, 8);
        Tree same = buildTree(5, 8);

        assertEquals(tree, same);
    }

    private Tree buildTree(int treeRow, int treeCol) {
        return new Tree(treeRow, treeCol, 0);
    }

    @Test
    void treesOnDifferentRowsAreNotEqual() {
        Tree tree = buildTree(5, 8);
        Tree wrongRow = buildTree(2, 8);

        assertNotEquals(tree, wrongRow);
    }

    @Test
    void treesOnDifferentColumnsAreNotEqual() {
        Tree tree = buildTree(5, 8);
        Tree wrongCol = buildTree(5, 7);

        assertNotEquals(tree, wrongCol);
    }

    @Test
    void nullIsNotEqualToATree() {
        Tree tree = buildTree(5, 8);

        assertNotEquals(tree, null);
    }

    @Test
    void hashSetPreventSameTreeInCollection() {
        HashSet<Tree> set = new HashSet<>();
        set.add(buildTree(0, 0));
        set.add(buildTree(0, 1));
        set.add(buildTree(1, 0));

        set.add(buildTree(0, 0));

        assertEquals(3, set.size());
    }
}
