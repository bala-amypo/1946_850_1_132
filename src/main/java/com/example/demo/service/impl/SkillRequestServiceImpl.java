package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository skillRequestRepository;

    public SkillRequestServiceImpl(SkillRequestRepository skillRequestRepository) {
        this.skillRequestRepository = skillRequestRepository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return skillRequestRepository.save(request);
    }

    @Override
    public SkillRequest getRequestById(Long id) {
        return skillRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SkillRequest not found"));
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return skillRequestRepository.findByUserId(userId);
    }
}
