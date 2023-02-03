package adventofcode.file.processor;

import java.util.Scanner;
import java.util.concurrent.Callable;

public interface FileCommand extends Callable<String> {
    void setLoadedFile(Scanner loadedFile);
}
