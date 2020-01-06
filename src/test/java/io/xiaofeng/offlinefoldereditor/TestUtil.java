package io.xiaofeng.offlinefoldereditor;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class TestUtil {
    @SneakyThrows
    public static Path prepareFolder(String prefix) {
        Path root = Files.createTempDirectory(prefix);
        Files.createTempFile(root, "first", ".txt");
        Path subFolder = Files.createTempDirectory(root, "sub folder");
        Files.createTempFile(subFolder, "second", ".txt");
        return root;
    }
}
