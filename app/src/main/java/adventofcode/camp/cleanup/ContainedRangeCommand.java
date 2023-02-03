package adventofcode.camp.cleanup;

import adventofcode.file.processor.FileCommand;

import java.util.Scanner;

public class ContainedRangeCommand implements FileCommand {

    Scanner loadedFile;
    @Override
    public void setLoadedFile(Scanner loadedFile) {
        this.loadedFile = loadedFile;
    }

    @Override
    public String call() {
        ContainedRangeProcessor processor = new ContainedRangeProcessor();
        while (this.loadedFile.hasNextLine()) {
            processor.process(this.loadedFile.nextLine());
        }

        String contained = String.format("%d pairs have a fully contained range", processor.getContainedRangeNumber());
        String overlapping = String.format("%d pairs are overlapping.", processor.getOverlappingRangeNumber());

        return String.format("%s%n%s", contained, overlapping);
    }
}
