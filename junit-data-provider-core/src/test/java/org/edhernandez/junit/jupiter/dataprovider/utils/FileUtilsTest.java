package org.edhernandez.junit.jupiter.dataprovider.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileUtilsTest {

    @Test
    void getFileExtension_withValidNameWithExtension_returnExtension() {
        String extension = FileUtils.getFileExtension("dummy.dmy");
        assertThat(extension).isEqualTo("dmy");
    }

    @Test
    void getFileExtension_withoutExtension_returnEmptyString() {
        String extension = FileUtils.getFileExtension("dummy");
        assertThat(extension).isEqualTo("");
    }

    @Test
    void getFileExtension_withoutTwoPoints_returnLast() {
        String extension = FileUtils.getFileExtension("dummy.my.dmy");
        assertThat(extension).isEqualTo("dmy");
    }
}
