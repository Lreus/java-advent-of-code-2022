package adventofcode.tuning.trouble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MarkerDetectorTest {

    private MarkerDetector detector;

    @BeforeEach
    void buildTestSubject() {
        detector = new MarkerDetector(4);
    }

    @Test
    void freshDetectorHasDetectedNoMarker() {
        assertFalse(detector.hasMarker());
    }

    @Test
    void freshDetectorStartsWithCharacterCountToZero() {
        assertEquals(0, detector.getStreamLength());
    }

    @Test
    void appendingCharacterIncreaseStream() {
        appendSuccessively("abc");

        assertEquals(3, detector.getStreamLength());
    }

    void appendSuccessively(String word) {
        for (Character c : word.toCharArray()) {
            detector.append(c);
        }
    }

    @Test
    void appendingCharacterIncreaseStreamReading() {
        appendSuccessively("abcd");

        assertEquals("abcd", detector.getReading());
    }

    @Test
    void exceedingMarkerLengthOnAppendRemovesTheFirstOne() {
        appendSuccessively("abcde");

        assertEquals("bcde", detector.getReading());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "abab", "abca", "abcc"})
    void duplicateCharacterDoesNotMakeAMarker(String word) {
        appendSuccessively(word);

        assertFalse(detector.hasMarker());
    }
}
