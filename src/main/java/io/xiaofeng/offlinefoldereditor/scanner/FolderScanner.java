package io.xiaofeng.offlinefoldereditor.scanner;

import io.xiaofeng.offlinefoldereditor.model.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderScanner {
    public Entry scan(Path startPath) {
        Entry root = Entry.entryBuilder().current(startPath).build();
        try {
            Files.walkFileTree(startPath, ScanVisitor.builder().root(root).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
