package org.edhernandez.junit.jupiter.dataprovider.provider;

import org.edhernandez.junit.jupiter.dataprovider.annotation.ArgumentSource;
import org.edhernandez.junit.jupiter.dataprovider.resolver.FileToArgumentResolver;
import org.edhernandez.junit.jupiter.dataprovider.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CustomArgumentProvider<T extends ArgumentSource> implements ArgumentsProvider, AnnotationConsumer<T> {

    String[] sources;
    private FileToArgumentResolver fileToArgumentResolver;

    @Override
    public void accept(T t) {
        sources = t.sources();
        fileToArgumentResolver = new FileToArgumentResolver(new ProviderServiceImpl());
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Arrays.stream(sources).map(fileToArgumentResolver::resolve).flatMap(List::stream).map(Arguments::of);
    }
}
