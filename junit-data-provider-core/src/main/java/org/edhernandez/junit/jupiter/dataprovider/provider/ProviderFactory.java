package org.edhernandez.junit.jupiter.dataprovider.provider;

public interface ProviderFactory<T extends Provider> {

    T createProvider();
}
