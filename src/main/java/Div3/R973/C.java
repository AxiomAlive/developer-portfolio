package Div3.R973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }
            var max = Arrays.stream(a).max().getAsInt();
            var sorted = Arrays.stream(a).sorted().toArray();
            var median = 0;
            if (sorted.length % 2 == 0) {
                median = sorted[n / 2];
            } else {
                median = sorted[Math.floorDiv(n, 2)];
            }

            var sum = Arrays.stream(sorted).sum();
            var ans = 0;
            if (n < 3) {
                ans = -1;
            } else if (median >= (sum / n)) {
                ans = max / n + n * median;

                if ((ans + sum) / (n*2) < median) {
                    ans = n*2 * median - sum  + 1;
                }
            }
            System.out.println(ans);

        }
    }
}