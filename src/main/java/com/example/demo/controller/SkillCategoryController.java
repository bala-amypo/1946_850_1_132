// package com.example.demo.controller;

// import com.example.demo.model.SkillCategory;
// import com.example.demo.repository.SkillCategoryRepository;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/categories")
// public class SkillCategoryController {

//     private final SkillCategoryRepository repository;

//     public SkillCategoryController(SkillCategoryRepository repository) {
//         this.repository = repository;
//     }

//     @PostMapping
//     public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
//         category.setId(null); // let DB generate ID
//         SkillCategory saved = repository.save(category);
//         return ResponseEntity.ok(saved);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
//         return ResponseEntity.of(repository.findById(id));
//     }

//     @GetMapping
//     public ResponseEntity<List<SkillCategory>> getAllCategories() {
//         return ResponseEntity.ok(repository.findAll());
//     }
// }
