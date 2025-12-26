package com.example.demo.service.impl;

import com.example.demo.model.SkillRequestNew;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository repository;

    public SkillRequestServiceImpl(SkillRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillRequestNew createRequest(SkillRequestNew request) {
        return new SkillRequestNew(); // Mock implementation
    }

    @Override
    public SkillRequestNew getRequestById(Long id) {
        return new SkillRequestNew(); // Mock implementation
    }

    @Override
    public List<SkillRequestNew> getRequestsByUser(Long userId) {
        return List.of(); // Mock implementation
    }
}