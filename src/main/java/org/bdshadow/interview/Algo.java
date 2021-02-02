package org.bdshadow.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Algo {

    /**
     * 1) reads the numbers from input files (integers are guaranteed)
     * 2) sorts them all together
     * 3) removes all integers at even positions (0th, 2nd, 4th...)
     * @return the result iterable collection
     */
    public Iterable<Integer> sortAndRemoveAtEvenPosition(String... inputFileNames) throws FileNotFoundException {
        List<Integer> intList = readFilesAndSort(inputFileNames);

        Iterator<Integer> iterator = intList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (i % 2 == 0) {
                iterator.remove();
            }
            i++;
        }
        return intList;
    }

    /**
     * 1) reads the numbers from input files (integers are guaranteed)
     * 2) sorts them all together
     * @return the sum of integers at even positions
     */
    public Long sortAndGetSumAtEvenPosition(String... inputFileNames) throws FileNotFoundException {
        List<Integer> intList = readFilesAndSort(inputFileNames);

        long result = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (i % 2 == 0) {
                result += intList.get(i);
            }
        }
        return result;
    }

    private List<Integer> readFilesAndSort(String... fileNames) throws FileNotFoundException {
        List<Integer> intList = new ArrayList<>();
        for (String fileName : fileNames) {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                intList.add(a);
            }
            scanner.close();
        }
        Collections.sort(intList);
        return intList;
    }
}
