package org.bdshadow.interview;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bdshadow.interview.jpa.Candidate;
import org.bdshadow.interview.jpa.CandidateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    @Getter
    private AtomicInteger allMoney = new AtomicInteger(0);

    @Transactional
    public void countMoney() throws InterruptedException {
        List<Candidate> candidateList = candidateRepository.findAll();
        allMoney.set(0);

        for (int i = 0; i < candidateList.size(); i++) {
            int a = i;
            tpe.submit(() -> allMoney.addAndGet(candidateList.get(a).getMoney()));
        }
        tpe.awaitTermination(2, TimeUnit.SECONDS);
    }
}
