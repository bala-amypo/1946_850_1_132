package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestService {
    @Autowired private SkillRequestRepository repository;

    public SkillRequest createRequest(SkillRequest request) {
        return repository.save(request);
    }

    public SkillRequest getRequestById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    }
    
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return repository.findAll();
    }
}