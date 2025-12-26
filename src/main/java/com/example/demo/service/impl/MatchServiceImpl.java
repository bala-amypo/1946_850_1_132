package com.example.demo.service.impl;

import com.example.demo.model.MatchRecord;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.repository.MatchRecordRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.MatchmakingService;
import com.example.demo.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchmakingService {

    private final SkillOfferRepository offerRepo;
    private final SkillRequestRepository requestRepo;
    private final MatchRecordRepository matchRepo;
    private final UserProfileRepository userRepo;
    private final SkillMatchingEngine skillMatchingEngine;

    public MatchServiceImpl(SkillOfferRepository offerRepo,
                            SkillRequestRepository requestRepo,
                            MatchRecordRepository matchRepo,
                            UserProfileRepository userRepo,
                            SkillMatchingEngine skillMatchingEngine) {
        this.offerRepo = offerRepo;
        this.requestRepo = requestRepo;
        this.matchRepo = matchRepo;
        this.userRepo = userRepo;
        this.skillMatchingEngine = skillMatchingEngine;
    }

    @Override
    public MatchRecord generateMatch(Long requestId) {
        SkillRequest request = requestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        List<SkillOffer> offers = offerRepo.findAll();

        // choose the best offer using SkillMatchingEngine
        SkillOffer bestOffer = offers.stream()
                .max(Comparator.comparingInt(o -> skillMatchingEngine
                        .calculateMatchScore(o, request)))
                .orElseThrow(() -> new RuntimeException("No offers available"));

        MatchRecord match = new MatchRecord();
        match.setUserA(request.getUser());
        match.setUserB(bestOffer.getUser());
        match.setSkillOfferedByA(bestOffer.getSkill());
        match.setSkillOfferedByB(request.getSkill());
        match.setStatus("PENDING");

        return matchRepo.save(match);
    }

    @Override
    public List<MatchRecord> getMatchesForUser(Long userId) {
        return matchRepo.findByUserAIdOrUserBId(userId, userId);
    }
}
