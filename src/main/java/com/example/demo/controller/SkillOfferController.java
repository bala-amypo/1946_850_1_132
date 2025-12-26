package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class SkillOfferController {

    private final SkillOfferService skillOfferService;

    public SkillOfferController(SkillOfferService skillOfferService) {
        this.skillOfferService = skillOfferService;
    }

    @PostMapping
    public ResponseEntity<SkillOffer> create(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(skillOfferService.createOffer(offer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillOffer> update(@PathVariable Long id,
                                             @RequestBody SkillOffer offer) {
        return ResponseEntity.ok(skillOfferService.updateOffer(id, offer));
    }

    @GetMapping
    public ResponseEntity<List<SkillOffer>> list() {
        return ResponseEntity.ok(skillOfferService.getAllOffers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> get(@PathVariable Long id) {
        return ResponseEntity.ok(skillOfferService.getOfferById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillOffer>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillOfferService.getOffersByUser(userId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        skillOfferService.deactivateOffer(id);
        return ResponseEntity.ok().build();
    }
}
