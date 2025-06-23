package Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static int binaryToDecimal(String n) {
        String num = n;
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.next());

        for (int testCase = 0; testCase < testCases; testCase++) {
            var n = Integer.parseInt(input.next());

            var binary = input.next();

            var binaryChars  = binary.toCharArray();

            var result = new ArrayList<Integer>();
            var divisor = 2;

            if (binary.length() == 1) {
                System.out.println(-1);
                continue;
            }

            int j = 1;
            if (binaryToDecimal(binary) % divisor == 0) {
                result.add(0);
                j++;
            }
            for (; j <= n; j++) {
                var isSubstitutionAllowsDivision = false;
                for (int i = j - 1; i < n - 1; i++) {
                    var binaryCharsClone = binaryChars.clone();
                    binaryCharsClone[i] = binaryChars[i + 1];
                    binaryCharsClone[i + 1] = binaryChars[i];

                    var newDecimal = binaryToDecimal(String.valueOf(binaryCharsClone));

                    if (newDecimal % divisor == 0) {
                        result.add(i + 1);
                        isSubstitutionAllowsDivision = true;
                        break;
                    }
                }
                if (!isSubstitutionAllowsDivision) {
                    result.add(-1);
                }
                divisor = (int)Math.pow(2, j);
//                System.out.println(divisor);
            }

            for (int i = 0; i < n; i++) {
                var indent = " ";
                if (i == n - 1) {
                    indent = "\n";
                }
                System.out.print(result.get(i) + indent);
            }
        }
    }
}
