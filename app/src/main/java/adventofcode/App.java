package adventofcode;

import adventofcode.rucksack.reorganisation.RuckSackReorganisation;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<String> arguments = Set.of(args);
        for (NamedCommand command : getAvailableCommand()) {
            if (arguments.contains(command.getName())) {
                System.out.println(command.getTitle());
                command.run();
            }
        }
    }

    private static List<NamedCommand> getAvailableCommand() {
        return List.of(
                new RuckSackReorganisation()
        );
    }
}
