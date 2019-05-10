package org.edhernandez.junit.jupiter.dataprovider.jackson;


import org.edhernandez.junit.jupiter.dataprovider.interfaces.Provider;

import java.io.File;
import java.util.List;

public class JacksonProvider extends Provider<JsonArgument> {

    private static final String SUPPORTED_TYPE = "json";

    public JacksonProvider(String supportedFile) {
        super(SUPPORTED_TYPE);
    }

    @Override
    public List<JsonArgument> provide(File file) {
        return null;
    }

}
