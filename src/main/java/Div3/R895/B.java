package Div3.R895;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        var testCases = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();

            var traps = new int[n][2];
            for (int i = 0; i < n; i++) {
                traps[i][0] = input.nextInt();
                traps[i][1] = input.nextInt();
            }

            var result = 1;
            for (int i = 0; i < n; i++) {
                var d = traps[i][0];
                var s = traps[i][1] - 1;

                var maxPossiblePath = Math.floorDiv(s, 2);
                var k = d == 1 ? maxPossiblePath + 1 : maxPossiblePath + d;
                result = i == 0 ? k : Math.min(result, k);
            }
            System.out.println(result);
        }
    }
}
