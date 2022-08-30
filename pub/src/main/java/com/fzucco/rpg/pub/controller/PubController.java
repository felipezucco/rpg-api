package com.fzucco.rpg.pub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubController {

    @GetMapping("/abc")
    public ResponseEntity<String> getPub() {
        return ResponseEntity.ok("Hello World Pub");
    }
}
