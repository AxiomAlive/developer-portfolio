package Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    public static void main(String[] args) {
        var input = new FastScanner();

        int x = input.nextInt();

        var numberOfBST = getAllPossibleBST(1, x).size();

        System.out.println(numberOfBST);
    }

    private static List<Node> getAllPossibleBST(int start, int end) {
        var trees = new ArrayList<Node>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            var leftSubtrees = getAllPossibleBST(start, i-1);

            var rightSubtrees = getAllPossibleBST(i+1, end);

            for (var leftTree: leftSubtrees) {
                for (var rightTree: rightSubtrees) {
                    var root = new Node(i);

                    root.left = leftTree;
                    root.right = rightTree;

                    trees.add(root);
                }
            }
        }

        return trees;
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}


