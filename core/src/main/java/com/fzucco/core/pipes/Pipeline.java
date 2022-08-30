package com.fzucco.core.pipes;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pipeline {

    private Class<? extends ServiceInterface>[] pipes;

    public void setPipes(Class<? extends ServiceInterface>... services) {
        this.pipes = services;
    }

}
