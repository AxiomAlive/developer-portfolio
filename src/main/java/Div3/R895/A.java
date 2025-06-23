package Div3.R895;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var a = input.nextInt();
            var b = input.nextInt();
            var c = input.nextInt();

            var result = 0;
            var currentMax = Math.max(a, b);
            var currentMin = Math.min(a, b);

            if (currentMax == currentMin) {
                System.out.println(result);
                continue;
            }

            while(currentMax > currentMin) {
                result++;
                currentMax = currentMax - c;
                currentMin = currentMin + c;
            }
            System.out.println(result);
        }
    }

}
