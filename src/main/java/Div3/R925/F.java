package Div3.R925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = Integer.parseInt(input.next());

        for (int t = 1; t <= testCases; t++) {
            var n = Integer.parseInt(input.next());
            var a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(input.next());
            }
            var m = Integer.parseInt(input.next());
            var q = new int[m][2];
            for (int i = 0; i < m; i++) {
                q[i][0] = Integer.parseInt(input.next());
                q[i][1] = Integer.parseInt(input.next());
            }

            var closestCities = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    closestCities[0] = 2;
                    continue;
                } else if (i == n - 1) {
                    closestCities[n-1] = n-1;
                    continue;
                }
                var distanceToPreviousCity = a[i] - a[i-1];
                var closestDistance = Math.min(distanceToPreviousCity, a[i+1] - a[i]);

                closestCities[i] = distanceToPreviousCity == closestDistance ? i : i + 2;
            }
            System.out.println(Arrays.toString(closestCities));

            var dp = new int[n][n];
            for (int i = 0; i < m; i++) {
                var result = 0;
                var startPoint = q[i][0];
                var finishPoint = q[i][1];


                var leftCityPosition = startPoint;
                Integer rightCityPosition = finishPoint;
                while ((rightCityPosition - 1 > startPoint && leftCityPosition < finishPoint && startPoint < finishPoint) || (rightCityPosition > 1 && rightCityPosition + 1 < startPoint && leftCityPosition > finishPoint && startPoint > finishPoint)) {
//                    var nextRightCityPosition = closestCities[rightCityPosition-1];

                    var storedValueForRightCityPosition = dp[startPoint-1][rightCityPosition-1];
                    var storedValueForLeftCityPosition = dp[leftCityPosition-1][finishPoint-1];
                    if (storedValueForRightCityPosition != 0 || storedValueForLeftCityPosition != 0) {

                        result += storedValueForRightCityPosition != 0 ? storedValueForRightCityPosition: storedValueForLeftCityPosition;
                        leftCityPosition++;
                        rightCityPosition--;
                        continue;
                    }
                    var closestDistance = 0;
                    if (startPoint < finishPoint) {
//                          var closestCity =closestCities[closestCityPosition-1];
                        var nextCityPosition = closestCities[leftCityPosition-1];
                        if (nextCityPosition < leftCityPosition) {
                            closestDistance = a[leftCityPosition] - a[leftCityPosition-1];
                            result += closestDistance;
                        } else {
                            result++;
                            closestDistance++;
                        }
                        dp[leftCityPosition-1][nextCityPosition-1] = closestDistance;
                        leftCityPosition++;
                    } else {
                        var nextCityPosition = closestCities[rightCityPosition-1];
//                        rightCityPosition = leftCityPosition;
//                        var nextRightCityPosition = nextLeftCityPosition;
//                          var closestCity =closestCities[closestCityPosition-1];
                        if (nextCityPosition > rightCityPosition) {
                            closestDistance = a[rightCityPosition-1] - a[rightCityPosition-2];
                            result += closestDistance;
                        } else {
                            result++;
                            closestDistance++;
                        }
                        dp[rightCityPosition-1][nextCityPosition-1] = closestDistance;
                        rightCityPosition--;
                    }
                }
//                } else {
//                    while (closestCityIndex != finishPoint) {
//                        var nextClosestCity = closestCities[closestCityIndex];
//                        if (nextClosestCity > closestCityIndex) {
//                            result += a[closestCityIndex] - a[closestCityIndex-1];
//                            closestCityIndex = nextClosestCity;
//                        } else {
//                            result++;
//                            closestCityIndex++;
//                        }
//                    }
//                }

            System.out.println(result);
            }
        }
    }
}
