package adventofcode.no.space.left;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Directory implements FileEntity {
    private final String name;
    List<FileEntity> content = new ArrayList<>();
    private Directory parent;

    Directory(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public void setParent(Directory directory) {
        this.parent = directory;
    }

    public void append(FileEntity file) {
        content.add(file);
        file.setParent(this);
    }

    @Override
    public int size() {
        return content.stream()
            .mapToInt(FileEntity::size)
            .reduce(0, Integer::sum);
    }

    public Directory changeDirectory(String targetName) throws RuntimeException {
        if (targetName.equals("/")) return getRoot();

        Optional<Directory> target = targetName.equals("..") ? getParent() : getFirstDirectoryNamedWith(targetName);
        if (target.isPresent()) return target.get();

        throw new RuntimeException(String.format("Directory not found \"%s\" in directory \"%s\"", targetName, name));
    }

    private Optional<Directory> getFirstDirectoryNamedWith(String targetName) {
        return content.stream()
            .filter(directory -> directory instanceof Directory)
            .map(Directory.class::cast)
            .filter(directory -> directory.name().equals(targetName))
            .findFirst();
    }

    public Optional<Directory> getParent() {
        return Optional.ofNullable(parent);
    }

    public Directory getRoot() {
        Optional<Directory> parent = getParent();

        return parent.isEmpty() ? this : parent.get().getRoot();
    }

    public void pass(DirectoryVisitor visitor) {
        visitor.handle(this);
        content.forEach(fileEntity -> fileEntity.pass(visitor));
    }
}
