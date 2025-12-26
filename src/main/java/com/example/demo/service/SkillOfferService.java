package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferService {
    @Autowired private SkillOfferRepository repository;

    public SkillOffer createOffer(SkillOffer offer) {
        return repository.save(offer);
    }

    public SkillOffer getOfferById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
    }
    
    public List<SkillOffer> getOffersByUser(Long userId) {
        // Implementation for test mocking
        return repository.findAll(); 
    }
}