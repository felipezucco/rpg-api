package com.fzucco.core.service;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.pipes.Pipeline;
import com.fzucco.core.pipes.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CoreService {

    private StageContext stageContext;
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

}
