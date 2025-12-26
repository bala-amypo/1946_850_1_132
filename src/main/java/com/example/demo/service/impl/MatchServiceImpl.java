package com.example.demo.service.impl;

import com.example.demo.model.MatchRecord;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.repository.MatchRecordRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.UserRepository;
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
    private final UserRepository userRepo;
    private final SkillMatchingEngine skillMatchingEngine;

    public MatchServiceImpl(SkillOfferRepository offerRepo,
                            SkillRequestRepository requestRepo,
                            MatchRecordRepository matchRepo,
                            UserRepository userRepo,
                            SkillMatchingEngine skillMatchingEngine) {
        this.offerRepo = offerRepo;
        this.requestRepo = requestRepo;
        this.matchRepo = matchRepo;
        this.userRepo = userRepo;
        this.skillMatchingEngine = skillMatchingEngine;
    }

    // userId here is the requester’s id (matches your interface)
    @Override
    public MatchRecord generateMatch(Long userId) {
        // get all requests for that user
        List<SkillRequest> requests = requestRepo.findByUserId(userId);
        if (requests.isEmpty()) {
            throw new RuntimeException("No requests for user");
        }
        SkillRequest request = requests.get(0); // simplest choice

        List<SkillOffer> offers = offerRepo.findAll();
        if (offers.isEmpty()) {
            throw new RuntimeException("No offers available");
        }

        SkillOffer bestOffer = offers.stream()
                .max(Comparator.comparingInt(o ->
                        skillMatchingEngine.calculateMatchScore(o, request)))
                .orElseThrow(() -> new RuntimeException("No suitable offer"));

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
