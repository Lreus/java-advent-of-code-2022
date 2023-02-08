package adventofcode.no.space.left;

import java.util.Optional;

public interface FileEntity {
    int size();
    String name();
    void setParent(Directory directory);
    Optional<Directory> getParent();
    void pass(DirectoryVisitor visitor);
}
