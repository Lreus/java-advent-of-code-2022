package adventofcode.supply.stacks;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class LoadAndArrange implements FileCommand {

    private Scanner inputs;
    private final Crane crane;
    private final MessageIdentifier identifier;

    LoadAndArrange(Crane crane) {
        this.crane = crane;
        identifier = new MessageIdentifier();
    }
    @Override
    public void setLoadedFile(Scanner loadedFile) {
        inputs = loadedFile;
    }

    @Override
    public String call() {
        while (inputs.hasNextLine()) {
            String currentLine = inputs.nextLine();
            if (identifier.isStackLine(currentLine)) {
                crane.getCargo().load(currentLine);
            }

            if (identifier.isMoveCommand(currentLine)) {
                crane.move(new MoveCommand(currentLine));
            }
        }

        return String.format("Top crate list with CrateMover %s: ", crane.getModel())
                .concat(crane.getCargo().getTopCrates());
    }
}
