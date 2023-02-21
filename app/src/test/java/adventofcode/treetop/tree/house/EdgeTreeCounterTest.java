package adventofcode.treetop.tree.house;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class EdgeTreeCounterTest {
    private EdgeTreeCounter counter;

    @BeforeEach
    void createTestedCounter() {
        counter = new EdgeTreeCounter();
    }
    @Test
    void emptyLineHasNoVisibleTree() {
        ArrayList<Tree> empty = getTreeLine(new int[]{});

        Set<Tree> result = counter.findVisible(empty);

        assertInstanceOf(Set.class, result);
        assertEquals(0, result.size());
    }

    private ArrayList<Tree> getTreeLine(int[] treeHeights) {
        ArrayList<Tree> line = new ArrayList<>();

        IntStream.range(0, treeHeights.length).forEach(
                index -> line.add(new Tree(0, index, treeHeights[index]))
        );

        return line;
    }

    @Test
    void soloTreeIsVisibleFromTheEdge() {
        ArrayList<Tree> solo = getTreeLine(new int[]{2});

        Set<Tree> visibleTrees = counter.findVisible(solo);

        assertEquals(List.of(2), getSizesList(visibleTrees));
    }

    private List<Integer> getSizesList(Set<Tree> treeSet) {
        return treeSet.stream()
                .map(Tree::getHeight)
                .toList();
    }

    @Test
    void shorterTreeOnTheRightAreNotCounted() {
        ArrayList<Tree> line = getTreeLine(new int[]{5, 2, 1});

        Set<Tree> visibleTrees = counter.findVisible(line);

        assertEquals(List.of(5), getSizesList(visibleTrees));
    }

    @Test
    void higherTreesBehindAreVisible() {
        ArrayList<Tree> line = getTreeLine(new int[]{5, 2, 6});

        Set<Tree> visibleTrees = counter.findVisible(line);

        assertEquals(List.of(5, 6), getSizesList(visibleTrees));
    }

    @Test
    void gettingTreeFromBothSide() {
        ArrayList<Tree> line = getTreeLine(new int[]{5, 2, 4, 1});

        Set<Tree> visibleTrees = counter.findVisibleFromBothSide(line);

        assertEquals(List.of(5, 4, 1), getSizesList(visibleTrees));
    }
}
