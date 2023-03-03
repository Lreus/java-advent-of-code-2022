package adventofcode.rope.bridge.position.calculator;

public class CalculatorFactory {
    public static NextPositionCalculator getCalculator(String direction) {
        return switch (direction) {
            case "R" -> new RightPositionCalculator();
            case "L" -> new LeftPositionCalculator();
            case "U" -> new UpPositionCalculator();
            case "D" -> new DownPositionCalculator();
            default -> new NullPositionCalculator();
        };
    }
}
