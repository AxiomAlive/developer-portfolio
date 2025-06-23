package Div2.R936;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        var input = new FastScanner();
        var tcs = input.nextInt();
        for (int tc = 1; tc <= tcs; tc++) {
            var n = input.nextInt();
            var k = input.nextInt();
            var a = new ArrayList<BigInteger>();
            for (int i = 0; i < n; i++) {
                a.add(BigInteger.valueOf(input.nextInt()));
            }
            var maxSubArrSumAfterKOperations = BigInteger.valueOf(0);
            var maxSubArrSumEndIndexAfterKOperations = 0;
//            for (int i = 0; i < k; i++) {
//                var maxSubArrSumLenAfterKOperations = 0;
//                var maxSubArrSumAfterKOperations = BigInteger.valueOf(0);
//                var maxSubArrSumEndIndexAfterKOperations = 0;
            var sumOfArrInitialContentWithoutMaxSubArrSum = BigInteger.valueOf(0);
            for (var number:
                    a) {
                sumOfArrInitialContentWithoutMaxSubArrSum = sumOfArrInitialContentWithoutMaxSubArrSum.add(number);
            }

            var intermediateMaxSubArrSum = BigInteger.valueOf(0);
            for (int j = 0; j < a.size(); j++) {
                var number = a.get(j);
                intermediateMaxSubArrSum =   intermediateMaxSubArrSum.add(number);
                if (intermediateMaxSubArrSum.compareTo(BigInteger.valueOf(0)) < 0) {
                    intermediateMaxSubArrSum = BigInteger.valueOf(0);
                }
                if (maxSubArrSumAfterKOperations.compareTo(intermediateMaxSubArrSum) < 0) {
                    maxSubArrSumAfterKOperations = intermediateMaxSubArrSum;
                    maxSubArrSumEndIndexAfterKOperations = j + 1;
                }
            }
//            a.add(maxSubArrSumEndIndexAfterKOperations++, maxSubArrSumAfterKOperations);
            sumOfArrInitialContentWithoutMaxSubArrSum = sumOfArrInitialContentWithoutMaxSubArrSum.subtract(maxSubArrSumAfterKOperations);

//            for (int i = 1; i < k; i++) {
//                maxSubArrSumAfterKOperations = maxSubArrSumAfterKOperations.add(maxSubArrSumAfterKOperations);
//
////                a.add(maxSubArrSumEndIndexAfterKOperations++, maxSubArrSumAfterKOperations);
//            }
//                System.out.println(a);
//                for (int j = 0, m = n - 1; j < n && m >= 0; j++, m--) {
//                    var subArrSumComputedByLeftPointer = 0;
//                    var subArrSumComputedByRightPointer = 0;
//                    for (int l = j, p = m; l < n && p >= 0; l++, p--) {
//                        subArrSumComputedByLeftPointer += a.get(l);
//                        subArrSumComputedByRightPointer += a.get(p);
//                    }
//
////                    if (dp[j+k] == 0) {
////                        dp[j+k] = subArrSumComputedByLeftPointer;
////                        a.add(j+k, subArrSumComputedByLeftPointer);
////                    }
//
//                    if (subArrSumComputedByLeftPointer > subArrSumComputedByRightPointer) {
//                        if (maxSubArrSumAfterKOperations < subArrSumComputedByLeftPointer) {
//                            maxSubArrSumAfterKOperations = subArrSumComputedByLeftPointer;
//                            maxSubArrSumIndexRangeAfterKOperations[0] = j;
//                            maxSubArrSumIndexRangeAfterKOperations[1] = n-1;
//                        }
//                    } else {
//                        if (maxSubArrSumAfterKOperations < subArrSumComputedByRightPointer) {
//                            maxSubArrSumAfterKOperations = subArrSumComputedByRightPointer;
//                            maxSubArrSumIndexRangeAfterKOperations[0] = 0;
//                            maxSubArrSumIndexRangeAfterKOperations[1] = m;
//                        }
//                    }
//                }
//
//                if (maxSubArrSumIndexRangeAfterKOperations[1] == n - 1) {
//                    a.add(maxSubArrSumIndexRangeAfterKOperations[1], maxSubArrSumAfterKOperations);
//                } else {
//                    a.add(maxSubArrSumIndexRangeAfterKOperations[0], maxSubArrSumAfterKOperations);
//                }
//
//            }
//            var arrSum = BigInteger.valueOf(0);
//            for (var number:
//                 a) {
//                arrSum = arrSum.add(number);
//            }
            maxSubArrSumAfterKOperations = maxSubArrSumAfterKOperations.multiply(BigInteger.valueOf(2).pow(k-1));
//            System.out.println(maxSubArrSumAfterKOperations);
//            System.out.println((((maxSubArrSum.longValue() % 1000000007) + 1000000007) % 1000000007));
            System.out.println(sumOfArrInitialContentWithoutMaxSubArrSum.add(maxSubArrSumAfterKOperations).add(maxSubArrSumAfterKOperations).mod(BigInteger.valueOf(1000000007)));
        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
