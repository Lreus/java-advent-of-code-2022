package adventofcode.rucksack.reorganisation;

public class Splitter {
    public String[] split(String original) {
        String first = original.substring(0, original.length() / 2);
        String next = original.substring(original.length() / 2);

        return new String[] {first, next};
    }
}
