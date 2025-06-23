package Div3.R895;

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();
        for (int t = 0; t < testCases; t++) {
            var l = input.nextInt();
            var r = input.nextInt();

            var c = l;
            var isPrime = true;
            while(isPrime) {
                for (int i = 2; i <= Math.sqrt(c); i++) {
                    if (c % i == 0) {
                        var a = c / i;
                        var b = c - a;
                        System.out.println(a + " " + b);
                        isPrime = false;
                        break;
                    }
                }
                if (c++ == r) break;
            }

//            var result = -1;
            if (isPrime) {
                System.out.println(-1);
//                continue;
            }
        }
    }

}
