package com.fzucco.core.root;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fzucco.core.context.Context;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.StageInterface;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@JsonPropertyOrder({"RPG", "Actions"})
public abstract class StageComponent extends ContextComponent implements StageInterface {

    private Actions action;
    private String dynamicResponse;
    private StageInterface nextStage;
    private List<LookAroundItemInterface> lookAround;

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    public Actions getActions() {
        return this.action;
    }

    @Override
    public void setDynamicResponse(String input) {
        this.dynamicResponse = input;
    }

    @Override
    public String getDynamicResponse() {
        return this.dynamicResponse;
    }

    @Override
    public Map<Actions, String> getInteraction() {
        return null;
    }

    @Override
    public List<LookAroundItemInterface> getLookAround() {
        return this.lookAround;
    }

    public void callNextStage(Class<? extends StageInterface> nextStage) {
        this.nextStage = getBeanFactory().getBean(nextStage);
    }

    public void callNextStage(StageInterface nextStage) {
        this.nextStage = nextStage;
    }

    public StageInterface getNextStage() {
        return nextStage;
    }

    public void setLookAround(LookAroundItemInterface... lookAround) {
        this.lookAround = List.of(lookAround);
    }
}
