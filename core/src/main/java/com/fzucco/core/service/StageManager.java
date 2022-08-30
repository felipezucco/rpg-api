package com.fzucco.core.service;

import com.fzucco.core.enums.Actions;
import com.fzucco.core.interfaces.StageInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.fzucco.core.service.TranslateService.input;

@Service
@AllArgsConstructor
public class StageManager {

    public void doProcessStage(StageInterface stage, String input) throws Exception {
        Optional<Actions> optAction = input(input);
        optAction.ifPresent(stage::setAction);
        stage.setDynamicResponse(input);

        stage.execute();
    }

}
