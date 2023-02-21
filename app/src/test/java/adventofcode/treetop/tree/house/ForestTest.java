package adventofcode.treetop.tree.house;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForestTest {
    private Forest forest;

    @BeforeEach
    void buildForest() {
        this.forest = new Forest(new EdgeTreeCounter());
    }

    private void plantForest(Integer[][] map) {
        Arrays.stream(map).forEach(row -> forest.plant(row));
    }

    @Test
    void gettingTreeFromForest() {
        plantForest(new Integer[][]{
                {3, 0, 3, 7, 3},
                {2, 5, 5, 1, 2},
                {6, 5, 3, 3, 2},
                {3, 3, 8, 4, 9},
                {3, 5, 3, 9, 0},
                {3, 5, 3, 9, 0},
        });

        Tree plantedTree = forest.get(3, 2);
        assertEquals(3, plantedTree.getRow());
        assertEquals(2, plantedTree.getColumn());
        assertEquals(8, plantedTree.getHeight());
    }

    @Test
    void pickingTreeRow() {
        plantForest(new Integer[][]{
                {3, 0, 1},
                {2, 5, 7},
                {6, 8, 4},
        });

        List<Tree> result = forest.pickRow(1);

        assertEquals(3, result.size());
        assertEquals(new Tree(1, 0, 2), result.get(0));
        assertEquals(new Tree(1, 1, 5), result.get(1));
        assertEquals(new Tree(1, 2, 7), result.get(2));
    }

    @Test
    void pickingTreeColumn() {
        plantForest(new Integer[][]{
                {3, 0, 1},
                {2, 5, 7},
                {6, 8, 4},
        });

        List<Tree> result = forest.pickColumn(2);

        assertEquals(3, result.size());
        assertEquals(new Tree(0, 2, 1), result.get(0));
        assertEquals(new Tree(1, 2, 7), result.get(1));
        assertEquals(new Tree(2, 2, 4), result.get(2));
    }

    @Test
    void getAmountOfVisibleTree() {
        plantForest(new Integer[][]{
                {3, 0, 3, 7, 3},
                {2, 5, 5, 1, 2},
                {6, 5, 3, 3, 2},
                {3, 3, 5, 4, 9},
                {3, 5, 3, 9, 0},
        });

        assertEquals(21, forest.countVisibleTrees());
    }
}
