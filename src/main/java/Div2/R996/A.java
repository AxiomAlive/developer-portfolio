package Div2.R996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        var input = new FastScanner();
        var tc = input.nextInt();

        for (int i = 0; i < tc; i++) {
            var n = input.nextInt();
            var a = input.nextInt();
            var b = input.nextInt();

            var isAWinning = true;
            var turnsRemained = Math.abs(a - b);
            while (turnsRemained > 1) {
                turnsRemained--;
                isAWinning = !isAWinning;
            }
            if (isAWinning) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
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
