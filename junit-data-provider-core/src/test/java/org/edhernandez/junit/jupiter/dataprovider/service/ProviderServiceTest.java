package org.edhernandez.junit.jupiter.dataprovider.service;

import org.edhernandez.junit.jupiter.dataprovider.dummies.MyProviderFactoryImpl;
import org.edhernandez.junit.jupiter.dataprovider.dummies.MyProviderFactoryWithArgumentsImpl;
import org.edhernandez.junit.jupiter.dataprovider.dummies.MyProviderFactoryWithProtectedConstructorImpl;
import org.edhernandez.junit.jupiter.dataprovider.model.Provider;
import org.edhernandez.junit.jupiter.dataprovider.model.ProviderFactory;
import org.edhernandez.junit.jupiter.dataprovider.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProviderServiceTest {

    ProviderService providerService;
    Reflections mockReflections = mock(Reflections.class);

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        providerService = new ProviderServiceImpl();
        Field field = ProviderServiceImpl.class.getDeclaredField("reflections");
        field.setAccessible(true);
        field.set(providerService, mockReflections);
        field.setAccessible(false);
    }

    @Test
    void get_returnMapOfProviders() {
        when(mockReflections.getSubTypesOf(eq(ProviderFactory.class))).thenReturn(Sets.newSet(MyProviderFactoryImpl.class));
        Map<String, Provider> providers = providerService.get();
        String dummyFileExtension = "dmy";
        assertThat(providers).containsKey(dummyFileExtension);
        assertThat(providers.get(dummyFileExtension)).isNotNull();
    }

    @Test
    void get_withInstantiationException_returnEmptyMap() {
        when(mockReflections.getSubTypesOf(eq(ProviderFactory.class))).thenReturn(Sets.newSet(MyProviderFactoryWithArgumentsImpl.class));
        assertThat(providerService.get()).isEmpty();
    }

    @Test
    void get_withIllegalAccessException_returnEmptyMap() {
        when(mockReflections.getSubTypesOf(eq(ProviderFactory.class))).thenReturn(Sets.newSet(MyProviderFactoryWithProtectedConstructorImpl.class));
        assertThat(providerService.get()).isEmpty();
    }

}