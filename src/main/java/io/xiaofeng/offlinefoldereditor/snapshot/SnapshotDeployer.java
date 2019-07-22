package io.xiaofeng.offlinefoldereditor.snapshot;

import io.xiaofeng.offlinefoldereditor.model.Entry;

import java.nio.file.Path;

public class SnapshotDeployer {

    public void deploy(Path target, Entry root) {
        deploy(target, root, root.getCurrent());
    }

    private void deploy(Path target, Entry entry, Path entryParent) {
        Path currentPath = entry.getCurrent();

    }
}
