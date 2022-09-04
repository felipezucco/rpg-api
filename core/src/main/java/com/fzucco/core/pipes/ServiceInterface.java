package com.fzucco.core.pipes;

import com.fzucco.core.context.Context;
import com.fzucco.core.interfaces.RPGInterface;

import java.util.Map;

public interface ServiceInterface {

    void run(Context context, Map<String, Object> payload) throws Exception;

    void setTruncate(boolean truncate);

    boolean getTruncate();

    void setRender(RPGInterface rpgInterface);

    RPGInterface getRender();

    void renderAndTruncate(RPGInterface rpgInterface);
}
