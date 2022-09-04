package com.fzucco.core.model;

import com.fzucco.core.interfaces.actions_interfaces.WearingItemInterface;
import com.fzucco.core.model.bag.Bag;
import lombok.Data;


@Data
public class Profile {

    private String name;
    private Bag bag;
    private WearingItemInterface wearing;

}
