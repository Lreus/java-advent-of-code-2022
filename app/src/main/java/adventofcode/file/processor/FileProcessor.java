package adventofcode.file.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class FileProcessor {
    public static void process(String filePath, FileCommand command) throws Exception {
        Optional<Scanner> inputs = loadFile(filePath);
        if (inputs.isEmpty()) return;

        Scanner scanner = inputs.get();
        command.setLoadedFile(scanner);
        System.out.println(command.call());
        scanner.close();
    }

    private static Optional<Scanner> loadFile(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            return Optional.of(scanner);
        } catch (FileNotFoundException e) {
            System.out.printf("Could not find input file: %s", e.getMessage());

            return Optional.empty();
        }
    }
}
