package org.edhernandez.junit.jupiter.dataprovider.interfaces;

public interface ProviderFactory<T extends Provider> {

    T createProvider();
}
