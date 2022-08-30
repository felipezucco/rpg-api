package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.root.StageComponent;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class Start$0 extends StageComponent {

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS, getMessageSource().getMessage("start", null, Locale.getDefault()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        callNextStage(KnowName$1.class);
    }
}
