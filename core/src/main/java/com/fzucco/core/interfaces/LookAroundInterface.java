package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public interface LookAroundInterface {

    @JsonIgnore
    List<LookAroundItemInterface> getLookAround();

    void environment(List<LookAroundItemInterface> lookAround);
}
