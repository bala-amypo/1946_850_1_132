package com.example.demo.service.impl;

import com.example.demo.model.MatchRecord;
import com.example.demo.repository.MatchRecordRepository;
import com.example.demo.service.MatchmakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchmakingServiceImpl implements MatchmakingService {
    
    @Autowired
    private MatchRecordRepository repository;
    
    @Override
    public MatchRecord generateMatch(Long requestId) {
        MatchRecord match = new MatchRecord();
        match.setStatus("PENDING");
        return repository.save(match);
    }
    
    @Override
    public List<MatchRecord> getMatchesForUser(Long userId) {
        return repository.findAll();
    }
}
