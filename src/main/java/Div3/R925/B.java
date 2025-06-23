package Div3.R925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.next());

        for (int t = 1; t <= testCases; t++) {
            var n = Integer.parseInt(input.next());
            var a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = (int)Math.pow(Integer.parseInt(input.next()), 2);
            }
            var candidatesSorted = Arrays.stream(a).sorted().toArray();
            var result = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (candidatesSorted[i] == candidatesSorted[j]) {
                        result += n - 2;
                        j +=4;
                    }

                }
            }
            System.out.println(result);
        }
    }
}
