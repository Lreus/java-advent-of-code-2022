package adventofcode.rucksack.reorganisation;

public class PriorityMapper {
    public int getPriority(char character) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        int lowerPosition = alphabet.indexOf(character);
        if (isFound(lowerPosition)) {
            return lowerPosition + 1;
        }

        int upperPosition = alphabet.toUpperCase().indexOf(character);
        if (isFound(upperPosition)) {
            return upperPosition + 27;
        }

        return -1;
    }

    private boolean isFound(int position) {
        return position >= 0;
    }
}
