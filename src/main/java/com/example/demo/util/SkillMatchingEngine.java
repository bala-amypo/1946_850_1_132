package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.UserProfile;

public class SkillMatchingEngine {

    /**
     * Returns a score between 0 and 100 indicating how well the offer matches the request.
     */
    public static int calculateMatchScore(SkillOffer offer, SkillRequest request) {
        int score = 0;

        // 1) Skill name match
        String offerSkillName = offer.getSkillName();
        String requestSkillName = request.getSkillName();
        if (offerSkillName != null && offerSkillName.equalsIgnoreCase(requestSkillName)) {
            score += 30;
        }

        // 2) Skill category match
        String offerCategory = offer.getSkillCategory();
        String requestCategory = request.getSkillCategory();
        if (offerCategory != null && offerCategory.equalsIgnoreCase(requestCategory)) {
            score += 20;
        }

        // 3) Experience / required level match
        String offerLevel = offer.getExperienceLevel();
        String requiredLevel = request.getRequiredLevel();
        if (offerLevel != null && requiredLevel != null) {
            if (offerLevel.equalsIgnoreCase(requiredLevel)) {
                score += 30;
            } else {
                // partial match
                score += 10;
            }
        }

        // 4) User rating influence
        UserProfile offerUser = offer.getUser();
        if (offerUser != null && offerUser.getRating() != null) {
            double rating = offerUser.getRating(); // 0.0 – 5.0
            score += (int) (rating * 4); // up to +20
        }

        // clamp between 0 and 100
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        return score;
    }
}
