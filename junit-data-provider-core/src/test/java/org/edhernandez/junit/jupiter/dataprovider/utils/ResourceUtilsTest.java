package org.edhernandez.junit.jupiter.dataprovider.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResourceUtilsTest {

    @Test
    void getFile_withFileInResource_returnFile() throws FileNotFoundException {
        String resourceLocation = "classpath:examples/firstExample.dmy";
        File file = ResourcesUtils.getFile(resourceLocation);
        boolean canRead = file.canRead();
        assertThat(canRead).isTrue();
    }

    @Test
    void getFile_withFileInResource_withoutClasspath_returnFile() throws FileNotFoundException {
        String resourceLocation = "examples/firstExample.dmy";
        File file = ResourcesUtils.getFile(resourceLocation);
        boolean canRead = file.canRead();
        assertThat(canRead).isTrue();
    }

    @Test
    void getFile_withInvalidFile_throwException() {
        String resourceLocation = "firstExample.dmy";
        assertThrows(FileNotFoundException.class, () -> {
            ResourcesUtils.getFile(resourceLocation);
        });
    }

    @Test
    void getFile_withInvalidUrlLocation_throwException() {
        String resourceLocation = "clazzpath:firstExample.dmy";
        assertThrows(FileNotFoundException.class, () -> {
            ResourcesUtils.getFile(resourceLocation);
        });
    }
}
