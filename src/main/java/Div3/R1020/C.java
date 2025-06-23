package Div3.R1020;

import common.Helper;

import java.util.Arrays;
import java.util.Comparator;

public class C {
    public static void main(String[] args) {
        var in = new Helper().new FastScanner();

        var t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            var n = in.nextInt();
            var k = in.nextInt();
            var a = new Integer[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            var b = new Integer[n];
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
            }

            Arrays.sort(a, (integer, t1) -> t1 - integer);
            Arrays.sort(b, (integer, t1) -> t1 - integer);

            var answer = 0;
            var constant = 0;
            for (int j = 0; j < n; j++) {
                if(b[i] != -1) {
                    if (constant == 0) {
                        constant = a[i] + b[i];
                    } else if(a[i] + b[i] != constant) {
                        answer = 0;
                        break;
                    }
                } else {
                    if(constant == 0) {
                        answer = k;
                        break;
                    } else {
                        answer = constant - a[i];

                    }
                }
            }

        }
    }
}
