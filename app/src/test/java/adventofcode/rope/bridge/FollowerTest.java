package adventofcode.rope.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FollowerTest {
    private Follower tail;
    private Leader head;
    private CommandInterpreter interpreter;

    @BeforeEach
    void createMoveStack() {
        tail = new Follower(0, 0);
        head = new Leader(0, 0);
        head.addFollower(tail);
        interpreter = new CommandInterpreter(head);
    }

    @Test
    void instantiateFollower() {
        assertPositionEquals(0, 0, tail);
        assertEquals(1, tail.visitedOnceCount());
    }

    @Test
    void doesNotMoveIfTargetCoversActualPosition() {
        interpreter.run("R 0");

        assertPositionEquals(0, 0, tail);
    }

    @Test
    void movingTargetIsFollowed() {
        interpreter.run("R 3");
        assertPositionEquals(0,2, tail);

        interpreter.run("L 3");
        assertPositionEquals(0,1, tail);

        interpreter.run("U 1");
        assertPositionEquals(0,1, tail);

        interpreter.run("U 1");
        assertPositionEquals(1,0, tail);

        interpreter.run("L 1");
        assertPositionEquals(1,0, tail);

        interpreter.run("L 1");
        assertPositionEquals(2,-1, tail);
    }

    @Test
    void followingTargetCountPositionVisitedOnce() {
        interpreter.run("R 4");
        interpreter.run("U 4");
        interpreter.run("L 3");
        interpreter.run("D 1");
        interpreter.run("R 4");
        interpreter.run("D 1");
        interpreter.run("L 5");
        interpreter.run("R 2");

        assertEquals(13, tail.visitedOnceCount());
    }

    @Test
    void movingWithMoreThanOneFollower() {
        Follower subTail = new Follower(0,0);
        head.addFollower(subTail);

        interpreter.setSubject(head);
        interpreter.run("R 3");
        assertPositionEquals(0, 2, tail);
        assertPositionEquals(0, 1, subTail);
    }

    @Test
    void functionalTestMovingSnakeWithNinFollowers() {
        head = new Leader(0, 0);
        interpreter = new CommandInterpreter(head);

        head.addVertebrae(8);
        Follower tail = new Follower(0, 0);
        head.addFollower(tail);

        interpreter.run("R 5");
        interpreter.run("U 8");
        interpreter.run("L 8");
        interpreter.run("D 3");
        interpreter.run("R 17");
        interpreter.run("D 10");
        interpreter.run("L 25");
        interpreter.run("U 20");

        assertEquals(36, tail.visitedOnceCount());
    }

    @Test
    void diagonalTailFollowsDiagonally() {
        head = new Leader(2, 2);
        interpreter = new CommandInterpreter(head);

        Follower v1 = new Follower(1, 1);
        Follower v2 = new Follower(0, 0);
        head.addFollower(v1);
        head.addFollower(v2);

        interpreter.run("U 1");
        assertPositionEquals(3, 2, head);
        assertPositionEquals( 2, 2, v1);
        assertPositionEquals( 1, 1, v2);
    }

    private void assertPositionEquals(int row, int column, AbstractFollowableDecorator mover) {
        assertEquals(new Position(row, column), mover.getPosition());
    }
}
