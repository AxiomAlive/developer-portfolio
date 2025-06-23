package Div3.R973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var k = input.nextInt();

            if(n == 1) {
                System.out.println("NO");
                continue;
            }
            var totalAmount = 0L;
//            var ops = n - (n - k + 1);
            var isEven = (n - k + 1) % 2 == 0;
            if ((k != 2 && k % 2 == 0) || !isEven) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
//            for (int i = n - k + 1; i <= n; i++) {
//                totalAmount += i;
//            }
//            if (totalAmount % 2 == 0) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
        }
    }
}
