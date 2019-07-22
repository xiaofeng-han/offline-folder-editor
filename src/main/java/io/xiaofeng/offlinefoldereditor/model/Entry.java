package io.xiaofeng.offlinefoldereditor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Builder(builderMethodName = "entryBuilder")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
    private Path current;
    private boolean isFolder;
    @Builder.Default
    private List<Entry> entries = new ArrayList<>();

    public boolean isFolder() {
        return entries != null && entries.size() > 0;
    }
}
