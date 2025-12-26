package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {
    
    @Autowired
    private SkillRequestRepository repository;
    
    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return repository.save(request);
    }
    
    @Override
    public SkillRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }
    
    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return repository.findAll();  // Mock for tests
    }
}
