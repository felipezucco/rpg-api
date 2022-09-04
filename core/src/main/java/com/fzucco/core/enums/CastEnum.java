package com.fzucco.core.enums;

import com.fzucco.core.interfaces.CastInterface;

public enum CastEnum implements CastInterface {

    LORE("Lore"),
    ANONYMOUS("Anonymous Person"),
    NURSE("Nurse");

    private final String name;

    CastEnum(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
