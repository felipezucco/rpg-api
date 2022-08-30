package com.fzucco.core.pipes;

import com.fzucco.core.interfaces.RPGInterface;

public abstract class ServiceComponent implements ServiceInterface {

    private boolean truncate;
    private RPGInterface render;

    @Override
    public void setTruncate(boolean truncate) {
        this.truncate = truncate;
    }

    @Override
    public boolean getTruncate() {
        return this.truncate;
    }

    @Override
    public void setRender(RPGInterface rpgInterface) {
        this.render = rpgInterface;
    }

    @Override
    public RPGInterface getRender() {
        return this.render;
    }
}
