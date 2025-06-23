package Div3.R895;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D {
    private static <T> void swap(T[] elements, int a, int b) {
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private static <T> void printArray(T[] elements, char delimiter) {
        String delimiterSpace = delimiter + " ";
        for(int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var x = input.nextInt();
            var y = input.nextInt();

            var permutationScore = 0;
            var xAndYMin = Math.min(x, y);
            var isXLessThanY = xAndYMin == x;

            if (x == y) {
                System.out.println(0);
                continue;
            }
            var repeatedNumbers = new ArrayList<Integer>();
            var permutationScoreSubtractionPart = IntStream.range(1, n + 1).map(i -> n - (i - 1)).boxed().collect(Collectors.toList());
            var permutationScoreAdditionPart = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
            if (!isXLessThanY) {
                for (int i = x, c = 1; i <= n; c++, i=c*x) {
                    for (int j = y, cc = 1; j <= x; cc++, j=cc*y) {
                        if (i != j) {
                            var indexOfTheLastPermutationScore = permutationScoreSubtractionPart.size() - 1;
                            var permutationScoreFromSubtractionPart = permutationScoreSubtractionPart.get(indexOfTheLastPermutationScore);
                            permutationScore -= permutationScoreFromSubtractionPart;
                            permutationScoreSubtractionPart.remove(indexOfTheLastPermutationScore);
                        } else {
                            repeatedNumbers.add(j);
                        }
                    }
                    if (!repeatedNumbers.contains(i)) {
                        var indexOfTheLastPermutationScore = permutationScoreSubtractionPart.size() - 1;
                        var permutationScoreFromAdditionPart = permutationScoreAdditionPart.get(indexOfTheLastPermutationScore);
                        permutationScore += permutationScoreFromAdditionPart;
                        permutationScoreAdditionPart.remove(indexOfTheLastPermutationScore);
                    } else {
                        permutationScoreAdditionPart.remove((Integer)i);
                        permutationScoreSubtractionPart.remove((Integer)i);
                    }
                }
            } else {
                for (int i = y, c = 1; i <= n; c++, i=c*y) {
                    for (int j = x, cc = 1; j <= y; cc++, j=cc*x) {
                        if (i != j) {
                            var indexOfTheLastPermutationScore = permutationScoreSubtractionPart.size() - 1;
                            var permutationScoreFromSubtractionPart = permutationScoreSubtractionPart.get(indexOfTheLastPermutationScore);
                            permutationScore -= permutationScoreFromSubtractionPart;
                            permutationScoreSubtractionPart.remove(indexOfTheLastPermutationScore);
                        } else {
                            repeatedNumbers.add(j);
                        }
                    }
                    if (!repeatedNumbers.contains(i)) {
                        var indexOfTheLastPermutationScore = permutationScoreSubtractionPart.size() - 1;
                        var permutationScoreFromAdditionPart = permutationScoreAdditionPart.get(indexOfTheLastPermutationScore);
                        permutationScore += permutationScoreFromAdditionPart;
                        permutationScoreAdditionPart.remove(indexOfTheLastPermutationScore);
                    } else {
                        permutationScoreAdditionPart.remove((Integer)i);
                        permutationScoreSubtractionPart.remove((Integer)i);
                    }
                }
            }

            System.out.println(permutationScore);
        }
    }
}
