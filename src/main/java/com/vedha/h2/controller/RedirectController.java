package com.vedha.h2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class RedirectController {

    @GetMapping(value = { "/" })
    public String redirectToSwagger() {

        return "redirect:/swagger-ui/index.html";
    }
}
