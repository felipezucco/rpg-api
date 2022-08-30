package com.fzucco.core.pipes;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.interfaces.StageInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Service
@RequestScope
public class StageService extends ServiceComponent {

    @Override
    public void run(Context context, Map<String, Object> payload) throws Exception {
        StageContext stageContext = (StageContext) payload.get("stageContext");
        StageInterface currentStage = stageContext.getCurrentStage();

        currentStage.setAction(context.getAction());
        currentStage.setDynamicResponse(context.getLastInput());

        currentStage.execute();

        StageInterface nextStage = currentStage.getNextStage();

        stageContext.setCurrentStage(nextStage);
        setRender(stageContext.getCurrentStage());
    }
}
