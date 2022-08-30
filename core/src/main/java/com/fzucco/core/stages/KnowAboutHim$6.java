package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.model.bag.bag_items.Money;
import com.fzucco.core.model.stage.scenes.Wagon;
import com.fzucco.core.root.StageComponent;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Stage
public class KnowAboutHim$6 extends StageComponent {

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS, getMessageSource().getMessage("know.about.him.anonymous$1", null, Locale.getDefault()));
        return map;
    }

    @Override
    public Map<Actions, String> getInteraction() {
        Map<Actions, String> map = new HashMap<>();
        map.put(Actions.GO,
                MessageFormat
                        .format("Type {0} ({1}) to follow him.",
                                Actions.GO.name(), Actions.GO.getCode()));
        return map;
    }

    @Override
    public void execute() throws Exception {
        setLookAround(new Wagon(), new Money(23.4d));

        callNextStage(this);
    }
}
