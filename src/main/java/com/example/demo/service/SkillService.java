package com.example.demo.service;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillService {
    @Autowired private SkillRepository repository;

    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        existing.setName(skill.getName());
        return repository.save(existing);
    }

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }
}