package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fzucco.core.enums.Actions;

public interface StageInterface
        extends StoryTellerInterface, ContextInterface, InteractionInterface, LookAroundInterface {
    void execute() throws Exception;

    @JsonIgnore
    Actions getActions();

    void setAction(Actions action);

    @JsonIgnore
    String getDynamicResponse();

    void setDynamicResponse(String input);

    @JsonIgnore
    StageInterface getNextStage();
}
