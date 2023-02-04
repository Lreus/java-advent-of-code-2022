package adventofcode.tuning.trouble;

import adventofcode.file.processor.FileCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamParser implements FileCommand {
    private Scanner scanner;

    @Override
    public void setLoadedFile(Scanner loadedFile) {
        scanner = loadedFile;
        scanner.useDelimiter("");
    }

    @Override
    public String call(){
        MarkerDetector packetDetector = new MarkerDetector(4);
        MarkerDetector messageDetector = new MarkerDetector(14);

        List<String> results = processUntilMarkersAreFound(packetDetector, messageDetector);

        return results.isEmpty() ? "No marker found" : String.join(System.lineSeparator(), results);
    }

    private List<String> processUntilMarkersAreFound(MarkerDetector packetDetector, MarkerDetector messageDetector) {
        while (scanner.hasNext()) {
            char next = scanner.next().charAt(0);

            if (!packetDetector.hasMarker()) packetDetector.append(next);
            if (!messageDetector.hasMarker()) messageDetector.append(next);
            if (packetDetector.hasMarker() && messageDetector.hasMarker()) break;
        }

        return gatherResults(packetDetector, messageDetector);
    }

    private List<String> gatherResults(MarkerDetector packetDetector, MarkerDetector messageDetector) {
        List<String> results = new ArrayList<>();
        appendDetectorResult(packetDetector, "Packet", results);
        appendDetectorResult(messageDetector, "Message", results);

        return results;
    }

    private void appendDetectorResult(MarkerDetector detector, String label, List<String> results) {
        if (!detector.hasMarker()) return;

        results.add(
            String.format("%s marker found after %d: \"%s\"", label, detector.getStreamLength(), detector.getReading())
        );
    }
}
