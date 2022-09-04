package com.fzucco.core.stages;

import com.fzucco.core.annotations.Stage;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.model.bag.bag_items.Money;
import com.fzucco.core.model.stage.scenes.Wagon;
import com.fzucco.core.root.StageComponent;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Stage
public class KnowAboutHim$4 extends StageComponent {

    @PostConstruct
    private void postConstructor() {
        getLookAround().add(new Wagon());
        getLookAround().add(new Money(23.4d));
    }

    @Override
    public Map<CastEnum, String> getStoryTeller() {
        Map<CastEnum, String> map = new HashMap<>();
        map.put(CastEnum.ANONYMOUS, getMessageSource().getMessage("know.about.him.anonymous", null, Locale.getDefault()));
        return map;
    }

    @Override
    public Map<Actions, String> getInteraction() {
        Map<Actions, String> map = new HashMap<>();
        if (getContext().getProfile().getWearing() instanceof Wagon) {
            map.put(Actions.GO,
                    MessageFormat
                            .format("Type {0} ({1}) to follow him.",
                                    Actions.GO.name(), Actions.GO.getCode()));
        }
        return map;
    }

    @Override
    public void execute() throws Exception {
        if (getContext().getProfile().getWearing() instanceof Wagon && Actions.GO.equals(getActions())) {
            callNextStage(GettingHospital$5.class);
        } else {
            callNextStage(this);
        }
    }

    @Override
    public void environment(List<LookAroundItemInterface> lookAround) {
    }

}
