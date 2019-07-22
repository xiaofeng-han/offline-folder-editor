package io.xiaofeng.offlinefoldereditor.snapshot;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class SnapshotDeployer {

    public void deploy(Path target, Entry root) {
        deploy(target, root.getEntries());
    }

    private void deploy(Path folder, List<Entry> entries) {
        if (!Files.exists(folder)) {
            try {
                Files.createDirectory(folder);
                log.info("deployed folder {}", folder);
            } catch (IOException e) {
                log.error("Create directory ({}) failed.", e.getMessage());
                return;
            }
        }

        if (CollectionUtils.isNotEmpty(entries)) {
            entries.forEach(entry -> {
                try {
                    if (entry.isFolder()) {
                        deploy(entry.getCurrent(), entry.getEntries());
                    } else {
                        Files.createFile(entry.getCurrent());
                        log.info("deployed file {}", entry.getCurrent());
                    }
                } catch (IOException e) {
                    log.error("Create file failed. folder={}, file={}", folder, entry.getCurrent());
                }
            });
        }

    }
}
