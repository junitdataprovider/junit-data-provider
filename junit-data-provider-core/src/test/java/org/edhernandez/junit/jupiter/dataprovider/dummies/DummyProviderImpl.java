package org.edhernandez.junit.jupiter.dataprovider.dummies;

import org.edhernandez.junit.jupiter.dataprovider.provider.Argument;
import org.edhernandez.junit.jupiter.dataprovider.provider.Provider;

import java.lang.annotation.Annotation;
import java.util.List;

public class DummyProviderImpl implements Provider<Argument> {
    @Override
    public List<Argument> provide(String source) {
        return null;
    }

    @Override
    public String supports() {
        return "dmy";
    }

}
