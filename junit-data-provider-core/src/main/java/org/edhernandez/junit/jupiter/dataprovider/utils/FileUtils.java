package org.edhernandez.junit.jupiter.dataprovider.utils;

import java.util.Optional;

public abstract class FileUtils {

    public static String getFileExtension(String filePath) {
        return Optional.ofNullable(filePath)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filePath.lastIndexOf(".") + 1))
                .orElse("");
    }
}
