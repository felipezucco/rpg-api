package com.fzucco.core.pipes;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.StageInterface;
import com.fzucco.core.interfaces.actions_interfaces.DriveableItemInterface;
import com.fzucco.core.interfaces.actions_interfaces.GrabbableItemInterface;
import com.fzucco.core.interfaces.actions_interfaces.ReadableItemInterface;
import com.fzucco.core.model.bag.bag_items.BagItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequestScope
public class PreExecutionService extends ServiceComponent {

    @Override
    public void run(Context context, Map<String, Object> payload) throws Exception {
        Actions action = context.getAction();

        if (Actions.BACK.equals(action)) {
            StageContext stageContext = (StageContext) payload.get("stageContext");
            renderAndTruncate(stageContext.getCurrentStage());
        }

        if (Actions.GRAB.equals(action)) {
            StageContext stageContext = (StageContext) payload.get("stageContext");

            StageInterface currentStage = stageContext.getCurrentStage();
            List<LookAroundItemInterface> lookAround = currentStage.getLookAround();

            List<LookAroundItemInterface> grabbedItems = new ArrayList<>();
            lookAround.forEach(item -> {
                if (item instanceof GrabbableItemInterface) {
                    context.getProfile().getBag().add((BagItem) item);
                    grabbedItems.add(item);
                }
            });

            lookAround.removeAll(grabbedItems);
        }

        if (Actions.DRIVE.equals(action)) {
            StageContext stageContext = (StageContext) payload.get("stageContext");

            StageInterface currentStage = stageContext.getCurrentStage();
            List<LookAroundItemInterface> lookAround = currentStage.getLookAround();

            lookAround.forEach(item -> {
                if (item instanceof DriveableItemInterface) {
                    context.getProfile().setWearing((DriveableItemInterface) item);
                }
            });
        }

        if (Actions.TAKE.equals(action)) {
            StageContext stageContext = (StageContext) payload.get("stageContext");

            StageInterface currentStage = stageContext.getCurrentStage();
            List<LookAroundItemInterface> lookAround = currentStage.getLookAround();

            List<LookAroundItemInterface> grabbedItems = new ArrayList<>();
            lookAround.forEach(item -> {
                if (item instanceof ReadableItemInterface) {
                    context.getProfile().getBag().add((BagItem) item);
                    grabbedItems.add(item);
                }
            });

            lookAround.removeAll(grabbedItems);
        }
    }
}
