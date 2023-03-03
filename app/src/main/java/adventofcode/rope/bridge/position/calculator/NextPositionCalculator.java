package adventofcode.rope.bridge.position.calculator;

import adventofcode.rope.bridge.Position;

public interface NextPositionCalculator {
    Position next(Position actual);
}
