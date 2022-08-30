package com.fzucco.core.controller;

import com.fzucco.core.context.Context;
import com.fzucco.core.context.StageContext;
import com.fzucco.core.interfaces.RPGInterface;
import com.fzucco.core.service.CoreService;
import com.fzucco.core.stages.Start$0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {

    @Autowired
    private CoreService coreService;
    @Autowired
    private StageContext stageContext;
    @Autowired
    private Context context;
    @Autowired
    private Start$0 start$0;

    @GetMapping(value = "/")
    public ResponseEntity<RPGInterface> startJourney() {
        stageContext.setCurrentStage(start$0);
        context.setBeingRendered(stageContext.getCurrentStage());
        return ResponseEntity.ok(stageContext.getCurrentStage());
    }

    @PostMapping(value = "/")
    public ResponseEntity<RPGInterface> post(@RequestBody(required = false) String input) throws Exception {
        coreService.manager();
        return ResponseEntity.ok(context.getBeingRendered());
    }

}
