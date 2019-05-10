package org.edhernandez.junit.jupiter.dataprovider.model;

public interface ProviderFactory<T extends Provider> {

    T createProvider();
}
