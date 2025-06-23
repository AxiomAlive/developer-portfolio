package Div2;

import it.unimi.dsi.fastutil.BigArrays;
import it.unimi.dsi.fastutil.ints.IntArrays;
import it.unimi.dsi.fastutil.ints.IntBigArrays;
import it.unimi.dsi.fastutil.objects.ReferenceBigArrayBigList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.LongStream;

public class C {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.next());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var m = input.nextInt();

            var segments = new int[n][2];
            for (int i = 0; i < n; i++) {
                segments[i][0] = input.nextInt();
                segments[i][1] = input.nextInt();
            }


            var combinations = new ReferenceBigArrayBigList<int[][]>();
            var result = 0;
            var numberOfCombinations = Math.pow(2, n) - 1;
            var numberOfCoveredSegments = n;
//            for (int i = 0; i < numberOfCombinations; i++) {
//                var combination = IntBigArrays.newBigArray(m);
//                combinations.add(combination);
//                for (int j = 0; j < numberOfCoveredSegments; j++) {
//                    var segmentStart = segments[j][0] - 1;
//                    var segmentEnd = segments[j][1];
//                    var nextCombination = BigArrays.copy(combination);
////                    var nextCombination = new int[1][combination[0].length];
////                    nextCombination[0] = combination[0].clone();
//                    for (int k = segmentStart; k < segmentEnd; k++) {
//                        var value = BigArrays.get(nextCombination, k);
////                        System.out.println(combination.length);
////                        var nextCombination = new int[1][combination.length];
////                        for (int l = 0; l < nextCombination[0].length; l++) {
////                            nextCombination[i] = combination[0].clone();
////                        }
//                        BigArrays.set(nextCombination, k, value + 1);
//                    }
//                    combination = nextCombination;
//                }
//                combinations.set(i, combination);
//                numberOfCoveredSegments--;
//            }
            for (int i = 0; i < (1 << m); i++) {
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) > 0) {
                        System.out.println(Arrays.deepToString(combinations.get(j)));
                    }
                }
            }
            for (var array : combinations) {
                System.out.println(Arrays.deepToString(array));
            }
//            for (int i = 0; i < n; i++) {
////                    var segmentStartIndex = segments[j][0] - 1;
////                    var segmentEndIndex = segments[j][1] - 1;
//
//                for (int index = segments[i][0] - 1; index <= segments[i][1] - 1; index++) {
//                    var value = BigArrays.get(finalArray, index);
//                    BigArrays.set(finalArray, index, value + 1);
//                }
//            }
//            result = Arrays.stream(finalArray[0]).max().getAsInt() - Arrays.stream(finalArray[0]).min().getAsInt();
//            System.out.println(Arrays.deepToString(finalArray));
//            System.out.println(BigArrays.length(finalArray));
            System.out.println(result);
        }
    }
}
