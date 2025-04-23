package com.embark.ChallengApp.services;

import com.embark.ChallengApp.Challenge;
import com.embark.ChallengApp.dao.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    //private List<Challenge> challenges = new ArrayList<>();
    private long nextId = 1L;
    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService() {
//        Challenge challenge1 = new Challenge(1L, "January", "Learn a new programming language");
//        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }


    public boolean addChhallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        } else {
            return false;
        }

    }

    public Challenge getChallenges(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
//        for(Challenge challenge:challenges){
//            if(challenge.getMonth().equalsIgnoreCase(month)){
//    return challenge;
//}
//}
        return challenge.orElse(null);
    }

    public boolean updateChallege(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
//        for(Challenge challenge:challenges){
//            if(challenge.getId() == id){
//    challenge.setMonth(updatedChallenge.getMonth());
//    challenge.setDescription(updatedChallenge.getDescription());
//                return true;
//            }
//            }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
        //return challenges.removeIf(challenge -> challenge.getId() == id);
    }
}
