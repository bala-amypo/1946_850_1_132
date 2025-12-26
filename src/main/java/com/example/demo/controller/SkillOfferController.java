package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill-offers")
public class SkillOfferController {
    
    @Autowired
    private SkillOfferService skillOfferService;
    
    @PostMapping
    public ResponseEntity<SkillOffer> create(@RequestBody SkillOffer skillOffer) {
        SkillOffer created = skillOfferService.createOffer(skillOffer);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> get(@PathVariable Long id) {
        SkillOffer offer = skillOfferService.getOfferById(id);
        return ResponseEntity.ok(offer);
    }
}