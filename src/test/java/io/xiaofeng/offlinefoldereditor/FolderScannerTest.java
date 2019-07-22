package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class FolderScannerTest {
    @Test
    public void print() {
        Entry root = new FolderScanner().scan(Paths.get("D:", "test"));
        printEntry(root);
    }
    public void printEntry(Entry entry) {
        System.out.println(entry.getCurrent());
        List<Entry> entries = entry.getEntries();
        if (entries != null && entries.size() > 0) {
            entries.forEach(this::printEntry);
        }
    }
}
