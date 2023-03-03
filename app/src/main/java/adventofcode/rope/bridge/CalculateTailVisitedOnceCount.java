package adventofcode.rope.bridge;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class CalculateTailVisitedOnceCount implements FileCommand {
    private Scanner loadedFile;

    @Override
    public void setLoadedFile(Scanner loadedFile) {
        this.loadedFile = loadedFile;
    }

    @Override
    public String call() {
        if (null == loadedFile) {
            return "No file loaded, cannot execute command";
        }

        Follower tail = new Follower(0, 0);
        Mover head = new Mover(0, 0);
        head.addFollower(tail);

        while (loadedFile.hasNextLine()) {
            head.move(loadedFile.nextLine());
        }

        return String.format("tail has visited %d different positions at least once.", tail.visitedOnceCount());
    }
}
