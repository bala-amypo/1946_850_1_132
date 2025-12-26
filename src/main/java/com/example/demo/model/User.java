// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     private String location;

//     @Column(nullable = false)
//     private String role;

//     @Column(nullable = false)
//     private Double rating;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() {
//         createdAt = LocalDateTime.now();
//         if (role == null) role = "USER";
//         if (rating == null) rating = 0.0;
//     }

//     // getters & setters ...

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getLocation() { return location; }
//     public void setLocation(String location) { this.location = location; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public Double getRating() { return rating; }
//     public void setRating(Double rating) { this.rating = rating; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }
