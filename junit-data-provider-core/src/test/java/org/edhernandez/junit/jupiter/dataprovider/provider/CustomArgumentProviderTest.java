package org.edhernandez.junit.jupiter.dataprovider.provider;

import org.edhernandez.junit.jupiter.dataprovider.annotation.ArgumentSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomArgumentProviderTest {

    CustomArgumentProvider customArgumentProvider = new CustomArgumentProvider();

    @Test
    void provideArguments_withValidFile_returnStreamOfArguments() {
        ArgumentSource argumentSource = new ArgumentSource() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return ArgumentSource.class;
            }

            @Override
            public String[] sources() {
                String[] strings = {"classpath:examples/firstExample.dmy"};
                return strings;
            }
        };
        customArgumentProvider.accept(argumentSource);
        Stream arguments = customArgumentProvider.provideArguments(null);
        assertThat(arguments).hasSize(1);
    }

    @Test
    void provideArguments_withInvalidFile_returnEmptyStream() {
        ArgumentSource argumentSource = new ArgumentSource() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return ArgumentSource.class;
            }

            @Override
            public String[] sources() {
                String[] strings = {"classpath:examples/firstExam.dmy"};
                return strings;
            }
        };
        customArgumentProvider.accept(argumentSource);
        Stream arguments = customArgumentProvider.provideArguments(null);
        assertThat(arguments).hasSize(0);
    }
}
