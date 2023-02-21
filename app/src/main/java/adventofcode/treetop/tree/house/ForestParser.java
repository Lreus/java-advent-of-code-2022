package adventofcode.treetop.tree.house;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class ForestParser implements FileCommand {
    private Scanner scanner;

    @Override
    public void setLoadedFile(Scanner loadedFile) {
        scanner = loadedFile;
    }

    @Override
    public String call() throws Exception {
        Forest forest = new Forest(new EdgeTreeCounter());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            forest.plant(mapToIntegerArray(line));
        }

        return String.format("%d trees are visible from the four forest edges", forest.countVisibleTrees());
    }

    private Integer[] mapToIntegerArray(String s) {
        return s.chars()
            .mapToObj(Character::toString)
            .map(Integer::parseInt)
            .toList()
            .toArray(new Integer[0]);
    }
}
