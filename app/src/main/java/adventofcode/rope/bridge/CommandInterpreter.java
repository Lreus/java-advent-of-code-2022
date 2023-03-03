package adventofcode.rope.bridge;

import adventofcode.rope.bridge.position.calculator.CalculatorFactory;
import adventofcode.rope.bridge.position.calculator.NextPositionCalculator;

import java.util.stream.IntStream;

public class CommandInterpreter {
    private AbstractFollowableDecorator subject;

    CommandInterpreter(AbstractFollowableDecorator movable) {
        setSubject(movable);
    }

    public void setSubject(AbstractFollowableDecorator movable) {
        subject = movable;
    }

    public void run(String moveCommand) {
        String direction = moveCommand.substring(0, 1);

        moveStepByStep(
            CalculatorFactory.getCalculator(direction),
            parseMovementValueAsInteger(moveCommand)
        );
    }

    private static int parseMovementValueAsInteger(String moveCommand) {
        return Integer.parseInt(moveCommand.substring(2));
    }

    private void moveStepByStep(NextPositionCalculator calculator, int delta) {
        IntStream.range(0, delta).forEach(i -> subject.update(
                calculator.next(subject.getPosition())
        ));
    }
}
