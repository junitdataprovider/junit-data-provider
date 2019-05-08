package org.edhernandez.junit.jupiter.dataprovider.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import static org.junit.platform.commons.util.ClassLoaderUtils.getDefaultClassLoader;

public abstract class ResourcesUtils {

    private static final String CLASSPATH_PREFIX = "classpath:";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static File getFile(String resourceLocation) throws FileNotFoundException {
        ClassLoader classLoader = getDefaultClassLoader();
        URL urlFile = classLoader.getResource(getResouceLocation(resourceLocation));
        if (Objects.isNull(urlFile)) {
            throw new FileNotFoundException(resourceLocation + "cannot be resolved. File doesn't exists.");
        }
        try {
            return new File(urlFile.toURI().getSchemeSpecificPart());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getResouceLocation(String resourceLocation) {
        if (resourceLocation.startsWith(CLASSPATH_PREFIX)) {
            return resourceLocation.substring(CLASSPATH_PREFIX.length());
        }
        return resourceLocation;
    }


    //    public static File getFile(String resourceLocation) throws FileNotFoundException {
//        Assert.notNull(resourceLocation, "Resource location must not be null");
//        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)) {
//            String path = resourceLocation.substring(CLASSPATH_URL_PREFIX.length());
//            String description = "class path resource [" + path + "]";
//            ClassLoader cl = ClassUtils.getDefaultClassLoader();
//            URL url = (cl != null ? cl.getResource(path) : ClassLoader.getSystemResource(path));
//            if (url == null) {
//                throw new FileNotFoundException(description +
//                        " cannot be resolved to absolute file path because it does not exist");
//            }
//            return getFile(url, description);
//        }
//        try {
//            // try URL
//            return getFile(new URL(resourceLocation));
//        }
//        catch (MalformedURLException ex) {
//            // no URL -> treat as file path
//            return new File(resourceLocation);
//        }
//    }
//
}
