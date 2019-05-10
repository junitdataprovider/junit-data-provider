package org.edhernandez.junit.jupiter.dataprovider.interfaces;

import java.io.File;
import java.util.List;

public abstract class Provider<T extends Argument> {

    private String supportedFile;

    public Provider(String supportedFile) {
        this.supportedFile = supportedFile;
    }

    public abstract List<T> provide(File file);

    public String supports() {
        return supportedFile;
    }
}
