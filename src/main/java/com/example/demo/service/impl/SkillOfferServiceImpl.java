package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {
    private final SkillOfferRepository offerRepository;
    public SkillOfferServiceImpl(SkillOfferRepository offerRepository, SkillCategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        if (offer.getSkillName().length() < 5) {
            throw new RuntimeException("Skill name must be at least 5 characters");
        }
        return offerRepository.save(offer);
    }

    @Override
    public SkillOffer getOffer(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return offerRepository.findBySkillCategoryId(categoryId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return offerRepository.findByAvailability("AVAILABLE");
    }

    @Override
    public List<SkillOffer> getAllOffers() {
        return offerRepository.findAll();
    }
}
