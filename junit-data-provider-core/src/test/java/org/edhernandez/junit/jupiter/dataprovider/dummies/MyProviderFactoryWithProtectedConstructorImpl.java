package org.edhernandez.junit.jupiter.dataprovider.dummies;

import org.edhernandez.junit.jupiter.dataprovider.model.ProviderFactory;

public class MyProviderFactoryWithProtectedConstructorImpl implements ProviderFactory<DummyProviderImpl> {

    protected MyProviderFactoryWithProtectedConstructorImpl() {
    }

    @Override
    public DummyProviderImpl createProvider() {
        return new DummyProviderImpl();
    }
}
