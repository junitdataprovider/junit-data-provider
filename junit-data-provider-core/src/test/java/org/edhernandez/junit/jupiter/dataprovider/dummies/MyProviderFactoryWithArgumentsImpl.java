package org.edhernandez.junit.jupiter.dataprovider.dummies;

import org.edhernandez.junit.jupiter.dataprovider.model.ProviderFactory;

public class MyProviderFactoryWithArgumentsImpl implements ProviderFactory<DummyProviderImpl> {

    public MyProviderFactoryWithArgumentsImpl(String arg) {

    }

    @Override
    public DummyProviderImpl createProvider() {
        return new DummyProviderImpl();
    }
}
