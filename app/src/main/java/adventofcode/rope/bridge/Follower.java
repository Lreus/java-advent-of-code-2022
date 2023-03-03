package adventofcode.rope.bridge;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class Follower extends AbstractFollowableDecorator {
    private final Set<Position> visitedOnce;
    public Follower(int startingRow, int startingColumn) {
        visitedOnce = new HashSet<>();
        setPosition(new Position(startingRow, startingColumn));
    }

    public void update(Position target) {
        if (target.isAdjacentTo(position)) {
            return;
        }

        setPosition(getNearestPosition(target));
        notifyFollower(position);
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
        visitedOnce.add(position);
    }

    private Position getNearestPosition(Position target) {
        int deltaRow = abs(target.row() - position.row());
        int deltaCol = abs(target.column() - position.column());
        if (deltaCol > 1 && deltaRow > 1) {
            return new Position(
                getNextCoordinate(target.row(), position.row()),
                getNextCoordinate(target.column(), position.column())
            );
        }

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

        if (difference > 0) {
            return targetCoordinate - 1;
        }

        return targetCoordinate + 1;
    }

    public int visitedOnceCount() {
        return visitedOnce.size();
    }

    public void printName(int previous) {
        System.out.println(previous + 1);
        if (null != follower) {
            follower.printName(previous + 1);
        }
    }
}
