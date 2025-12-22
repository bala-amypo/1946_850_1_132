package com.example.demo.service;

import com.example.demo.model.SkillRequest;

import java.util.List;
import java.util.Optional;

public interface SkillRequestService {

    SkillRequest create(SkillRequest request);

    Optional<SkillRequest> get(Long id);

    List<SkillRequest> getAll();
}
