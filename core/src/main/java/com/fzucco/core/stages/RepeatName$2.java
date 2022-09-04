package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.root.StageComponent;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class RepeatName$2 extends StageComponent {

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS,
                getMessageSource().getMessage("repeat.name", new String[]{getContext().getProfile().getName()}, Locale.getDefault()));
        return map;
    }

    @Override
    public Map<Actions, String> getInteraction() {
        Map<Actions, String> map = new HashMap<>();
        map.put(Actions.YES, MessageFormat.format("Type {0} ({1}) to accept your name.", Actions.YES.name(), Actions.YES.getCode()));
        map.put(Actions.NO, MessageFormat.format("Type {0} ({1}) to refuse and choice a new one.", Actions.NO.name(), Actions.NO.getCode()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        Actions actions = getActions();
        if (actions == null) {
            throw new Exception("You have typed incorrectly. Please try Again.");
        }

        if (actions == Actions.YES) {
            callNextStage(StartLore$3.class);
            return;
        }

        callNextStage(KnowName$1.class);
    }
}
