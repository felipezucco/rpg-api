package com.fzucco.core.context;

import com.fzucco.core.interfaces.StageInterface;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Class used to control user's stages
 */

@Getter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StageContext {

    private StageInterface lastStage;
    private StageInterface currentStage;

    public void setCurrentStage(StageInterface currentStage) {
        this.lastStage = this.getCurrentStage();
        this.currentStage = currentStage;
    }

}
