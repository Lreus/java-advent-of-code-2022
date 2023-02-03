package adventofcode.supply.stacks;

public class MoveCommand {
    private final int quantity;
    private final int start;
    private final int target;
    public MoveCommand(String s) {
        this.quantity = extractQuantity(s);
        this.start = extractStartingValue(s);
        this.target = extractTargetValue(s);
    }

    private static int extractQuantity(String s) {
        String quantity = s.replace("move ", "")
                .replaceAll("\\s+from \\d to \\d", "");

        return Integer.parseInt(quantity);
    }

    private static int extractStartingValue(String s) {
        String start = s.replaceAll("move \\d{1,2} from ", "")
                .replaceAll("\\s+to \\d", "");

        return Integer.parseInt(start);
    }

    private static int extractTargetValue(String s) {
        String target = s.replaceAll("move \\d{1,2} from \\d to ", "");

        return Integer.parseInt(target);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStart() {
        return start;
    }

    public int getTarget() {
        return target;
    }
}
