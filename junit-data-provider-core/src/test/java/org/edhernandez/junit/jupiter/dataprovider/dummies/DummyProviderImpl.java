package org.edhernandez.junit.jupiter.dataprovider.dummies;

import com.google.common.collect.Lists;
import org.edhernandez.junit.jupiter.dataprovider.provider.Argument;
import org.edhernandez.junit.jupiter.dataprovider.provider.Provider;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.List;

public class DummyProviderImpl implements Provider<Argument> {
    @Override
    public List<Argument> provide(File source) {
        return Lists.newArrayList(new Argument() {
        });
    }

    @Override
    public String supports() {
        return "dmy";
    }

}
