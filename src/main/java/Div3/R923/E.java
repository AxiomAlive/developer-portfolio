package Div3.R923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = Integer.parseInt(input.next());
            var k = Integer.parseInt(input.next());

            var result = new int[n];
            result[0] = 1;
//            var numbersOfElementChanges = new int[k];
            var minUpperBound = 0;
            var maxLowerBound = 0;
            for (int i = 1; i <= k; i++) {
                var minNumberOfChanges = Math.floorDiv(n, k);
                var extraChanges = n % k;
                var numberOfElementChanges = i <= extraChanges ? minNumberOfChanges + extraChanges : minNumberOfChanges;
//                numbersOfElementChanges[i] = numberOfElementChanges;
                for (int j = i, l=n, p=0; j < i + numberOfElementChanges && i + p <= n; j++, l--, p+=k) {
                    if (i == 1) {
                        result[i+p-1] = maxLowerBound = j;
                    } else if (i == k) {
                        result[i+p-1] = minUpperBound = l;
                    }
                }
            }
            for (int i = 2; i < k; i++) {
                var minNumberOfChanges = Math.floorDiv(n, k);
                var extraChanges = n % k;
                var numberOfElementChanges = i <= extraChanges ? minNumberOfChanges + extraChanges : minNumberOfChanges;
//                numbersOfElementChanges[i] = numberOfElementChanges;
                for (int p=0; i + p <= n; p+=k) {
                    if (i % 2 == 0) {
                        result[i+p-1] = --minUpperBound;
                    } else {
                        result[i+p-1] = ++maxLowerBound;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.print("\n");
//            for (int i = 0; i < numbersOfElementChanges.length; i++) {
//                var numberOfElementChanges =
//            }
        }
    }
}
