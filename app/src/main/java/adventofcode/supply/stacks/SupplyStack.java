package adventofcode.supply.stacks;

import adventofcode.NamedCommand;
import adventofcode.file.processor.FileProcessor;

import java.io.File;
import java.util.List;

public class SupplyStack implements NamedCommand {

    @Override
    public String getName() {
        return "05-supplyStack";
    }

    @Override
    public String getTitle() {
        return """
            
            --- Day 5: Supply Stacks ---
            https://adventofcode.com/2022/day/5
            
            """;
    }

    @Override
    public void run() {
        try {
            String filePath = String.format("fixtures%s05-supply-stacks-inputs.txt", File.separator);
            List<Crane> cranes = List.of(new SequentialCrane(new Cargo()), new AutomaticCrane(new Cargo()));

            for (Crane crane : cranes) {
                FileProcessor.process(filePath, new LoadAndArrange(crane));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
