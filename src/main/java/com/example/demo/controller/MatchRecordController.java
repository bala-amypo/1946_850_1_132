package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchRecordController {
    @Autowired private MatchmakingService service;

    @PostMapping("/generate/{id}")
    public ResponseEntity<MatchRecord> generate(@PathVariable Long id) {
        return ResponseEntity.ok(service.generateMatch(id));
    }
}