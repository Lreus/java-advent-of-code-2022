package adventofcode.no.space.left;

import java.util.Optional;

public class File implements FileEntity{
    private Directory parent;
    private final int size;
    private final String name;

    File(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setParent(Directory directory) {
        this.parent = directory;
    }

    @Override
    public Optional<Directory> getParent() {
        return Optional.of(parent);
    }

    @Override
    public void pass(DirectoryVisitor visitor) {}
}
