package org.bdshadow.interview;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class AlgoTest {

    @Test
    void sortAndRemoveAtEvenPositionTest() throws FileNotFoundException {
        List<Integer> expectedResult = getExpectedResult();

        Algo algo = new Algo();
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            Iterable<Integer> result = algo.sortAndRemoveAtEvenPosition("input1.txt", "input2.txt");
            assertEquals(expectedResult, result);
        });
    }

    @Test
    void sortAndGetSumAtEvenPositionTest() {
        Algo algo = new Algo();
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            Long result = algo.sortAndGetSumAtEvenPosition("input1.txt", "input2.txt");
            assertEquals(271891359677L, result);
        });
    }

    private List<Integer> getExpectedResult() throws FileNotFoundException {
        LinkedList<Integer> expectedResult = new LinkedList<>();
        Scanner scanner = new Scanner(new File("result.txt"));
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            expectedResult.add(a);
        }
        scanner.close();
        return expectedResult;
    }
}
