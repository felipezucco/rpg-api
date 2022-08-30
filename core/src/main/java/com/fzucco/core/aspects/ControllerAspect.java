package com.fzucco.core.aspects;

import com.fzucco.core.context.Context;
import com.fzucco.core.enums.Actions;
import com.fzucco.core.service.TranslateService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class ControllerAspect {

    @Autowired
    private Context context;

    @Before("execution(* com.fzucco.core..*.post(..))")
    public void beforePost(JoinPoint jp) {
        String input = (String) jp.getArgs()[0];

        Optional<Actions> optAction = TranslateService.input(input);
        context.setAction(optAction.orElse(null));
        context.setLastInput(input);
    }

}
