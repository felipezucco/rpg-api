package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fzucco.core.context.Context;

public interface ContextInterface {

    @JsonIgnore
    Context getContext();

}
