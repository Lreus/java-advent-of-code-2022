package adventofcode.treetop.tree.house;

import java.util.Objects;

public class Tree {
    private final int row;
    private final int column;
    private final int height;

    Tree(int row, int column, int height) {
        this.row = row;
        this.column = column;
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tree otherTree)) {
            return false;
        }
        return otherTree.getRow() == row && otherTree.getColumn() == column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
