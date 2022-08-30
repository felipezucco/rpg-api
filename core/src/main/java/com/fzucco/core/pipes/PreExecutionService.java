package com.fzucco.core.pipes;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.enums.Actions;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Service
@RequestScope
public class PreExecutionService extends ServiceComponent {

    @Override
    public void run(Context context, Map<String, Object> payload) throws Exception {
        Actions action = context.getAction();

        if (Actions.BACK.equals(action)) {
            StageContext stageContext = (StageContext) payload.get("stageContext");
            setRender(stageContext.getCurrentStage());
            setTruncate(true);
        }
    }
}
