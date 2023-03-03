package adventofcode.rope.bridge;

import adventofcode.rope.bridge.position.calculator.CalculatorFactory;
import adventofcode.rope.bridge.position.calculator.NextPositionCalculator;

import java.util.stream.IntStream;

public class Mover {
    private Position position;
    private Follower tail;

    public Mover(int startingRow, int startingColumn) {
        position = new Position(startingRow, startingColumn);
    }

    public Position getPosition() {
        return position;
    }

    public void move(String moveCommand) {
        String direction = moveCommand.substring(0, 1);
        moveStepByStep(
            parseMovementValueAsInteger(moveCommand),
            CalculatorFactory.getCalculator(direction)
        );
    }

    private static int parseMovementValueAsInteger(String moveCommand) {
        return Integer.parseInt(moveCommand.substring(2));
    }

    private void moveStepByStep(int delta, NextPositionCalculator positionCalculator) {
        IntStream.range(0, delta).forEach(i -> updatePositionAndFollower(positionCalculator));
    }

    private void updatePositionAndFollower(NextPositionCalculator positionCalculator) {
        position = positionCalculator.next(position);
        if (tail != null) {
            tail.update(position);
        }
    }

    public void addFollower(Follower follower) {
        tail = follower;
    }
}
