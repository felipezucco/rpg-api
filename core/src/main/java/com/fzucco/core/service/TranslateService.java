package com.fzucco.core.service;

import com.fzucco.core.enums.Actions;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class TranslateService {

    public static Optional<Actions> input(String input) {
        if (!Objects.isNull(input)) {
            return Arrays.stream(Actions.values())
                    .filter(action -> input.equalsIgnoreCase(action.name()) || input.equalsIgnoreCase(action.getCode()))
                    .findAny();
        }
        return Optional.empty();
    }

}
