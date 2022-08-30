package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fzucco.core.model.WorldMap;

public interface WorldMapInterface extends ContextInterface {

    @JsonProperty("Map")
    default WorldMap getMap() {
        return getContext().getMap();
    }
}
