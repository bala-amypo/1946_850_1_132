package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {
    private final SkillCategoryRepository categoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public SkillCategory getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
