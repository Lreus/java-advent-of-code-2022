package adventofcode.tuning.trouble;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;

public class TuningTrouble implements NamedCommand {
    @Override
    public String getName() {
        return "06-tuningTrouble";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 6: Tuning Trouble ---
            https://adventofcode.com/2022/day/6

            """;
    }

    @Override
    public void run() {
        String filePath = String.format("fixtures%s06-tuning-trouble-inputs.txt", File.separator);
        try {
            FileProcessor.process(filePath, new StreamParser());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
