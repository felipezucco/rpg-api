package com.fzucco.core.model.bag.bag_items;

import com.fzucco.core.interfaces.BagItemInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BagItem implements BagItemInterface {

    private Double quantity;

    @Override
    public String getName() {
        return "BAGITEM";
    }

}
