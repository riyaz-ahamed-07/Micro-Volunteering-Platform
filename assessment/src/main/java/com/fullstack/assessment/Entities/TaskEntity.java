package com.fullstack.assessment.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String urgency_level;
    private String starts;
    private String ends;
    private String status;
    private Integer reward_points;

    private List<String> required_skills;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="org_id")
    private OrganizationEntity organization;
}