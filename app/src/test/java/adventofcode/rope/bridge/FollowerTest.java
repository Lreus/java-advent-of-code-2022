package adventofcode.rope.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FollowerTest {
    @Test
    void instantiateFollower() {
        Follower tail = new Follower(0, 0);
        assertEquals(0, tail.getPosition().row());
        assertEquals(0, tail.getPosition().column());
    }

    @Test
    void doesNotMoveIfTargetCoversActualPosition() {
        Follower tail = new Follower(0, 0);
        Mover head = new Mover(0, 0);

        head.addFollower(tail);
        head.move("R 0");

        assertEquals(0, tail.getPosition().row());
        assertEquals(0, tail.getPosition().column());
    }

    @Test
    void movingTargetIsFollowed() {
        Follower tail = new Follower(0, 0);
        Mover head = new Mover(0, 0);
        head.addFollower(tail);

        head.move("R 3");
        assertEquals(new Position(0, 2), tail.getPosition());

        head.move("L 3");
        assertEquals(new Position(0, 1), tail.getPosition());

        head.move("U 1");
        assertEquals(new Position(0, 1), tail.getPosition());

        head.move("U 1");
        assertEquals(new Position(1, 0), tail.getPosition());

        head.move("L 1");
        assertEquals(new Position(1, 0), tail.getPosition());

        head.move("L 1");
        assertEquals(new Position(2, -1), tail.getPosition());
    }

    @Test
    void followingTargetCountPositionVisitedOnce() {
        Follower tail = new Follower(0, 0);
        assertEquals(1, tail.visitedOnceCount());

        Mover head = new Mover(0, 0);
        head.addFollower(tail);
        head.move("R 4");
        head.move("U 4");
        head.move("L 3");
        head.move("D 1");
        head.move("R 4");
        head.move("D 1");
        head.move("L 5");
        head.move("R 2");

        assertEquals(13, tail.visitedOnceCount());
    }
}
