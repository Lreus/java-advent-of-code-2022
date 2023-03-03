package adventofcode.rope.bridge.position.calculator;

import adventofcode.rope.bridge.Position;

public class UpPositionCalculator implements NextPositionCalculator {
    public Position next(Position actual) {
        return new Position(actual.row() + 1, actual.column());
    }
}
