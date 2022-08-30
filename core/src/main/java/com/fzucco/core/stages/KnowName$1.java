package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.root.StageComponent;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class KnowName$1 extends StageComponent {

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS, getMessageSource().getMessage("know.name", null, Locale.getDefault()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        String response = getDynamicResponse();
        if (response == null) {
            throw new Exception("asda");
        }

        getContext().getProfile().setName(response);
        callNextStage(RepeatName$2.class);
    }

}
