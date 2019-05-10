package org.edhernandez.junit.jupiter.dataprovider.service.impl;

import org.edhernandez.junit.jupiter.dataprovider.interfaces.Provider;
import org.edhernandez.junit.jupiter.dataprovider.interfaces.ProviderFactory;
import org.edhernandez.junit.jupiter.dataprovider.service.ProviderService;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ProviderServiceImpl implements ProviderService {
    private static final String MESSAGE_TEMPLATE = "%s need an public empty constructor";
    private final Logger logger = LoggerFactory.getLogger(ProviderService.class);
    private final Reflections reflections;

    public ProviderServiceImpl() {
        reflections = new Reflections();
    }

    @Override
    public Map<String, Provider> get() {
        Set<Class<? extends ProviderFactory>> providerFactories = reflections.getSubTypesOf(ProviderFactory.class);
        return providerFactories.stream().map(pf -> {
            try {
                return pf.newInstance().createProvider();
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error(String.format(MESSAGE_TEMPLATE, pf.getSimpleName()), e);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toMap(p -> p.supports(), p -> p));
    }
}
