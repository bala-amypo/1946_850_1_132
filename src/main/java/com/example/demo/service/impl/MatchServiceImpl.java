package com.example.demo.service.impl;

import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.User;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MatchService;
import com.example.demo.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository matchRepository;
    private final SkillOfferRepository offerRepository;
    private final SkillRequestRepository requestRepository;
    private final UserRepository userRepository;
    private final SkillMatchingEngine matchingEngine;

    public MatchServiceImpl(SkillMatchRepository matchRepository,
                            SkillOfferRepository offerRepository,
                            SkillRequestRepository requestRepository,
                            UserRepository userRepository,
                            SkillMatchingEngine matchingEngine) {
        this.matchRepository = matchRepository;
        this.offerRepository = offerRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.matchingEngine = matchingEngine;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = offerRepository.findById(offerId).orElse(null);
        SkillRequest request = requestRepository.findById(requestId).orElse(null);
        User admin = userRepository.findById(adminUserId).orElse(null);

        if (offer != null && request != null && admin != null
                && offer.getUser() != null
                && request.getUser() != null
                && !offer.getUser().getId().equals(request.getUser().getId())) {

            double matchScore = matchingEngine.calculateMatchScore(offer, request);

            SkillMatch match = new SkillMatch();
            match.setOffer(offer);
            match.setRequest(request);
            match.setMatchedBy(admin);
            match.setMatchStatus("PENDING");
            match.setMatchScore(matchScore);

            return matchRepository.save(match);
        }
        return null;
    }

    @Override
    public SkillMatch getMatch(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        if (match != null) {
            match.setMatchStatus(status);
            return matchRepository.save(match);
        }
        return null;
    }

    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return matchRepository.findByOfferId(offerId);
    }

    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return matchRepository.findByRequestId(requestId);
    }
}
