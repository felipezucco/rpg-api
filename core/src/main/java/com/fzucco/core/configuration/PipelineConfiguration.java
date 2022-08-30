package com.fzucco.core.configuration;

import com.fzucco.core.pipes.Pipeline;
import com.fzucco.core.pipes.PreExecutionService;
import com.fzucco.core.pipes.StageService;
import com.fzucco.core.pipes.UIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelineConfiguration {

    @Bean
    public Pipeline getPipeline(Pipeline pipeline) {
        pipeline.setPipes(PreExecutionService.class, UIService.class, StageService.class);
        return pipeline;
    }

}
