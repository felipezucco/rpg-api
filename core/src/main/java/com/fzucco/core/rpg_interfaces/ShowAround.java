package com.fzucco.core.rpg_interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.RPGInterface;
import com.fzucco.core.root.ContextComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowAround extends ContextComponent implements RPGInterface {

    @Autowired
    StageContext stageContext;

    @JsonProperty("Around")
    public List<LookAroundItemInterface> getLookAround() {
        return stageContext.getCurrentStage().getLookAround();
    }
}
