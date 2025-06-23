package Div4.R871;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//import javafx.*;

public class D {
    private static Set<Integer> dp;

    private static String checkForPossibilityOfGivenSliceSize(int initialValue, int targetValue) {
        if (targetValue > initialValue) {
            return "No";
        } else if (targetValue == initialValue) {
            return "Yes";
        }

        var result = "No";
//        for (int smallerValue = (int)Math.floor(Math.sqrt(targetValue)); smallerValue <= Math.floorDiv(targetValue, 2); smallerValue++) {
            var smallerValue = Math.floorDiv(initialValue, 3);
            var biggerValue = initialValue - smallerValue;

            if (smallerValue * 2 == biggerValue) {
                dp.add(biggerValue + smallerValue);

                if (targetValue == smallerValue || targetValue == biggerValue) {
                    result = "Yes";
                } else {
                    result = checkForPossibilityOfGivenSliceSize(biggerValue, targetValue);
                    if (result.equals("No") && targetValue < smallerValue) {
                        result = checkForPossibilityOfGivenSliceSize(smallerValue, targetValue);
                    }
                }
            }
//        }
        return result;
    }

    private static boolean checkForPrecomputedValue(int initialValue, int targetValue){
        if (targetValue > initialValue) {
            return false;
        }

//        System.out.println(dp);
        if (dp.contains(initialValue)) {
//            System.out.println(initialValue);
//            var values = dp.get(initialValue);

            var smallerValue = Math.floorDiv(initialValue, 3);
            var biggerValue = initialValue - smallerValue;
            if (biggerValue == targetValue || smallerValue == targetValue) {
//                System.out.println(targetValue);
                return true;
            }
            var result = checkForPrecomputedValue(biggerValue, targetValue);
            if (!result && targetValue < smallerValue) {
                result = checkForPrecomputedValue(smallerValue, targetValue);
            }
            return result;
        }
        return false;

    }

    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();

        dp = new HashSet<>();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var m = input.nextInt();

//            if (dp.containsKey(n)) {
//                System.out.println(dp.get(n));
//            }

            var answer = "No";
            if (!checkForPrecomputedValue(n, m)) {
                answer = checkForPossibilityOfGivenSliceSize(n, m);
            } else {
                answer = "Yes";
            }
            System.out.println(answer);
        }

    }
}
