package adventofcode.rope.bridge;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;
import adventofcode.rucksack.reorganisation.CalculateBadgesCommand;
import adventofcode.rucksack.reorganisation.CalculatePrioritiesCommand;

import java.io.File;

public class RopeBridge implements NamedCommand {
    @Override
    public String getName() {
        return "09-ropeBridge";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 9: Rope Bridge ---
            https://adventofcode.com/2022/day/9
            
            """;
    }

    @Override
    public void run() {
        try {
            String filePath = String.format("fixtures%s09-rope-bridge-inputs.txt", File.separator);
            FileProcessor.process(filePath, new CalculateTailVisitedOnceCount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
