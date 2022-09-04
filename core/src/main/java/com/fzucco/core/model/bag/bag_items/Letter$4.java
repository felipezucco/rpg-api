package com.fzucco.core.model.bag.bag_items;

import com.fzucco.core.enums.Actions;
import com.fzucco.core.enums.CastEnum;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.actions_interfaces.ReadableItemInterface;
import com.fzucco.core.utils.ActionMap;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Letter$4 extends BagItem implements LookAroundItemInterface, ReadableItemInterface {

    public Letter$4(Double quantity) {
        super(quantity);
    }

    @Override
    public String getName() {
        return "Letter from " + CastEnum.ANONYMOUS.getName();
    }

    @Override
    public Map<Actions, String> getInteraction() {
        return ActionMap.builder()._put(Actions.READ);
    }

    @Override
    public String getDescription() {
        return "Letter gived to you by that stranger man.";
    }
}
