package adventofcode.no.space.left;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class SpaceAnalyzerCommand implements FileCommand {
    private Scanner scanner;
    private final Tree tree;

    SpaceAnalyzerCommand() {
        tree = new Tree(new Directory("/"));
    }

    @Override
    public void setLoadedFile(Scanner loadedFile) {
        this.scanner = loadedFile;
    }

    @Override
    public String call() {
        loadFileSystem();

        return String.join(
            System.lineSeparator(),
            calculateTotalSizeOfAllDirectoriesUnder(100000),
            getNearestCandidateMessage(30000000));
    }

    private void loadFileSystem() {
        while (scanner.hasNextLine()) {
            tree.process(scanner.nextLine());
        }
    }

    private String calculateTotalSizeOfAllDirectoriesUnder(int sizeLimitPerDirectory) {
        return String.format(
            "Sum of all directories with a total size at most %d equals to: %d",
            sizeLimitPerDirectory,
            tree.sumDirectoriesBelow(sizeLimitPerDirectory));
    }

    private String getNearestCandidateMessage(int spaceRequired) {
        return String.format(
                "Nearest candidate size to get %d of free space : %d",
                spaceRequired,
                tree.getSmallestCandidateSizeForDeletion(spaceRequired));
    }
}
