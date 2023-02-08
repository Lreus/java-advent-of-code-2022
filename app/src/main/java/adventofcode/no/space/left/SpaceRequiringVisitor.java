package adventofcode.no.space.left;

public class SpaceRequiringVisitor implements DirectoryVisitor {
    private final int requiredAmount;
    private Directory selection;

    public SpaceRequiringVisitor(int requiredAmount) {

        this.requiredAmount = requiredAmount;
    }

    @Override
    public void handle(Directory directory) {
        if (selection == null) {
            selection = directory;
        }

        if (directory.size() >= requiredAmount && directory.size() < selection.size()) {
            selection = directory;
        }
    }

    public Directory getSelection() {
        return selection;
    }
}
