package org.edhernandez.junit.jupiter.dataprovider.dummies;

import org.edhernandez.junit.jupiter.dataprovider.model.ProviderFactory;

public class MyProviderFactoryImpl implements ProviderFactory<DummyProviderImpl> {
    @Override
    public DummyProviderImpl createProvider() {
        return new DummyProviderImpl();
    }
}
