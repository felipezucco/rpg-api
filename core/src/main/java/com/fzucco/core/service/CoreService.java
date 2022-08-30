package com.fzucco.core.service;

import com.fzucco.core.context.*;
import com.fzucco.core.interfaces.GrabbableItemInterface;
import com.fzucco.core.interfaces.LookAroundItemInterface;
import com.fzucco.core.interfaces.StageInterface;
import com.fzucco.core.model.bag.bag_items.BagItem;
import com.fzucco.core.pipes.Pipeline;
import com.fzucco.core.pipes.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CoreService {

    private StageContext stageContext;
    private StageManager stageManager;
    private ShowBag showBag;
    private ShowMap showMap;
    private ShowAround showAround;
    private Context context;

    private Pipeline pipeline;
    private BeanFactory beanFactory;

    public void manager() throws Exception {
        Class<? extends ServiceInterface>[] pipes = pipeline.getPipes();
        List<? extends ServiceInterface> pipesList =
                Stream.of(pipes)
                        .map(aClass -> beanFactory.getBean(aClass))
                        .collect(Collectors.toUnmodifiableList());
        Iterator<? extends ServiceInterface> iterator = pipesList.iterator();

        Map<String, Object> map = new HashMap<>();
        map.put("stageContext", stageContext);
        while (iterator.hasNext()) {
            ServiceInterface service = iterator.next();
            service.run(context, map);

            if (!iterator.hasNext()) {
                service.setTruncate(true);
            }

            if (service.getTruncate()) {
                context.setBeingRendered(service.getRender());
                return;
            }
        }
    }

    private Boolean getGrabbableItem() {
        if (Objects.equals(context.getLastInput(), "gb-money")) {
            grabAction("money");
            return true;
        }
        return false;
    }

    private void grabAction(String name) {
        StageInterface currentStage = stageContext.getCurrentStage();
        List<LookAroundItemInterface> lookAround = currentStage.getLookAround();

        List<LookAroundItemInterface> grabbedItems = new ArrayList<>();
        lookAround.forEach(item -> {
            if (item instanceof GrabbableItemInterface && item.getName().equalsIgnoreCase(name)) {
                context.getBag().add((BagItem) item);
                grabbedItems.add(item);
            }
        });

        //lookAround.removeAll(grabbedItems);
    }
}
