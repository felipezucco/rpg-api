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
public class IntroduceLookAround$5 extends StageComponent {

    @Autowired
    StageContext stageContext;

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS,
                getMessageSource().getMessage("introduce.lookaround",
                        new String[]{getContext().getProfile().getName(), Actions.LOOK.name(), Actions.LOOK.getCode()},
                        Locale.getDefault()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        Actions action = getActions();
        if (action == Actions.LOOK) {
            stageContext.setCurrentStage(getBeanFactory().getBean(StartLore$5.class));
            callNextStage(StartLore$5.class);
            return;
        }

        callNextStage(this);
    }
}
