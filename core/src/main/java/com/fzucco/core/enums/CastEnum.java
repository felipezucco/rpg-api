package com.fzucco.core.enums;

import com.fzucco.core.interfaces.CastInterface;

public enum CastEnum implements CastInterface {

    ANONYMOUS("Anonymous Person");

    private String name;

    CastEnum(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
