package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-records")   // <-- different base path
public class MatchRecordController {

    @Autowired
    private MatchmakingService matchmakingService;

    // use a unique sub-path too
    @PostMapping("/generate/{userId}")
    public ResponseEntity<MatchRecord> generate(@PathVariable Long userId) {
        MatchRecord match = matchmakingService.generateMatch(userId);
        return ResponseEntity.ok(match);
    }
}
