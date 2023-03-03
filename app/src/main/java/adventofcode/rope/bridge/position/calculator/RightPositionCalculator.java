package adventofcode.rope.bridge.position.calculator;

import adventofcode.rope.bridge.Position;

public class RightPositionCalculator implements NextPositionCalculator {
    @Override
    public Position next(Position actual) {
        return new Position(actual.row(), actual.column() + 1);
    }
}
