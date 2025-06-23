package Div3.R929;

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
                a[i] = Integer.parseInt(input.next());
            }
//            var sortedElements = Arrays.stream(a).sorted().toArray();

//            for (int i = 0; i < n; i++) {
//                if (sortedElements[i] < 0) {
//                    sortedElements[i] = Math.abs(sortedElements[i]);
//                }
//            }
            var divRemainder = Arrays.stream(a).sum() % 3;
            if(divRemainder == 0) {
                System.out.println(0);
            } else if(divRemainder == 2) {
                System.out.println(1);
            } else {
                var exists = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] % 3 == 1) {
                        System.out.println(1);
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                System.out.println(2);
            }
        }
    }
}
