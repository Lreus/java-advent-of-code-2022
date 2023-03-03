package adventofcode.rope.bridge;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class Follower {
    private Position position;
    private final Set<Position> visitedOnce;

    public Follower(int startingRow, int startingColumn) {
        visitedOnce = new HashSet<>();
        setPosition(new Position(startingRow, startingColumn));
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
        visitedOnce.add(position);
    }

    public void update(Position target) {
        if (target.isAdjacentTo(position)) {
            return;
        }

        setPosition(getNearestPosition(target));
    }

    private Position getNearestPosition(Position target) {
        int deltaRow = abs(target.row() - position.row());
        if (deltaRow > 1) {
            return new Position(
                getNextCoordinate(target.row(), position.row()),
                target.column()
            );
        }

        return new Position(
            target.row(),
            getNextCoordinate(target.column(), position.column())
        );
    }

    private int getNextCoordinate(int targetCoordinate, int actualCoordinate) {
        int difference = targetCoordinate - actualCoordinate;

        if(difference > 0) {
            return targetCoordinate - 1;
        }

        return targetCoordinate + 1;
    }

    public int visitedOnceCount() {
        return visitedOnce.size();
    }
}
