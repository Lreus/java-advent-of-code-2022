package adventofcode.rucksack.reorganisation;

import java.util.Arrays;

public class StringComparator {
    public char findMatch(String ...words) {
        String first = words[0];
        String[] others = Arrays.copyOfRange(words, 1, words.length);

        for (char c : first.toCharArray()) {
            String singleLetter = Character.toString(c);
            if (isContainedInAll(singleLetter, others)) {
                return singleLetter.charAt(0);
            }
        }

        return '0';
    }

    private boolean isContainedInAll(String s, String[] others) {
        for (String comparison : others) {
            if (!comparison.contains(s)) {
                return false;
            }
        }

        return true;
    }
}
