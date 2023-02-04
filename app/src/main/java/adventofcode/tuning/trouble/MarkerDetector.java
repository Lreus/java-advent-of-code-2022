package adventofcode.tuning.trouble;

import java.util.HashSet;

public class MarkerDetector {

    private final int markerLength;

    MarkerDetector(int markerLength) {
        this.markerLength = markerLength;
    }

    private int streamCount = 0;
    private String currentStream = "";

    public boolean hasMarker() {
        if (currentStream.length() < markerLength) return false;

        HashSet<Integer> characters = new HashSet<>();
        currentStream.chars().forEach(characters::add);

        return characters.size() == currentStream.length();
    }

    public int getStreamLength() {
        return streamCount;
    }

    public void append(char input) {
        streamCount++;
        currentStream = currentStream + input;
        if (currentStream.length() > markerLength) {
            currentStream = currentStream.substring(1);
        }
    }

    public String getReading() {
        return currentStream;
    }
}
