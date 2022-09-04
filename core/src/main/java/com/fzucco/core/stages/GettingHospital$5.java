package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.model.bag.Bag;
import com.fzucco.core.model.bag.bag_items.Letter$4;
import com.fzucco.core.root.StageComponent;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class GettingHospital$5 extends StageComponent {

    @PostConstruct
    private void postConstructor() {
        getLookAround().add(new Letter$4(1d));
    }

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.NURSE, getMessageSource().getMessage("getting.hospital", null, Locale.getDefault()));
        return map;
    }

    @Override
    public Map<Actions, String> getInteraction() {
        Map<Actions, String> map = new HashMap<>();
        if (!hasTookLetter()) {
            map.put(Actions.TAKE, Actions.TAKE.getDescription());
        }
        return map;
    }

    @Override
    public void execute() throws Exception {
        callNextStage(this);
    }

    private boolean hasTookLetter() {
        Bag bag = getContext().getProfile().getBag();
        return bag.stream().anyMatch(item -> item instanceof Letter$4);
    }

}
