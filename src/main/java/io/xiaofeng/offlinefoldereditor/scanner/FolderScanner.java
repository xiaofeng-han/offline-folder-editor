package io.xiaofeng.offlinefoldereditor.scanner;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderScanner {
    @SneakyThrows
    public Entry scan(Path startPath) {
        Entry root = Entry.entryBuilder().current(startPath).build();
        Files.walkFileTree(startPath, ScanVisitor.builder().root(root).build());
        return root;
    }
}
