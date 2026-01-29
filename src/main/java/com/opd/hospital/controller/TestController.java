package com.opd.hospital.controller;

import com.opd.hospital.model.*;
import com.opd.hospital.service.TokenService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TokenService service;

    public TestController(TokenService service) {
        this.service = service;
    }

    // CREATE TOKEN
    @PostMapping("/{type}")
    public String create(@PathVariable PatientType type) {
        return service.createToken(type);
    }

    // LIST TOKENS
    @GetMapping
    public List<Token> list() {
        return service.getTokens();
    }
}
