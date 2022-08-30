package com.fzucco.core.context;

import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.RPGInterface;
import com.fzucco.core.model.Profile;
import com.fzucco.core.model.WorldMap;
import com.fzucco.core.model.bag.Bag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Context {

    @Autowired
    private Profile profile;
    @Autowired
    private Bag bag;
    @Autowired
    private WorldMap map;

    private RPGInterface beingRendered;
    private String lastInput;
    private Actions action;

}
