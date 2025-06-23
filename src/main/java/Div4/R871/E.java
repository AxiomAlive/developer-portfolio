package Div4.R871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    private static int[][] a;

    public static void main(String[] args) {
        var input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        var testCases = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            var n = input.nextInt();
            var m = input.nextInt();

            a = new int[n][m];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    a[i][j] = input.nextInt();
                }
            }

            var immediateResult = 0;
            var adjacencyList = new HashMap<String, List<String>>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0) {
                        var neighboringCells = new ArrayList<String>();
                        if (i != 0) {
                            if (a[i - 1][j] != 0)
                            neighboringCells.add(i - 1 + " " + j);
                        }
                        if (i != n - 1) {
                            if (a[i + 1][j] != 0)
                            neighboringCells.add(i + 1 + " " + j);
                        }

                        if (j != 0) {
                            if (a[i][j - 1] != 0)
                            neighboringCells.add(i + " " + (j - 1));
                        }
                        if (j != m - 1) {
                            if (a[i][j + 1] != 0)
                            neighboringCells.add(i + " " + (j + 1));
                        }

                        if (neighboringCells.size() > 0) {
//                            var vertexBelongings = new HashMap<String, List<String>>();
                            adjacencyList.put(i + " " + j, neighboringCells);

//                            adjacencyList.add(vertexBelongings);
                        } else {
                            immediateResult = Math.max(immediateResult, a[i][j]);
                        }
                    }
                }
            }

            if (adjacencyList.size() == 0) {
                System.out.println(immediateResult);
                continue;
            }

            var disjointSet = new HashMap<String, String>();

            for (String vertex : adjacencyList.keySet()) {
                disjointSet.put(vertex, vertex);
            }

            var result = 0;
            for (String vertex : adjacencyList.keySet()) {
                var vertexBelongings = adjacencyList.get(vertex);
                for (int i = 0; i < vertexBelongings.size(); i++) {
                    var srcVertex = findEdgeVertex(disjointSet, vertex, 0);
                    var destVertex = findEdgeVertex(disjointSet, vertexBelongings.get(i), 0);

                    if (srcVertex.equals(destVertex)) {
                        result = Math.max(result, srcVertex.values().iterator().next() + destVertex.values().iterator().next());
                        break;
                    }
                    disjointSet.put(srcVertex.keySet().iterator().next(), destVertex.keySet().iterator().next());
                }
            }
//            System.out.println(disjointSet);
//            System.out.println(adjacencyList);

//            var notVisitedVertices = new LinkedHashSet<String>();
//            var visitedVertices = new ArrayList<String>(adjacencyList.size());
//
////            visitedVertices.add(adjacencyList.keySet().iterator().next());
//
////            var root = visitedVertices.get(0);
////            var rootLocation = root.split("");
////            notVisitedVertices.addAll(adjacencyList.get(root));
//
////            for (var vertex : adjacencyList.keySet()) {
////                var vertexBelongings = adjacencyList.get(vertex);
////                notVisitedVertices.addAll(vertexBelongings);
////            }
////            System.out.println(Integer.parseInt(root[1]));
////            System.out.println(immediateResult);
//            var result = 0;
////            System.out.println(a[Integer.parseInt(root[0])][Integer.parseInt(root[1])]);
////            System.out.println(adjacencyList);
//            var rootsOfUniquePaths = new LinkedList<String>();
//            rootsOfUniquePaths.addAll(adjacencyList.keySet());
//
////            var rootsOfUniquePathsIterator = rootsOfUniquePaths.iterator();
//            while (rootsOfUniquePaths.size() != 0) {
//                var vertex = rootsOfUniquePaths.poll();
//                var vertexLocation = vertex.split(" ");
//
//                var pathSum = a[Integer.parseInt(vertexLocation[0])][Integer.parseInt(vertexLocation[1])];
//                visitedVertices.add(vertex);
//
//                var vertexBelongingsIterator = adjacencyList.get(vertex).iterator();
//                while(vertexBelongingsIterator.hasNext()) {
//                    var vertexBelonging = vertexBelongingsIterator.next();
//                    if (!visitedVertices.contains(vertexBelonging)) {
////                        visitedVertices.add(vertexBelonging);
//                        notVisitedVertices.add(vertexBelonging);
//                    }
//                }
////                System.out.println(1);
//                var notVisitedVerticesIterator = notVisitedVertices.iterator();
//                while (notVisitedVerticesIterator.hasNext()) {
//                    var nextVertexInPath = notVisitedVerticesIterator.next();
//                    var vertexNeighbors = adjacencyList.get(nextVertexInPath);
//
//                    for (int j = 0; j < vertexNeighbors.size(); j++) {
//                        var neighboringVertex = vertexNeighbors.get(j);
//                        if(!visitedVertices.contains(neighboringVertex)) {
//                            notVisitedVertices.add(neighboringVertex);
//                            ////                        System.out.println(a[Integer.parseInt(String.valueOf(neighboringVertex.charAt(0)))][Integer.parseInt(String.valueOf(neighboringVertex.charAt(1)))]);
//                            ////                        result += a[Integer.parseInt(String.valueOf(neighboringVertex.charAt(0)))][Integer.parseInt(String.valueOf(neighboringVertex.charAt(1)))];
//                        }
//                        rootsOfUniquePaths.remove(neighboringVertex);
////                        rootsOfUniquePathsIterator = rootsOfUniquePaths.iterator();
//                    }
//                    var nextVertexLocation = nextVertexInPath.split(" ");
////                System.out.println("Testcase " + testCase);
////                System.out.println(a[Integer.parseInt(String.valueOf(vertex.charAt(0)))][Integer.parseInt(String.valueOf(vertex.charAt(1)))]);
//                    pathSum += a[Integer.parseInt(nextVertexLocation[0])][Integer.parseInt(nextVertexLocation[1])];
////                System.out.println(result);
//                    visitedVertices.add(nextVertexInPath);
//                        notVisitedVertices.remove(nextVertexInPath);
//
//                        notVisitedVerticesIterator = notVisitedVertices.iterator();
////                System.out.println(vertex);
//                    }

//                var notVisitedVerticesIterator = notVisitedVertices.iterator();

//                System.out.println(Arrays.toString(vertexLocation));

//                result = Math.max(pathSum, result);

//                System.out.println(pathSum);
//            }
            System.out.println(Math.max(result, immediateResult));
        }
    }

    private static Map<String, Integer> findEdgeVertex(HashMap<String, String> parent, String vertex, Integer pathSum) {
        var vertexLocation = vertex.split(" ");
        pathSum += a[Integer.parseInt(vertexLocation[0])][Integer.parseInt(vertexLocation[1])];

        var vertexPointer = parent.get(vertex);
        if (vertexPointer.equals(vertex)) {
            return Collections.singletonMap(vertex, pathSum);
        }

//        System.out.println(pathSum);
        return findEdgeVertex(parent, vertexPointer, pathSum);
    }
}
