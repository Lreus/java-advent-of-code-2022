package adventofcode.rope.bridge;

import java.util.stream.IntStream;

public class Leader extends AbstractFollowableDecorator {

    public Leader(int startingRow, int startingColumn) {
        position = new Position(startingRow, startingColumn);
    }

    public void update(Position newPosition) {
        position = newPosition;
        notifyFollower(position);
    }

    public void addVertebrae(int count) {
        IntStream.range(0, count)
            .forEach(i -> this.addFollower(new Follower(0, 0)));
    }

    public void printName() {
        System.out.println("Head");
        this.follower.printName(0);
    }
}
