    package Div4.R944;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.Scanner;

    public class D {
        public static void main(String[] args) {
            Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int testCases = Integer.parseInt(input.next());
            for (int testCase = 1; testCase <= testCases; testCase++) {
                var s = new StringBuilder(input.next());

                var answer = 1;
                var zeroAtBeginning = false;
    //            Boolean isDecreasing = null;
                Boolean isPreviousNumberEqualsToOne = null;
                for (int i = 0; i < s.length(); i++) {
                    var character = s.charAt(i);
                    if (character == '0' && Boolean.TRUE.equals(isPreviousNumberEqualsToOne)) {
                        if (!(i == s.length()-1 && zeroAtBeginning && answer > 1)) {
                            answer++;
                        } else {
                            answer += 2;
                        }
                    }

                    if (character == '1') {
                        if (i == s.length()-1 && zeroAtBeginning && answer > 1) {
                            answer++;
                        }
                        isPreviousNumberEqualsToOne = true;
                    } else {
                        if (i == 0) {
                            zeroAtBeginning = true;
                        }
                        isPreviousNumberEqualsToOne = false;
                    }
                }
                System.out.println(answer);
            }
        }
    }
