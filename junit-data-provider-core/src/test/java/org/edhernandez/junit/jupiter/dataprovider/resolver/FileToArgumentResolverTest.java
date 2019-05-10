package org.edhernandez.junit.jupiter.dataprovider.resolver;

import org.edhernandez.junit.jupiter.dataprovider.provider.Argument;
import org.edhernandez.junit.jupiter.dataprovider.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileToArgumentResolverTest {

    FileToArgumentResolver fileToArgumentResolver;

    @BeforeEach
    void setUp() {
        fileToArgumentResolver = new FileToArgumentResolver(new ProviderServiceImpl());
    }

    @Test
    void resolve_withValidFile_returnArgument() throws FileNotFoundException {
        List<Argument> arguments = fileToArgumentResolver.resolve("classpath:examples/firstExample.dmy");
        assertThat(arguments).isNotEmpty();
    }


    @Test
    void resolve_withInvalidFile_returnEmptyList() throws FileNotFoundException {
        List<Argument> arguments = fileToArgumentResolver.resolve("classpath:examples/firstExamp.dmy");
        assertThat(arguments).isEmpty();
    }

}
