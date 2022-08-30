package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fzucco.core.enums.CastEnum;

import java.util.Map;

public interface StoryTellerInterface extends RPGInterface {

    @JsonProperty("RPG")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Map<CastEnum, String> getStoryTeller();

}
