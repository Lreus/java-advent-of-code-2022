package adventofcode.rucksack.reoganisation;

import adventofcode.rucksack.reorganisation.PriorityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PriorityMapperTest {

    private PriorityMapper mapper;
    @BeforeEach
    void beforeAll() {
        mapper = new PriorityMapper();
    }

    @Test
    void mappingLowerLetters() {
        ArrayList<Integer> results = mapEachChars("abcdefghijklmnopqrstuvwxyz");

        assertIterableEquals(getRange(1, 26), results);
    }

    @Test
    void mappingUpperLetters() {
        ArrayList<Integer> results = mapEachChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        assertIterableEquals(getRange(27, 52), results);
    }

    private ArrayList<Integer> mapEachChars(String chars) {
        ArrayList<Integer> result = new ArrayList<>();
        for (char letter : chars.toCharArray()) {
            result.add(mapper.getPriority(letter));
        }

        return result;
    }

    List<Integer> getRange(int includedStart, int includedEnd) {
        return IntStream.rangeClosed(includedStart, includedEnd)
            .boxed()
            .collect(Collectors.toList())
        ;
    }
}
