package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import io.xiaofeng.offlinefoldereditor.snapshot.SnapshotDeployer;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class SnapshotDeployerTest {

    @Test
    void tryDeploy() {
        Entry root = new FolderScanner().scan(Paths.get("D:", "test"));
        new SnapshotDeployer().deploy(Paths.get("D:", "target"), root);

    }
}
