package adventofcode;

import adventofcode.camp.cleanup.CampCleanup;
import adventofcode.no.space.left.NoSpaceLeft;
import adventofcode.rucksack.reorganisation.RuckSackReorganisation;
import adventofcode.supply.stacks.SupplyStack;
import adventofcode.treetop.tree.house.TreetopTreeHouse;
import adventofcode.tuning.trouble.TuningTrouble;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<String> arguments = Set.of(args);

        runAnyCommandInArguments(arguments);

        if (arguments.contains("help")) {
            System.out.println("Use any of these arguments to display puzzle results: ");
            printAllCommandNames();
        }
    }

    private static void runAnyCommandInArguments(Set<String> arguments) {
        getAvailableCommand().stream()
                .filter(command -> arguments.contains(command.getName()))
                .forEach(App::runCommand);
    }

    private static List<NamedCommand> getAvailableCommand() {
        return List.of(
                new RuckSackReorganisation(),
                new CampCleanup(),
                new SupplyStack(),
                new TuningTrouble(),
                new NoSpaceLeft(),
                new TreetopTreeHouse()
        );
    }

    private static void runCommand(NamedCommand command) {
        System.out.println(command.getTitle());
        command.run();
    }

    private static void printAllCommandNames() {
        getAvailableCommand().stream()
            .map(NamedCommand::getName)
            .forEach(System.out::println);
    }
}
