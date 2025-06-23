package Div4.R871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class G {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();
        var dp = new ArrayList<List<Set<Long>>>(2023);

        for (int i = 0; i < 2023; i++) {
            var row = new ArrayList<Set<Long>>(2023);
            for (int j = 0; j < 2023; j++) {
                row.add(new HashSet<>());
            }
            dp.add(row);
        }

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();

            var maxRowLength = 1;
            int maxRightMostRowNumber = 1;

            while(true) {
                maxRowLength++;

                maxRightMostRowNumber += maxRowLength;
                if (maxRightMostRowNumber >= n) break;

            }

            var indexOfN = maxRightMostRowNumber - n;


//            if (dp.size() <= maxRowLength) {
//                var rowOfN = new ArrayList<Set<Long>>(2023);
//                rowOfN.add(indexOfN, new HashSet<>());
//                dp.add(maxRowLength, rowOfN);
//            }

            var downedCan = dp.get(maxRowLength).get(indexOfN).stream().reduce(Long::sum).orElse(0L);
            if (downedCan != 0) {
                System.out.println(downedCan);
                continue;
            }

//            var storedResult = dp[maxRowLength][maxRowLength - n];
//
//            if (storedResult > 0) {
//                System.out.println(storedResult);
//                continue;
//            }

//            var cachedCanIndexes = new ArrayList<List<Integer>>();
            var result = new HashSet<Long>();
            var notCachedCanSums = new ArrayList<List<Set<Long>>>();
            for (int i = 0; i < maxRowLength - 1; i++) {
//                cachedCanIndexes.add(new ArrayList<>(maxRowLength - 1));
                notCachedCanSums.add(new ArrayList<>(maxRowLength - 1));
                for (int j = 0; j < maxRowLength - 1; j++) {
                    notCachedCanSums.get(i).add(new HashSet<>());
                }
            }
//            var notCachedCansTotalSum = 0;

            var rowLength = maxRowLength - 1;
//            var rightMostRowNumber = maxRightMostRowNumber;

            var maxDistanceFromRightEdge = maxRightMostRowNumber - n;
            var distanceFromRightEdge = 0;
            int distanceFromLeftEdge = 0;
            var neighborsToFall = 1;
            var isLeftMostRowNumber = n == (maxRightMostRowNumber - maxRowLength + 1);

            var edgeRowNumber = isLeftMostRowNumber ?  maxRightMostRowNumber - maxRowLength + 1 : maxRightMostRowNumber;
            if (edgeRowNumber > n) {
                distanceFromRightEdge = (edgeRowNumber - n - 1);
                distanceFromLeftEdge = n - ((edgeRowNumber - maxRowLength) + 1) - 1;
                neighborsToFall++;
            }
//            System.out.println(edgeRowNumber);
//            System.out.println(distanceFromLeftEdge);
            for (int i = 0; i < maxRowLength - 1; i++) {
                var nextEdgeRowNumber = 0;
                if(isLeftMostRowNumber) {
                    nextEdgeRowNumber = edgeRowNumber - rowLength;
                } else if(rowLength == 1) {
                    nextEdgeRowNumber = 1;
                } else {
                    nextEdgeRowNumber = edgeRowNumber - (rowLength + 1);
                }
//                var nextRightMostRowNumber = rowLength == 1 ? 1 : edgeRowNumber - (rowLength + 1);
                var neighborsToFallCounter = neighborsToFall - 1;
                for (int k = 0; k < rowLength; k++) {
//                    if (dp[i][(int) (nextEdgeRowNumber - distanceFromRightEdge)] == 0) {
                    var cachedCanIndex = rowLength > 1 ? rowLength - distanceFromRightEdge - k - 1 : 0;
//                    System.out.println(i);
//                    System.out.println('#');
//                    System.out.println(cachedCanIndex);
                    var cachedCanSum = dp.get(i).get(cachedCanIndex);
//                    System.out.println(cachedCanSum);
                    var canNumberToFall = Math.round(Math.pow(nextEdgeRowNumber - distanceFromRightEdge - k, 2));
                    if (cachedCanSum.size() == 0) {
//                        System.out.println(cachedCanSum);
                        notCachedCanSums.get(i).get(cachedCanIndex).add(canNumberToFall);
                    }
                    result.add(canNumberToFall);
//                    }
                    if (k == neighborsToFallCounter) break;
                }

                rowLength--;
                if (rowLength < neighborsToFall) {
                    neighborsToFall--;
                } else if (rowLength > neighborsToFall && distanceFromRightEdge > 0 && distanceFromLeftEdge > 0) {
                    neighborsToFall++;
                }

                if (distanceFromRightEdge > 0)
                distanceFromRightEdge--;
                if (distanceFromLeftEdge > 0)
                    distanceFromLeftEdge--;

                edgeRowNumber = nextEdgeRowNumber;
            }

//            System.out.println(notCachedCanNumbersToFall);

            for (int i = 0; i < notCachedCanSums.size(); i++) {
                for (int j = 0; j < notCachedCanSums.get(i).size(); j++) {
                    var canToFallSum = notCachedCanSums.get(i).get(j);
                    if (canToFallSum.size() != 0) {
//                        System.out.println(canToFallSum);
                        result.addAll(canToFallSum);
                        dp.get(i).get(maxRowLength - j).addAll(canToFallSum);
                    }
                }
            }
//            System.out.println(notCachedCanSums);
//            System.out.println(result);
//            System.out.println(notCachedCanNumbersToFall);
//            for (int i = 0; i < notCachedCanNumbersToFall.size(); i++) {
//                result.addAll(notCachedCanNumbersToFall.get(i));
//            }
//            System.out.println(result);
//            System.out.println(Arrays.deepToString(dp));
//            var cachedResults = new HashSet<Long>();
//            var notCachedResults = new HashSet<Long>();
//            for (int i = 0; i < maxRowLength - 1; i++) {
//                for (int j = 0; j < maxRowLength - 1; j++) {
//                    if (dp.get(i).get(j).size() > 0) {
//                        cachedResults.add(Collections.max(dp.get(i).get(j)));
//                    } else {
//                        notCachedResults.add(Collections.max(cansToFall.get(i)));
//                    }
//                }
//                //                var intersection = cansToFall.retainAll(dp.get())
//            }
//            var cansToFallTotalSum = new HashSet<Long>();
//            for (int i = 0; i < maxRowLength - 1; i++) {
//                for (int j = 0; j < notCachedCanNumbersToFall.size(); j++) {
//                    cansToFallTotalSum.addAll(notCachedCanNumbersToFall.get(j));
//                }
//            }
//            System.out.println(cachedCanIndexes);


//            var notCachedCansTotalSum = new HashSet<Long>();
//            for (int i = 0; i < notCachedCanNumbers.size(); i++) {
//                notCachedCansTotalSum.addAll(notCachedCanNumbers.get(i));
//            }

//            var cansTotalSum = new HashSet<Long>();
//            if (isRightParentCached) {
//                cansTotalSum.addAll(dp.get(maxRowLength - 1).get(maxRightMostRowNumber - maxDistanceFromRightEdge - 1));
//            }
//            if (isLeftParentCached) {
//                cansTotalSum.addAll(dp.get(maxRowLength - 1).get(maxRightMostRowNumber - maxDistanceFromRightEdge - 2));
//            }
////            System.out.println(cansTotalSum.stream().reduce(Long::sum).orElse(0L));
//
//            if (!isRightParentCached && !isLeftParentCached) {
//                cansTotalSum.addAll(cansToFallTotalSum);
//            }

            result.add(Math.round(Math.pow(n, 2)));
            System.out.println(result.stream().reduce(Long::sum).orElse(0L));

//            var cansTotalSum = new HashSet<>(cansToFallTotalSum);
//            cansTotalSum.addAll(cansToFall );

//            var complement = new HashSet<>(notCachedResults);
//            complement.removeAll(cachedResults);

//            var result = Math.round(Math.pow(n, 2));
//            var stackedCans = new ArrayList<Long>();
//            for (int i = 0; i < maxRowLength - 1; i++) {
//                var canToFallRow = cansToFall.get(i);
//                for (int j = 0; j < canToFallRow.size(); j++) {
//                    var canToFallNumber = canToFallRow.get(j);
//                    if (canToFallNumber != 0) {
//                        stackedCans.add(canToFallNumber);
////                        var cachedCunSum = new ArrayList<>(dp.get(i).get(j));
////                        if (cachedCunSum.size() == 0) {
////                            dp.get(i).get(j).addAll(stackedCans);
////                        }
//                    }
//                }
//            }

//            var result = Math.round(Math.pow(n, 2));
//            var result = cansTotalSum.stream().reduce(Long::sum).orElse(0L);
//            result.addAll(stackedCans);
//            result.addAll(cansTotalSum);
//            result += Math.round(Math.pow(n, 2));

//            System.out.println(dp.get(0).get(0));
//            System.out.println(dp.get(1).get(0));
            dp.get(maxRowLength).get(indexOfN).addAll(result);
//            System.out.println(result);
        }
//        var printer = new PrintWriter(System.out);
//        printer.println(1);
//        printer.flush();
    }
}

//30
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000
//1000000