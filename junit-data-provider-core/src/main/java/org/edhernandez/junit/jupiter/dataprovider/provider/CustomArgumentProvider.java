package org.edhernandez.junit.jupiter.dataprovider.provider;

import org.edhernandez.junit.jupiter.dataprovider.annotation.ArgumentSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public abstract class CustomArgumentProvider<T extends ArgumentSource> implements ArgumentsProvider, AnnotationConsumer<T> {

    String[] sources;

    @Override
    public void accept(T t) {
        sources = t.sources();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return null;
    }
}
