package com.example.demo.controller;

import com.example.demo.model.SkillRequestNew;
import com.example.demo.service.SkillRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill-requests")
public class SkillRequestController {
    
    @Autowired
    private SkillRequestService skillRequestService;
    
    @PostMapping
    public ResponseEntity<SkillRequestNew> create(@RequestBody SkillRequestNew skillRequest) {
        SkillRequestNew created = skillRequestService.createRequest(skillRequest);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillRequestNew> get(@PathVariable Long id) {
        SkillRequestNew request = skillRequestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }
}