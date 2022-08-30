package com.fzucco.core.pipes;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.ShowAround;
import com.fzucco.core.context.ShowBag;
import com.fzucco.core.context.ShowMap;
import com.fzucco.core.interfaces.RPGInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Service
@RequestScope
@AllArgsConstructor
public class UIService extends ServiceComponent {

    private ShowBag showBag;
    private ShowMap showMap;
    private ShowAround showAround;

    @Override
    public void run(Context context, Map<String, Object> payload) throws Exception {
        RPGInterface rpgInterface = controlAction(context);

        if (rpgInterface != null) {
            setRender(rpgInterface);
            setTruncate(true);
        }
    }

    public RPGInterface controlAction(Context context) {
        if (context.getAction() != null) {
            switch (context.getAction()) {
                case BAG:
                    return showBag;
                case MAP:
                    return showMap;
                case LOOK:
                    return showAround;
                default:
                    return null;
            }
        }
        return null;
    }
}
