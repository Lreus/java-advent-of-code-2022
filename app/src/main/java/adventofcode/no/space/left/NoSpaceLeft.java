package adventofcode.no.space.left;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;

public class NoSpaceLeft implements NamedCommand {
    @Override
    public String getName() {
        return "07-noSpaceLeft";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 7: No Space Left On Device ---
            https://adventofcode.com/2022/day/6
            
            """;
    }

    @Override
    public void run() {
        String filePath = String.format("fixtures%s07-no-space-left-inputs.txt", File.separator);
        try {
            FileProcessor.process(filePath, new SpaceAnalyzerCommand());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
