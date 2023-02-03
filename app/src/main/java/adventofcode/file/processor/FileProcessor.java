package adventofcode.file.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class FileProcessor {
    public static void process(String filePath, FileCommand command) throws Exception {
        Optional<Scanner> inputs = loadFile(filePath);

        if (inputs.isPresent()) {
            Scanner scanner = inputs.get();
            command.setLoadedFile(scanner);
            System.out.println(command.call());
            scanner.close();
        }
    }

    private static Optional<Scanner> loadFile(String filePath) {
        Optional<Scanner> result;
        try {
            File target = new File(filePath);
            Scanner scanner = new Scanner(target);
            result = Optional.of(scanner);
        } catch (FileNotFoundException e) {
            result = Optional.empty();
            System.out.printf("Could not find input file: %s", e.getMessage());
        }

        return result;
    }
}
