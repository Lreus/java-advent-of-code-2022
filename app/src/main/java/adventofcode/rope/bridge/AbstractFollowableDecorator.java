package adventofcode.rope.bridge;

abstract public class AbstractFollowableDecorator {
    protected Position position;
    protected Follower follower;

    public Position getPosition() {
        return position;
    }

    public void addFollower(Follower follower) {
        if (null == this.follower) {
            this.follower = follower;
            return;
        }

        this.follower.addFollower(follower);
    }

    protected void notifyFollower(Position newPosition) {
        if (null != follower) {
            follower.update(newPosition);
        }
    }

    abstract public void update(Position target);
}
