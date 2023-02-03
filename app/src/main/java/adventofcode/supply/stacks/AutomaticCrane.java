package adventofcode.supply.stacks;

import java.util.ArrayList;
import java.util.List;

public class AutomaticCrane implements Crane {

    protected final Cargo cargo;

    AutomaticCrane(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public String getModel() {
        return "9001";
    }

    public void move(MoveCommand command) {
        List<List<String>> load = cargo.getLoad();
        int startIndex = command.getStart() - 1;
        List<String> start = load.get(startIndex);

        int targetIndex = command.getTarget() - 1;
        List<String> destination = load.get(targetIndex);
        destination.addAll(getSelectedCrates(command, start));

        List<String> remnant = start.subList(0, start.size() - command.getQuantity());
        load.set(startIndex, new ArrayList<>(remnant));
    }

    protected List<String> getSelectedCrates(MoveCommand command, List<String> start) {
        return start.subList(start.size() - command.getQuantity(), start.size());
    }
}