package org.bdshadow.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * FIX THIS SERVICE
 */
@Service
@RequiredArgsConstructor
public class MoneyService {

    private static final int HARDCODED_NUMBER_OF_CANDIDATES = 100;
    private final CandidateService candidateService;

    public int countMoney() throws ExecutionException, InterruptedException {
        int[] result = new int[1];
        CompletableFuture[] futures = new CompletableFuture[HARDCODED_NUMBER_OF_CANDIDATES];
        for (int i = 1; i <= HARDCODED_NUMBER_OF_CANDIDATES; i++) {
            futures[i - 1] = candidateService.getMoney(i).thenAccept(money -> result[0] += money);
        }
        CompletableFuture.allOf(futures).get();
        return result[0];
    }
}
