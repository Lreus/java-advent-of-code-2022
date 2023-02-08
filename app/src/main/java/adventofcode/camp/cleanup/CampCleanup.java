package adventofcode.camp.cleanup;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;

public class CampCleanup implements NamedCommand {

    @Override
    public String getName() {
        return "04-campCleanup";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 4: Camp Cleanup ---
            https://adventofcode.com/2022/day/4
            
            """;
    }

    @Override
    public void run() {
        try {
            String filePath = String.format("fixtures%s04-camp-cleanup-inputs.txt", File.separator);
            FileProcessor.process(filePath, new ContainedRangeCommand());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
