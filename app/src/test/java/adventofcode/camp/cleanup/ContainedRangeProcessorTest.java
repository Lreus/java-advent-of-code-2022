package adventofcode.camp.cleanup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainedRangeProcessorTest {
    @Test
    void testInitialCounter() {
        ContainedRangeProcessor processor = new ContainedRangeProcessor();
        assertEquals(0, processor.getContainedRangeNumber());
        assertEquals(0, processor.getOverlappingRangeNumber());
    }

    @Test
    void testContainedRangeAddsUpToScore() {
        ContainedRangeProcessor processor = new ContainedRangeProcessor();
        processor.process("2-8,6-8");
        assertEquals(1, processor.getContainedRangeNumber());
    }

    @Test
    void testOverlappingRangeAddsUpToScore() {
        ContainedRangeProcessor processor = new ContainedRangeProcessor();
        processor.process("2-8,6-10");
        assertEquals(1, processor.getOverlappingRangeNumber());
    }
}
