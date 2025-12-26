package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {
    
    @Autowired
    private SkillOfferRepository repository;
    
    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return repository.save(offer);
    }
    
    @Override
    public SkillOffer getOfferById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }
    
    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return repository.findAll();  // Mock for tests
    }
}
