package adventofcode.treetop.tree.house;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;

public class TreetopTreeHouse implements NamedCommand {
    @Override
    public String getName() {
        return "08-treetopTreeHouse";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 8: Treetop Tree House ---
            https://adventofcode.com/2022/day/8

            """;
    }

    @Override
    public void run() {
        String filePath = String.format("fixtures%s08-treetop-tree-house-inputs.txt", File.separator);
        try {
            FileProcessor.process(filePath, new ForestParser());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
