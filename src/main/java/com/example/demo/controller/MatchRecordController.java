package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchRecordController {

    private final MatchmakingService matchmakingService;

    public MatchRecordController(MatchmakingService matchmakingService) {
        this.matchmakingService = matchmakingService;
    }

    @PostMapping("/generate/{userId}")
    public ResponseEntity<MatchRecord> generate(@PathVariable Long userId) {
        return ResponseEntity.ok(matchmakingService.generateMatch(userId));
    }

    @PostMapping
    public ResponseEntity<MatchRecord> create(@RequestParam Long offerId,
                                              @RequestParam Long requestId) {
        MatchRecord match = matchmakingService.createMatch(offerId, requestId);
        return ResponseEntity.ok(match);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(matchmakingService.getMatchById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MatchRecord>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(matchmakingService.getMatchesForUser(userId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<MatchRecord> updateStatus(@PathVariable Long id,
                                                    @RequestParam String status) {
        MatchRecord m = matchmakingService.updateStatus(id, status);
        return ResponseEntity.ok(m);
    }
}
