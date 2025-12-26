package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchmakingService matchService;

    public MatchController(MatchmakingService matchService) {
        this.matchService = matchService;
    }

    // generate match for a given user (requester)
    @PostMapping("/generate/{userId}")
    public ResponseEntity<MatchRecord> generate(@PathVariable Long userId) {
        return ResponseEntity.ok(matchService.generateMatch(userId));
    }

    // list matches for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MatchRecord>> getForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(matchService.getMatchesForUser(userId));
    }
}
