package com.fullstack.assessment.Services;

import com.fullstack.assessment.Entities.OrganizationEntity;
import com.fullstack.assessment.Entities.TaskEntity;
import com.fullstack.assessment.Entities.UserEntity;
import com.fullstack.assessment.Repositories.OrganizationRepo;
import com.fullstack.assessment.Repositories.TaskRepo;
import com.fullstack.assessment.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;
    private final UserRepo userRepo;
    private final OrganizationRepo orgRepo;

    public TaskEntity createTask(TaskEntity task, Long userId, Long orgId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        OrganizationEntity org = orgRepo.findById(orgId)
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        task.setUser(user);
        task.setOrganization(org);

        return taskRepo.save(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepo.findAll();
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskEntity updateTask(Long id, TaskEntity updatedTask) {
        TaskEntity task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setUrgencyLevel(updatedTask.getUrgencyLevel());
        task.setStarts(updatedTask.getStarts());
        task.setEnds(updatedTask.getEnds());
        task.setStatus(updatedTask.getStatus());
        task.setRewardPoints(updatedTask.getRewardPoints());
        task.setRequiredSkills(updatedTask.getRequiredSkills());
        return taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}