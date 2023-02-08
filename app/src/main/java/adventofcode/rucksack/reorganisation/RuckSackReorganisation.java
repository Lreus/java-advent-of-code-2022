package adventofcode.rucksack.reorganisation;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;

public class RuckSackReorganisation implements NamedCommand {

    @Override
    public String getName() {
        return "03-ruckSacks";
    }

    public String getTitle() {
        return """
            
            --- Day 3: Rucksack Reorganization ---
            https://adventofcode.com/2022/day/3
            
            """;
    }

    @Override
    public void run() {
        try {
            String filePath = String.format("fixtures%s03-rucksack-reorganisation-inputs.txt", File.separator);
            FileProcessor.process(filePath, new CalculatePrioritiesCommand());
            FileProcessor.process(filePath, new CalculateBadgesCommand());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
