package com.fullstack.assessment.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String phone;
    private String gender;
    private String location;
    private String email;
    private String role;
    private Integer rewardPoints;

    @ElementCollection
    private List<String> skills = new ArrayList<>();

    @ElementCollection
    private List<String> pastContributions = new ArrayList<>();

    @ElementCollection
    private List<String> availability = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskEntity> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RewardEntity> rewards = new ArrayList<>();
}