package com.spring.example.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.spring.example.service.services.AboutService;

@RestController
@RequestMapping("/api/about")
public class AboutRestController {

    @Autowired
    private AboutService aboutService;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getText() {
        return aboutService.getText();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void updateText(@RequestBody String newText) {
        aboutService.updateText(newText);
    }
}
