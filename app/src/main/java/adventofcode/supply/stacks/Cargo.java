package adventofcode.supply.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Cargo {

    private final List<List<String>> load;
    private final AutomaticCrane crane = new AutomaticCrane(this);

    public Cargo() {
        load = new ArrayList<>();
    }
    public int getStackNumber() {
        return load.size();
    }

    public void load(String crateLine) {
        adaptCargoLoad(crateLine.length());

        List<String> crateList = chunkCrateLine(crateLine);
        prependEachCrateToItsCargoStack(crateList);
    }

    private void adaptCargoLoad(int lineLength) {
        int requiredStacks = (lineLength + 1) / 4;
        while (load.size() < requiredStacks) {
            load.add(List.of());
        }
    }

    private static List<String> chunkCrateLine(String batchLine) {
        ArrayList<String> crateSymbol = new ArrayList<>();
        for (int beginning = 0; beginning < batchLine.length(); beginning += 4) {
            crateSymbol.add(batchLine.substring(beginning, beginning + 3));
        }

        return crateSymbol;
    }

    private void prependEachCrateToItsCargoStack(List<String> crateList) {
        IntStream.range(0, crateList.size())
                .forEach(index -> prependCrateToStack(crateList.get(index), index));
    }

    private void prependCrateToStack(String crateValue, int stackTargetIndex) {
        if (crateValue.isBlank()) return;

        List<String> newStack = new ArrayList<>();
        newStack.add(crateValue);
        newStack.addAll(load.get(stackTargetIndex));

        load.set(stackTargetIndex, newStack);
    }

    public List<List<String>> getStack() {
        return load;
    }

    public void printLoad() {
        OptionalInt largestList = load.stream().mapToInt(List::size).max();
        if (largestList.isPresent()) {
            buildReversedRange(largestList.getAsInt())
                    .forEach(this::printCrateLine)
            ;
        }
    }

    private static List<Integer> buildReversedRange(int maximumInclusive) {
        List<Integer> indexes = new ArrayList<>(IntStream.range(0, maximumInclusive + 1)
            .boxed()
            .toList()
        );
        Collections.reverse(indexes);

        return indexes;
    }

    private void printCrateLine(int offset) {
        String crateLine = load.stream().reduce(
            "",
            (line, stack) -> line.concat(extractCrateValueOrDefault(stack, offset)),
            String::concat
        );
        
        System.out.println(crateLine);
    }

    private static String extractCrateValueOrDefault(List<String> stack, int offset) {
        if (offset < stack.size()) {
            return stack.get(offset).concat(" ");
        }

        return "    ";
    }

    public String getTopCrates() {
        String topCrates = concatEveryTopCrateValue();

        String enclosingBrackets = "[\\[\\]]";
        return topCrates.replaceAll(enclosingBrackets, "");
    }

    private String concatEveryTopCrateValue() {
        return load.stream()
                .reduce("",
                        (subString, stack) -> subString.concat(stack.get(stack.size() - 1)),
                        String::concat
                );
    }

    public List<List<String>> getLoad() {
        return load;
    }
}
