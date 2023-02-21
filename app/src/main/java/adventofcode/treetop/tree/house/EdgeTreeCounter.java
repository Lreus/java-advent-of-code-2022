package adventofcode.treetop.tree.house;

import java.util.*;

public class EdgeTreeCounter {
    public Set<Tree> findVisible(List<Tree> treeLine) {
        HashSet<Tree> result = new HashSet<>();

        int currentHeight = -1;
        for (Tree tree : treeLine) {
            if (tree.getHeight() > currentHeight) {
                currentHeight = tree.getHeight();
                result.add(tree);
            }
        }

        return result;
    }

    public Set<Tree> findVisibleFromBothSide(List<Tree> treeLine) {
        List<Tree> temp = new ArrayList<>(treeLine);
        Set<Tree> allVisible = new HashSet<>(findVisible(temp));

        Collections.reverse(temp);
        allVisible.addAll(findVisible(temp));

        return allVisible;
    }
}
