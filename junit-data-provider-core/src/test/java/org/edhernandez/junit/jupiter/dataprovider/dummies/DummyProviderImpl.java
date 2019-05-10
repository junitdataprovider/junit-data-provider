package org.edhernandez.junit.jupiter.dataprovider.dummies;

import com.google.common.collect.Lists;
import org.edhernandez.junit.jupiter.dataprovider.interfaces.Argument;
import org.edhernandez.junit.jupiter.dataprovider.interfaces.Provider;

import java.io.File;
import java.util.List;

public class DummyProviderImpl extends Provider<Argument> {
    public DummyProviderImpl() {
        super("dmy");
    }

    @Override
    public List<Argument> provide(File source) {
        return Lists.newArrayList(new Argument() {
        });
    }

}
