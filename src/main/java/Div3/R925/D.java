package Div3.R925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        var input = new FastScanner();
        var tc = input.nextInt();
        for (int t = 1; t <= tc; t++) {
            var n = input.nextInt();
            var x = input.nextInt();
            var y = input.nextInt();

            var a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            var sorted = Arrays.stream(a).sorted().toArray();

            var result  = 0;
            for (int i = 0; i < n - 1; i++) {
                var desiredPairCount = 0;
//                var repeatedLength = 0;
                var incrementSize = 0;
                for (int j = i + 1; j < n; j++) {
                    if ((sorted[i] + sorted[j]) % x == 0 && (sorted[i] - sorted[j]) % y == 0) {
                        if (sorted[i] == sorted[j]) {
                            desiredPairCount++;
//                            if (repeatedLength == 0) {
//                                repeatedLength = n - j - 1;
//                            }
                        }
                        incrementSize++;
                    }
//                    if (sorted[i] == sorted[j]) repeatedLength++;
                }
                int j = desiredPairCount;
                do {
                    if (j < desiredPairCount) {
                        i++;
                    }
                    result += incrementSize;
                    incrementSize--;
                    j--;
                } while (j >= 0);
            }
            System.out.println(result);
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
