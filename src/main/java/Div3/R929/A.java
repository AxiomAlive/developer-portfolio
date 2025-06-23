package Div3.R929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.next());
        for (int t = 1; t <= testCases; t++) {
            var n = Integer.parseInt(input.next());
            var a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(input.next());
            }
            var sortedElements = Arrays.stream(a).sorted().toArray();

            for (int i = 0; i < n; i++) {
                if (sortedElements[i] < 0) {
                    sortedElements[i] = Math.abs(sortedElements[i]);
                }
            }
            System.out.println(Arrays.stream(sortedElements).sum());
        }
    }
}
