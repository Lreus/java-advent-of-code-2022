package adventofcode.treetop.tree.house;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Forest {

    private final EdgeTreeCounter counter;
    private final List<List<Integer>> trees = new ArrayList<>();

    Forest(EdgeTreeCounter counter) {
        this.counter = counter;
    }

    public void plant(Integer[] row) {
        trees.add(new ArrayList<>(Arrays.asList(row)));
    }

    public Tree get(int row, int column) {
        return new Tree(row, column, trees.get(row).get(column));
    }

    public int countVisibleTrees() {
        Stream<Set<Tree>> visibleTreesOnRows = getVisibleTrees(this::pickRow, trees.size());
        Stream<Set<Tree>> visibleTreesOnColumns = getVisibleTrees(this::pickColumn, trees.get(0).size());

        Set<Tree> visibleTrees = new HashSet<>();
        visibleTreesOnRows.forEach(visibleTrees::addAll);
        visibleTreesOnColumns.forEach(visibleTrees::addAll);

        return visibleTrees.size();
    }

    private Stream<Set<Tree>> getVisibleTrees(IntFunction<List<Tree>> lineSelector, int lastIndex) {
        return IntStream.range(0, lastIndex)
            .mapToObj(lineSelector)
            .map(counter::findVisibleFromBothSide);
    }

    public List<Tree> pickRow(int row) {
        List<Integer> sizes = trees.get(row);

        return IntStream.range(0, sizes.size())
            .mapToObj(column -> new Tree(row, column, sizes.get(column)))
            .toList();
    }

    public List<Tree> pickColumn(int column) {
        return IntStream.range(0, trees.size())
            .mapToObj(row -> new Tree(row, column, trees.get(row).get(column)))
            .toList();
    }
}
