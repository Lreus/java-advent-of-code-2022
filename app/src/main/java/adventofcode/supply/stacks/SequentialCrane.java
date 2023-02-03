package adventofcode.supply.stacks;

import java.util.Collections;
import java.util.List;

public class SequentialCrane  extends AutomaticCrane {
    SequentialCrane(Cargo cargo) {
        super(cargo);
    }

    @Override
    public String getModel() {
        return "9000";
    }

    @Override
    protected List<String> getSelectedCrates(MoveCommand command, List<String> start) {
        List<String> selection = super.getSelectedCrates(command, start);
        Collections.reverse(selection);

        return selection;
    }
}
