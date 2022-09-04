package com.fzucco.core.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fzucco.core.model.bag.Bag;


public interface BagInterface extends ContextInterface {

    @JsonProperty("Bag")
    default Bag getBag() {
        return getContext().getProfile().getBag();
    }

}
