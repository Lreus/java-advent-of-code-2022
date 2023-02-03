package adventofcode.rucksack.reorganisation;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class CalculatePrioritiesCommand implements FileCommand {
    public void setLoadedFile(Scanner loadedFile) {
        this.loadedFile = loadedFile;
    }

    private Scanner loadedFile;

    @Override
    public String call() throws Exception {
        if (null == loadedFile) {
            return "No file loaded, cannot execute command";
        }

        return calculatePrioritiesSumOfCommonItems(loadedFile);
    }

    private String calculatePrioritiesSumOfCommonItems(Scanner inputs)
    {
        PriorityCalculator calculator = CalculatorFactory.getCalculator();
        while (inputs.hasNextLine()) {
            String line = inputs.nextLine();
            calculator.process(line);
        }

        return String.format("Calculated priorities equal to : %d", calculator.getScore());
    }
}