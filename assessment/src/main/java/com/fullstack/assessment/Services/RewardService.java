package com.fullstack.assessment.Services;

import com.fullstack.assessment.Entities.OrganizationEntity;
import com.fullstack.assessment.Entities.RewardEntity;
import com.fullstack.assessment.Entities.UserEntity;
import com.fullstack.assessment.Repositories.OrganizationRepo;
import com.fullstack.assessment.Repositories.RewardRepo;
import com.fullstack.assessment.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final RewardRepo rewardRepository;
    private final UserRepo userRepository;
    private final OrganizationRepo organizationRepository;

    public RewardEntity createReward(RewardEntity reward, Long userId, Long orgId) {
        UserEntity user = userRepository.findById(userId);
        OrganizationEntity org = organizationRepository.findById(orgId);
        reward.setUser(user);
        reward.setOrganization(org);
        return rewardRepository.save(reward);
    }

    public List<RewardEntity> getAllRewards() {
        return rewardRepository.findAll();
    }

    public RewardEntity getRewardById(Long id) {
        return rewardRepository.findById(id);
    }

    public List<RewardEntity> getRewardsByUser(Long userId) {
        return rewardRepository.findByUserId(userId);
    }

    public List<RewardEntity> getRewardsByOrganization(Long orgId) {
        return rewardRepository.findByOrganizationId(orgId);
    }

    public RewardEntity updateReward(Long id, RewardEntity updatedReward) {
        RewardEntity reward = getRewardById(id);
        reward.setName(updatedReward.getName());
        reward.setRewardPoints(updatedReward.getRewardPoints());
        reward.setType(updatedReward.getType());
        return rewardRepository.save(reward);
    }

    public void deleteReward(Long id) {
        rewardRepository.deleteById(id);
    }
}