package adventofcode.no.space.left;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tree {
    public static final String DIRECTORY_DECLARATION = "dir ";
    public static final String CHANGE_DIRECTORY_COMMAND = "$ cd ";
    public static final String STARTING_WITH_INTEGER_REGEX = "^[1-9][0-9]*";
    public static final int DISK_SIZE = 70000000;
    private final Directory root;
    private Directory currentDirectory;

    Tree(Directory root) {
        this.root = root;
        currentDirectory = root;
    }

    public Directory getRoot() {
        return root;
    }

    public Directory getCurrent() {
        return currentDirectory;
    }

    public void process(String terminalInput) {
        if (terminalInput.startsWith(DIRECTORY_DECLARATION)) appendDirectory(terminalInput);
        if (terminalInput.startsWith(CHANGE_DIRECTORY_COMMAND)) updateCurrentDirectory(terminalInput);

        Matcher matcher = matchForStartingWithInteger(terminalInput);
        if (matcher.find()) appendFile(terminalInput, matcher);

    }

    private void appendDirectory(String terminalInput) {
        getCurrent().append(
            new Directory(terminalInput.replace(DIRECTORY_DECLARATION, ""))
        );
    }

    private void updateCurrentDirectory(String terminalInput) {
        currentDirectory = currentDirectory.changeDirectory(
                terminalInput.replace(CHANGE_DIRECTORY_COMMAND, "")
        );
    }

    private void appendFile(String terminalInput, Matcher matcher) {
        String size = matcher.group();
        String fileName = terminalInput.substring(size.length()).trim();
        getCurrent().append(new File(Integer.parseInt(size), fileName));
    }

    private static Matcher matchForStartingWithInteger(String terminalInput) {
        Pattern pattern = Pattern.compile(STARTING_WITH_INTEGER_REGEX);

        return pattern.matcher(terminalInput);
    }

    public int sumDirectoriesBelow(int sizeLimitPerDirectory) {
        LimitedWeightAccumulatorVisitor visitor = new LimitedWeightAccumulatorVisitor(sizeLimitPerDirectory);
        getRoot().pass(visitor);

        return visitor.getLoad();
    }

    public int getSmallestCandidateSizeForDeletion(int spaceRequired) {
        int actualFreeSpace = DISK_SIZE - getRoot().size();
        int amountToDelete = spaceRequired - actualFreeSpace;
        if (amountToDelete > 0 ) {
            SpaceRequiringVisitor visitor = new SpaceRequiringVisitor(amountToDelete);
            getRoot().pass(visitor);
            return visitor.getSelection().size();
        }

        return 0;
    }
}
