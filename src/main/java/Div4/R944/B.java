package Div4.R944;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        var tcs = Integer.parseInt(input.next());
        for (int tc = 1; tc <= tcs; tc++) {
            var s = new StringBuilder(input.next());

            var isDifferentStringPossible = false;
            var indexOfSymbolChange = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i-1)) {
                    isDifferentStringPossible = true;
                    indexOfSymbolChange = i;
                    break;
                }
            }
            if (isDifferentStringPossible) {
                System.out.println("Yes");
//                System.out.println(String.valueOf(s.charAt(indexOfSymbolChange)));
                System.out.println(s.replace(indexOfSymbolChange-1, indexOfSymbolChange+1, s.charAt(indexOfSymbolChange) + String.valueOf(s.charAt(indexOfSymbolChange - 1))));
            } else{
                System.out.println("No");
            }
        }
    }
}
