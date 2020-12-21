package org.bdshadow.interview;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bdshadow.interview.jpa.Candidate;
import org.bdshadow.interview.jpa.CandidateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    @Getter
    private int allMoney = 0;

    public void countMoney() throws InterruptedException {
        allMoney = 0;

        for (int i = 1; i <= 50; i++) {
            int id = i;
            tpe.submit(() -> this.addCandidateMoney(id));
        }
        tpe.awaitTermination(2, TimeUnit.SECONDS);
    }

    @Transactional
    public void addCandidateMoney(int id) {
        Candidate candidate = candidateRepository.findById(id).get();
        allMoney += candidate.getMoney();
    }
}
