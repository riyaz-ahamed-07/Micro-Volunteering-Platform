package com.fullstack.assessment.Controllers;

import com.fullstack.assessment.Entities.RewardEntity;
import com.fullstack.assessment.Services.RewardService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping
    public RewardEntity createReward(@RequestBody RewardEntity reward,
                                     @RequestParam Long userId,
                                     @RequestParam Long orgId) {
        return rewardService.createReward(reward, userId, orgId);
    }

    @GetMapping
    public List<RewardEntity> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @GetMapping("/{id}")
    public RewardEntity getRewardById(@PathVariable Long id) {
        return rewardService.getRewardById(id);
    }

    @PutMapping("/{id}")
    public RewardEntity updateReward(@PathVariable Long id, @RequestBody RewardEntity reward) {
        return rewardService.updateReward(id, reward);
    }

    @DeleteMapping("/{id}")
    public String deleteReward(@PathVariable Long id) {
        rewardService.deleteReward(id);
        return "Reward deleted successfully";
    }
}