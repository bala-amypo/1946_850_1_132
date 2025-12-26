package com.example.demo.service;

import com.example.demo.model.SkillRequestNew;
import java.util.List;

public interface SkillRequestService {
    SkillRequestNew createRequest(SkillRequestNew skillRequest);
    SkillRequestNew getRequestById(Long id);
    List<SkillRequestNew> getRequestsByUser(Long userId);
}