package Div3.R973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var k = input.nextInt();
            var a = new int[n];

            var ans = 0;
            var earned = 0;
            for (int i = 0; i < n; i++) {
                var gold = input.nextInt();
                if (gold == 0 && earned > 0) {
                    ans++;
                    earned--;
                } else if (gold >= k) {
                    earned += gold;
                }
            }
            System.out.println(ans);
        }
    }
}
