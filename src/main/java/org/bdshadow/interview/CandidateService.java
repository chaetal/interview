package org.bdshadow.interview;

import lombok.RequiredArgsConstructor;
import org.bdshadow.interview.jpa.Candidate;
import org.bdshadow.interview.jpa.CandidateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

/**
 * PLEASE, DO NOT CHANGE THIS SERVICE
 */
@RequiredArgsConstructor
@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Transactional
    public CompletableFuture<Integer> getMoney(Integer candidateId) {
        return CompletableFuture.supplyAsync(() -> {
            Candidate candidate = candidateRepository.findById(candidateId).get();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return candidate.getMoney();
        });
    }
}
