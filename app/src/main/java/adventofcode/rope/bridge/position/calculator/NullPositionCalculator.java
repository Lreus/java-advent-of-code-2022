package adventofcode.rope.bridge.position.calculator;

import adventofcode.rope.bridge.Position;

public class NullPositionCalculator implements NextPositionCalculator {
    @Override
    public Position next(Position actual) {
        return actual;
    }
}
