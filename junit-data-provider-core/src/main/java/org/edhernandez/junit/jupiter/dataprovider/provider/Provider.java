package org.edhernandez.junit.jupiter.dataprovider.provider;

import java.util.List;

public interface Provider<T extends Argument> {

    List<T> provide(String source);

    String supports();
}
