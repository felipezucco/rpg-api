package com.fzucco.core.root;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fzucco.core.context.Context;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ContextComponent extends GenericComponent {

    @Autowired
    @JsonIgnore
    protected Context context;

}
