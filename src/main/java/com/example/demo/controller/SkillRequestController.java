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

    @PutMapping("/{id}")
    public ResponseEntity<SkillRequest> update(@PathVariable Long id,
                                               @RequestBody SkillRequest request) {
        SkillRequest updated = skillRequestService.updateRequest(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<SkillRequest>> list() {
        return ResponseEntity.ok(skillRequestService.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> get(@PathVariable Long id) {
        return ResponseEntity.ok(skillRequestService.getRequestById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillRequest>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillRequestService.getRequestsByUser(userId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        skillRequestService.deactivateRequest(id);
        return ResponseEntity.ok().build();
    }
}
