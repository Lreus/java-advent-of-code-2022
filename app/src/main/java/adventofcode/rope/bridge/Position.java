package adventofcode.rope.bridge;

import static java.lang.Math.abs;

public record Position(int row, int column) {
    public boolean isAdjacentTo(Position target) {
        int columnDelta = abs(target.column() - column);
        int rowDelta = abs(target.row() - row);

        return columnDelta <= 1 && rowDelta <= 1;
    }
}
