package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.root.StageComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class IntroduceMap$4 extends StageComponent {

    @Autowired
    StageContext stageContext;

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS,
                getMessageSource().getMessage("introduce.map",
                        new String[]{getContext().getProfile().getName(), Actions.MAP.name(), Actions.MAP.getCode()},
                        Locale.getDefault()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        Actions action = getActions();
        if (action == Actions.MAP) {
            stageContext.setCurrentStage(getBeanFactory().getBean(IntroduceLookAround$5.class));
            return;
        }

        callNextStage(this);
    }
}
