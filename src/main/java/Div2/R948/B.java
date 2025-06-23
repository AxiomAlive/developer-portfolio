package Div2.R948;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B {

//    public static void binarySearch(int[] array, ) {
//
//    }

    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        var tcs = input.nextInt();
        for (int tc = 1; tc <= tcs; tc++) {
            var x = input.nextInt();

            var nearestIndex = 0;
            var powersOfTwo = new ArrayList<Integer>();
            for (int i = 0; i < 32; i++) {
                var powerOfTwo  = (int)Math.pow(2, i);

                powersOfTwo.add(powerOfTwo);

                if (powerOfTwo >= x) {
                    nearestIndex = i;
                    break;
                }
            }
//            System.out.println(powersOfTwo);

            var nearestValue = powersOfTwo.get(powersOfTwo.size()-1);
            var differenceWithNearestValue = nearestValue - x;

            var a = new int[nearestIndex+1];

            var totalSum = 0;
            for (int i = nearestIndex; i >= 0; i-=2) {
                var currentValue = powersOfTwo.get(i);
                if (i == nearestIndex) {
                    a[i] = 1;
                } else if (differenceWithNearestValue > 0 &&  currentValue <= differenceWithNearestValue) {
                    differenceWithNearestValue -= currentValue;
                    a[i] = -1;
                }

                var currentSum = powersOfTwo.get(i)*a[i];
                if (currentSum == 0) {
                    i++;
                }
                totalSum += powersOfTwo.get(i)*a[i];
            }

//            System.out.println(totalSum);
            if (totalSum != x) {
                nearestIndex--;
                nearestValue = powersOfTwo.get(powersOfTwo.size()-2);
                differenceWithNearestValue = x - nearestValue;

                for (int i = nearestIndex; i >= 0; i-=2) {
                    var currentValue = powersOfTwo.get(i);
                    if (i == nearestIndex) {
                        a[i] = 1;
                    } else if (differenceWithNearestValue > 0 &&  currentValue <= differenceWithNearestValue) {
                        differenceWithNearestValue -= currentValue;
                        a[i] = -1;
                    }

                    var currentSum = powersOfTwo.get(i)*a[i];
                    if (currentSum == 0) {
                        i++;
                    }
                }
                var a2 = new int[nearestIndex+1];
                for (int i = 0; i < nearestIndex; i++) {
                    a2[i] = a[i];
                }
                a = a2;
            }
            System.out.println(nearestIndex+1);
            System.out.println(Arrays.toString(a)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
            );
        }
    }
}
