package org.edhernandez.junit.jupiter.dataprovider.interfaces;

import java.util.List;

public abstract class Argument {

    private String name;

    public String getName() {
        return name;
    }

    public Argument setName(String name) {
        this.name = name;
        return this;
    }
}
