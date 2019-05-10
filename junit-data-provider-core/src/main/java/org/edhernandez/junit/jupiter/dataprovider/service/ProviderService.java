package org.edhernandez.junit.jupiter.dataprovider.service;

import org.edhernandez.junit.jupiter.dataprovider.model.Provider;

import java.util.Map;

public interface ProviderService {

    Map<String, Provider> get();

}
