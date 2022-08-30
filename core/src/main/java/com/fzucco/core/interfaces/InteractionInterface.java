package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fzucco.core.enums.Actions;

import java.util.Map;

public interface InteractionInterface {

    @JsonProperty("Actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Map<Actions,String> getInteraction();

}
