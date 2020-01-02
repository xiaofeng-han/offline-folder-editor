package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

class FolderScannerTest {
    @Test
    void print() {
        Entry root = new FolderScanner().scan(Paths.get("E:\\dev\\temp\\folder"));
        printEntry(root);
    }
    void printEntry(Entry entry) {
        System.out.println(entry.getCurrent() + ":(" + entry.isFolder() + ")");
        List<Entry> entries = entry.getEntries();
        if (entries != null && entries.size() > 0) {
            entries.forEach(this::printEntry);
        }
    }
}
