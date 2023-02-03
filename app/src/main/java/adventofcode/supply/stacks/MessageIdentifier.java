package adventofcode.supply.stacks;

import java.util.regex.Pattern;

public class MessageIdentifier {

    public static final String AnyUpperCaseLetterEnclosedInSquareBrackets = "^(\\s*\\[[A-Z]\\])+\\s*$";
    public static final String MoveNumberFromIntegerToInteger = "^move \\d{1,2} from \\d to \\d$";

    public boolean isStackLine(String message) {
        return isMatching(message, AnyUpperCaseLetterEnclosedInSquareBrackets);
    }

    public boolean isMoveCommand(String message) {
        return isMatching(message, MoveNumberFromIntegerToInteger);
    }

    private boolean isMatching(String message, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(message).find();
    }
}
