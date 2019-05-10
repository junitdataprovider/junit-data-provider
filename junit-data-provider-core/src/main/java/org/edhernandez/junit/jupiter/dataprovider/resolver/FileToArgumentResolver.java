package org.edhernandez.junit.jupiter.dataprovider.resolver;

import org.edhernandez.junit.jupiter.dataprovider.provider.Argument;
import org.edhernandez.junit.jupiter.dataprovider.provider.Provider;
import org.edhernandez.junit.jupiter.dataprovider.service.ProviderService;
import org.edhernandez.junit.jupiter.dataprovider.utils.FileUtils;
import org.edhernandez.junit.jupiter.dataprovider.utils.ResourcesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileToArgumentResolver {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    Map<String, Provider> providerMap;

    public FileToArgumentResolver(ProviderService providerService) {
        providerMap = providerService.get();
    }

    public List<Argument> resolve(String filePath) {
        try {
            File file = ResourcesUtils.getFile(filePath);
            String extension = FileUtils.getFileExtension(file.getName());
            return providerMap.get(extension).provide(file);
        } catch (FileNotFoundException e) {
            logger.error("File not found!", e);
            return new ArrayList<>();
        }
    }

}
