package Div4.R944;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    static int searchForIndexOfPointInterval(int searchSpace[], int point) {
        int low = 0, high = searchSpace.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (searchSpace[mid] == point)
                return mid;

            // If x greater, ignore left half
            if (searchSpace[mid] < point) {
                if (low == mid) {
                    return high;
                }
                low = mid;
            }

            // If x is smaller, ignore right half
            else {
                if (high == mid) {
                    return low;
                }
                high = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var k = input.nextInt();
            var q = input.nextInt();

            var a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = input.nextInt();
            }

            var b = new int[k];
            for (int i = 0; i < k; i++) {
                b[i] = input.nextInt();
            }

            var d = new int[q];
            for (int i = 0; i < q; i++) {
                d[i] = input.nextInt();
            }

            var speed = new double[k];

            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    speed[i] = ((double)a[i]) / b[i];
                    continue;
                }
                speed[i] = ((double)(a[i] - a[i-1])) / (b[i] - b[i-1]);
            }

//            System.out.println(Arrays.toString(speed));
            var answers = new int[q];
            for (int i = 0; i < q; i++) {
                var indexOfPointInterval = searchForIndexOfPointInterval(a, d[i]);

                var timeSpentToReachPoint = 0;
                var j = 0;
                while(j <= indexOfPointInterval) {
                    if (a[j] > d[i]) {
                        if (j == 0) {
                            timeSpentToReachPoint += d[i] / speed[j];
                        } else {
                            timeSpentToReachPoint += (d[i] - a[j-1]) / speed[j];
                        }
                    } else {
                            timeSpentToReachPoint += a[j] / speed[j];
                    }
//                    System.out.println(timeSpentToReachPoint + "p " + d[i]);
                    j++;
                }
                answers[i] = (int)Math.floor(timeSpentToReachPoint);
            }
            for (int i = 0; i < q; i++) {
                var space = i < q - 1 ? " " : "\n";
                System.out.print(answers[i] + space);
            }
        }
    }
}
