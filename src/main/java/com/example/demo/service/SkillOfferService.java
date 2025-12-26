package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer skillOffer);
    SkillOffer getOfferById(Long id);
    List<SkillOffer> getOffersByUser(Long userId);
}