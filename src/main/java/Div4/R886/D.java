//package Div4.R886;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class D {
//    public static void main(String[] args) {
//        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//
//        var testCases = input.nextInt();
//
//        for (int testCase = 1; testCase <= testCases; testCase++) {
//            var n = input.nextInt();
//            var k = input.nextInt();
//
//            var a = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                a[i] = input.nextInt();
//            }
//
//            var sorted = Arrays.stream(a).sorted().toArray();
//
//            var maxValidProblemDifficultyLength = 1;
//            for (int i = 0; i < n - 1; i++) {
//                var currentProblemDifficultyLength = 1;
//                var previousProblemDifficultyDifference = sorted[n - 1] - sorted[i];
//                for (int j = n - 2; j > i; j--) {
//                    var currentProblemDifficultyDifference = sorted[j] - sorted[i];
//                    if (previousProblemDifficultyDifference - currentProblemDifficultyDifference <= k) {
//                        currentProblemDifficultyLength++;
//                    } else break;
//
//                    previousProblemDifficultyDifference = currentProblemDifficultyDifference;
////                    if ((sorted[j] - sorted[i]) <= k) {
////                        maxValidProblemDifficultyLength = Math.max(maxValidProblemDifficultyLength, j - i + 1);
////                        break;
////                    }
//                }
//                maxValidProblemDifficultyLength = Math.max(currentProblemDifficultyLength, maxValidProblemDifficultyLength);
////                if ((sorted[i + 1] - sorted[i]) <= k) {
////                    currentValidProblemDifficultyLength++;
////                }
////                if (((sorted[i + 1] - sorted[i]) > k) || (i == n - 2)) {
////                    if (currentValidProblemDifficultyLength > 1) {
////                        maxValidProblemDifficultyLength = Math.max(maxValidProblemDifficultyLength, currentValidProblemDifficultyLength);
////                        currentValidProblemDifficultyLength = 1;
////                    }
////                }
//            }
//
//            var result = 0;
//            if (n > 0) result = n - maxValidProblemDifficultyLength;
//            System.out.println(result);
//        }
//    }
//}

package Div4.R886;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var k = input.nextInt();

            if (k == 1000000000) {
                System.out.println(0);
                continue;
            }

            var a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            var ascendingOrder = true;
            for (int i = 1; i < n; i++) {
                if (i == 1 && a[0] > a[1]) {
                    ascendingOrder = false;
                    continue;
                }

                var differenceOfConsecutiveNumbers = a[i - 1] - a[i];
                if (ascendingOrder) {
                    if (differenceOfConsecutiveNumbers > 0) {
                        quickSort(a, 0, n - 1);
                        break;
                    }
                } else {
                    if (differenceOfConsecutiveNumbers < 0) {
                        quickSort(a, 0, n - 1);
                        ascendingOrder = true;
                        break;
                    }
                }
            }

//            quickSort(a, 0, n - 1);

//            if (k == 1) sorted = Arrays.stream(sorted).collect(Collectors.toSet());

            var maxValidProblemDifficultyLength = 1;
            var currentValidProblemDifficultyLength = 1;
            for (int i = 0; i < n - 1; i++) {
                if (n - i <= maxValidProblemDifficultyLength && currentValidProblemDifficultyLength == 1) break;

                var differenceOfConsecutiveNumbers = !ascendingOrder ? a[i] - a[i + 1]: a[i + 1] - a[i];
                if (differenceOfConsecutiveNumbers <= k) {
                    currentValidProblemDifficultyLength++;
                }
                if ((differenceOfConsecutiveNumbers > k) || (i == n - 2)) {
                    if (currentValidProblemDifficultyLength > 1) {
                        if (currentValidProblemDifficultyLength > maxValidProblemDifficultyLength)
                            maxValidProblemDifficultyLength = currentValidProblemDifficultyLength;
                        currentValidProblemDifficultyLength = 1;
                    }
                }
            }

            var result = 0;
            if (n > 0) result = n - maxValidProblemDifficultyLength;
            System.out.println(result);
        }
    }
}
