package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    private final SkillRequestService skillRequestService;

    public SkillRequestController(SkillRequestService skillRequestService) {
        this.skillRequestService = skillRequestService;
    }

    @PostMapping
    public ResponseEntity<SkillRequest> create(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(skillRequestService.createRequest(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> get(@PathVariable Long id) {
        return ResponseEntity.ok(skillRequestService.getRequestById(id));
    }

    @GetMapping
    public ResponseEntity<List<SkillRequest>> list() {
        return ResponseEntity.ok(skillRequestService.getAllSkillRequests());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillRequest>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillRequestService.getRequestsByUser(userId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        SkillRequest r = skillRequestService.getRequestById(id);
        r.setActive(false);
        skillRequestService.createRequest(r);
        return ResponseEntity.ok().build();
    }
}
