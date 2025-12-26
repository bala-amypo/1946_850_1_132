package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {

    public int calculateMatchScore(SkillOffer offer, SkillRequest request) {
        int score = 0;

        String offerSkillName = offer.getSkillName();
        String requestSkillName = request.getSkillName();
        if (offerSkillName != null && offerSkillName.equalsIgnoreCase(requestSkillName)) {
            score += 30;
        }

        String offerCategory = offer.getSkillCategory();
        String requestCategory = request.getSkillCategory();
        if (offerCategory != null && offerCategory.equalsIgnoreCase(requestCategory)) {
            score += 20;
        }

        String offerLevel = offer.getExperienceLevel();
        String requiredLevel = request.getRequiredLevel();
        if (offerLevel != null && requiredLevel != null) {
            if (offerLevel.equalsIgnoreCase(requiredLevel)) {
                score += 30;
            } else {
                score += 10;
            }
        }

        UserProfile offerUser = offer.getUser();
        if (offerUser != null && offerUser.getRating() != null) {
            double rating = offerUser.getRating();
            score += (int) (rating * 4);
        }

        if (score < 0) score = 0;
        if (score > 100) score = 100;
        return score;
    }
}
