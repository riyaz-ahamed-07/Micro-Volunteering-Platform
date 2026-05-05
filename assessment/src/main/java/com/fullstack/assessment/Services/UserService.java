package com.fullstack.assessment.Services;

import com.fullstack.assessment.Entities.UserEntity;
import com.fullstack.assessment.Repositories.UserRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setPhone(updatedUser.getPhone());
        user.setGender(updatedUser.getGender());
        user.setLocation(updatedUser.getLocation());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setRewardPoints(updatedUser.getRewardPoints());
        user.setSkills(updatedUser.getSkills());
        user.setPastContributions(updatedUser.getPastContributions());
        user.setAvailability(updatedUser.getAvailability());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}