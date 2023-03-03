package adventofcode.rope.bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {
    public static Stream<Position> adjacentToOriginPositionProvider() {
        return Stream.of(
            new Position(0, 1),
            new Position(-1, 1),
            new Position(-1, 0),
            new Position(-1, -1),
            new Position(0, -1),
            new Position(1, -1),
            new Position(1, 0),
            new Position(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("adjacentToOriginPositionProvider")
    void identifyAdjacentPosition(Position target) {
        Position start = new Position(0, 0);

        assertTrue(start.isAdjacentTo(target));
    }

    @Test
    void identifyNonAdjacentPosition() {
        Position start = new Position(0, 0);
        assertFalse(start.isAdjacentTo(new Position(0, 2)));
    }
}
