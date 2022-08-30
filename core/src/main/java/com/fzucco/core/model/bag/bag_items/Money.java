package com.fzucco.core.model.bag.bag_items;

import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.GrabbableItemInterface;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.utils.ActionMap;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Money extends BagItem implements LookAroundItemInterface, GrabbableItemInterface {

    public Money(Double quantity) {
        super(quantity);
    }

    @Override
    public String getName() {
        return "Money";
    }

    @Override
    public Map<Actions, String> getInteraction() {
        return ActionMap.builder()._put(Actions.GRAB);
    }

    @Override
    public String getDescription() {
        return "Money used to buy thing";
    }
}
