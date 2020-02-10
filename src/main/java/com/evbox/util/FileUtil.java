package com.evbox.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public final class FileUtil {

    private FileUtil() {
        // private constructor for util class
    }

    public static void deleteFolder(String folder) {
        Path folderPath = Paths.get(folder);
        FileUtils.deleteQuietly(folderPath.toFile());
    }

}
