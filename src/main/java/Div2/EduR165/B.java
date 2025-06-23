package Div2.EduR165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        var tcs = Integer.parseInt(input.next());
        for (int tc = 1; tc <= tcs; tc++) {
            var s = new StringBuilder(input.next());

//            var isSubstitutionRequired = false;
            var isPreviousNumberEqualsOne = false;
            var substitutionLength = 0;
            var minSummaryCost = 0L;
//            var indexesForSubstitution = new ArrayList<Integer>();
            for (int i = 0; i < s.length(); i++) {
                var binaryNumber = s.charAt(i);
                if (isPreviousNumberEqualsOne && binaryNumber == '0') {
                    minSummaryCost += substitutionLength + 1;

//                    s.replace(i - substitutionLength, i + 1, "0" + "1".repeat(substitutionLength));
//                    s.replace(i - substitutionLength,i - substitutionLength, "0");
                }

                if (binaryNumber == '1') {
                    substitutionLength++;
                    isPreviousNumberEqualsOne = true;
                }
            }
//            if (substitutionLength == 1) {
//                substitutionLength--;
//            }
//            System.out.println(substitutionLength);
//            for (var indexForSubstitution:
//                 indexesForSubstitution) {
//
//            }
            System.out.println(minSummaryCost);
        }
    }

//    static class FastScanner {
//        BufferedReader br;
//        StringTokenizer st;
//
//        FastScanner() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreTokens()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//    }
}
