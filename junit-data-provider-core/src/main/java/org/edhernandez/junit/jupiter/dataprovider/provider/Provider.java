package org.edhernandez.junit.jupiter.dataprovider.provider;

import java.io.File;
import java.util.List;

public interface Provider<T extends Argument> {

    List<T> provide(File file);

    String supports();
}
