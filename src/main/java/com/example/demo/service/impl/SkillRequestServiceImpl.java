package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository repository;

    public SkillRequestServiceImpl(SkillRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillRequest create(SkillRequest request) {
        return repository.save(request);
    }

    @Override
    public Optional<SkillRequest> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SkillRequest> getAll() {
        return repository.findAll();
    }
}
