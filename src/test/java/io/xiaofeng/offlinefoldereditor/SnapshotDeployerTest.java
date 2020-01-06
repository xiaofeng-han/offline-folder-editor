package io.xiaofeng.offlinefoldereditor;

import io.xiaofeng.offlinefoldereditor.model.Entry;
import io.xiaofeng.offlinefoldereditor.scanner.FolderScanner;
import io.xiaofeng.offlinefoldereditor.snapshot.SnapshotDeployer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SnapshotDeployerTest {

    @Test
    @SneakyThrows
    public void tryDeploy() {
        Path rootPath = TestUtil.prepareFolder("SnapshotDeployerTest");
        Entry root = new FolderScanner().scan(rootPath);
        new SnapshotDeployer().deploy(Files.createTempDirectory("deploymentTarget"), root);
    }
}
