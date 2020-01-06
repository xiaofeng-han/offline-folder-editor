package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

public class FolderScannerTest {
    @Test
    public void print() {
        Path rootPath = TestUtil.prepareFolder("folderScannerTest");
        Entry root = new FolderScanner().scan(rootPath);
        printEntry(root);
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
