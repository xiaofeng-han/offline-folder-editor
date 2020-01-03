package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FolderScannerTest {
    @Test
    public void print() {
        Path rootPath = prepareFolder();
        Entry root = new FolderScanner().scan(rootPath);
        printEntry(root);
    }

    @SneakyThrows
    private Path prepareFolder() {
        Path root = Files.createTempDirectory("temp");
        Files.createTempFile(root, "first", ".txt");
        Path subFolder = Files.createTempDirectory(root, "sub folder");
        Files.createTempFile(subFolder, "second", ".txt");
        return root;
    }
    void printEntry(Entry entry) {
        System.out.println(entry.getCurrent() + ":(" + entry.isFolder() + ")");
        List<Entry> entries = entry.getEntries();
        if (entries != null && entries.size() > 0) {
            System.out.println("Under " + entry.getCurrent());
            entries.forEach(this::printEntry);
        }
    }
}
