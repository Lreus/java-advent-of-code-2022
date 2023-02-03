package adventofcode.rucksack.reorganisation;

import adventofcode.file.processor.FileCommand;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateBadgesCommand implements FileCommand {
    private Scanner loadedFile;

    public void setLoadedFile(Scanner loadedFile) {
        this.loadedFile = loadedFile;
    }

    @Override
    public String call() throws Exception {
        if (null == loadedFile) {
            return "No file loaded, cannot execute command";
        }

        return calculateElvenBadgesSum(loadedFile);
    }

    private String calculateElvenBadgesSum(Scanner scanner) {
        BadgeCalculator calculator = CalculatorFactory.getBadgeCalculator();
        while (scanner.hasNextLine()) {
            ArrayList<String> triplets = pickNextThreeLines(scanner);

            if (triplets.size() == 3) {
                calculator.process(
                        triplets.get(0),
                        triplets.get(1),
                        triplets.get(2)
                );
            }
        }

        return String.format("Calculated badges equal to : %d", calculator.getScore());
    }

    private ArrayList<String> pickNextThreeLines(Scanner scanner) {
        ArrayList<String> triplets = new ArrayList<>();

        while (triplets.size() < 3 && scanner.hasNextLine()) {
            triplets.add(scanner.nextLine());
        }

        return triplets;
    }
}
