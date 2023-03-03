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

        Leader head = new Leader(0, 0);
        CommandInterpreter interpreter = new CommandInterpreter(head);
        Follower neck = new Follower(0, 0);
        head.addFollower(neck);
        head.addVertebrae(7);

        Follower tail = new Follower(0, 0);
        head.addFollower(tail);
        head.printName();
        while (loadedFile.hasNextLine()) {
            interpreter.run(loadedFile.nextLine());
        }

        return String.join(
            System.lineSeparator(),
            buildVisitedCountMessage(neck, "neck"),
            buildVisitedCountMessage(tail, "tail")
        );
    }

    private String buildVisitedCountMessage(Follower subject, String label) {
        return String.format(
            "%s has visited %d different positions at least once.",
            label,
            subject.visitedOnceCount()
        );
    }
}
