package com.fzucco.core.model.stage.scenes;

import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.actions_interfaces.DriveableItemInterface;
import com.fzucco.core.utils.ActionMap;

import java.util.Map;

import static com.fzucco.core.enums.CastEnum.ANONYMOUS;

public class Wagon implements LookAroundItemInterface, DriveableItemInterface {

    @Override
    public Map<Actions, String> getInteraction() {
        return ActionMap.builder()
                ._put(Actions.DRIVE);
    }

    @Override
    public String getName() {
        return "Wagon";
    }

    @Override
    public String getDescription() {
        return "A old and dirty wagon used by this " + ANONYMOUS.getName();
    }
}
