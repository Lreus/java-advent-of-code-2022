package adventofcode.supply.stacks;

public interface Crane {
    void move(MoveCommand command);

    Cargo getCargo();

    String getModel();
}
