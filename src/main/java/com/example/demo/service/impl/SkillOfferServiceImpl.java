package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {
    private final SkillOfferRepository offerRepository;
    
    public SkillOfferServiceImpl(SkillOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public SkillOffer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }
}