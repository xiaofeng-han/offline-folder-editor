package io.xiaofeng.offlinefoldereditor.os;

import java.util.Locale;

public class OSDetector {
    private static final OperatingSystem currentOS;
    static {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if ((OS.contains("mac")) || (OS.contains("darwin"))) {
            currentOS = OperatingSystem.MacOS;
        } else if (OS.contains("win")) {
            currentOS = OperatingSystem.Windows;
        } else if (OS.contains("nux")) {
            currentOS = OperatingSystem.Linux;
        } else {
            currentOS = OperatingSystem.Other;
        }
    }
    public static OperatingSystem getCurrentOS() {
        return currentOS;
    }
}
