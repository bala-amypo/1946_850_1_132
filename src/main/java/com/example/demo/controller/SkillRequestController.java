package com.example.demo.controller;

import com.example.demo.dto.CreateSkillRequestDto;
import com.example.demo.model.SkillCategory;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.User;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    private final SkillRequestService requestService;
    private final UserRepository userRepository;
    private final SkillCategoryRepository skillCategoryRepository;

    public SkillRequestController(SkillRequestService requestService,
                                  UserRepository userRepository,
                                  SkillCategoryRepository skillCategoryRepository) {
        this.requestService = requestService;
        this.userRepository = userRepository;
        this.skillCategoryRepository = skillCategoryRepository;
    }

    @PostMapping
    public ResponseEntity<SkillRequest> createRequest(@RequestBody CreateSkillRequestDto dto) {

        User user = userRepository.findById(dto.getUserId()).orElse(null);
        SkillCategory category = skillCategoryRepository.findById(dto.getSkillCategoryId()).orElse(null);

        if (user == null || category == null) {
            return ResponseEntity.badRequest().build();
        }

        SkillRequest request = new SkillRequest();
        request.setUser(user);
        request.setSkillCategory(category);
        request.setSkillName(dto.getSkillName());
        request.setRequiredLevel(dto.getRequiredLevel());
        request.setStatus("OPEN");

        SkillRequest created = requestService.create(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.of(requestService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<SkillRequest>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAll());
    }
}
