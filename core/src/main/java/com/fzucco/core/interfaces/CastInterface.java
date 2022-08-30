package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;

public interface CastInterface {

    @JsonValue
    String getName();
}
