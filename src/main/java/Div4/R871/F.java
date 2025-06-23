package Div4.R871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class F {
    static Map<Integer, List<Integer>> adjacencyMap;
    static Map<Integer, List<Integer>> retrieveEdgeVertexBelongings(Integer vertex) {
        var result = adjacencyMap
                .entrySet()
                .stream()
                .filter(currentVertex -> currentVertex.getValue().contains(vertex) && currentVertex.getValue().size() > 1)
                .iterator().next();
        return Map.of(result.getKey(), result.getValue());
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        var testCases = input.nextInt();
        for (int i = 1; i <= testCases; i++) {
            var n = input.nextInt();
            var m = input.nextInt();
            var vertexesWithBelongings = new HashMap<Integer, List<Integer>>();

            for (int j = 0; j < m; j++) {
                var vertexNumber = input.nextInt();
                var vertexBelongings = vertexesWithBelongings.getOrDefault(vertexNumber, new ArrayList<>());
                vertexBelongings.add(input.nextInt());
                if (vertexBelongings.size() == 1) {
                    vertexesWithBelongings.put(vertexNumber, vertexBelongings);
                }
            }
//            System.out.println(vertexesWithBelongings);

            adjacencyMap = new HashMap<>();
            var vertexBelongings = new LinkedList<>(vertexesWithBelongings.entrySet());
            for (var vertexBelonging: vertexBelongings) {
                var vertexNumber = vertexBelonging.getKey();
                var newVertexBelongings = vertexesWithBelongings
                        .entrySet()
                            .stream()
                                .filter(vertexes -> vertexes.getValue().contains(vertexNumber))
                                    .mapToInt(Map.Entry::getKey)
                                    .boxed()
                                        .collect(Collectors.toList());
                newVertexBelongings.addAll(vertexesWithBelongings.get(vertexNumber));
                adjacencyMap.put(vertexNumber, newVertexBelongings);
            }
//            for (int key : vertexesWithBelongings.keySet()) {
//                var vertexBelongings = vertexesWithBelongings
//                        .entrySet()
//                        .stream()
//                        .filter(entry -> vertexesWithBelongings.get(entry.getKey())
//                                .stream()
//                                .filter(k -> k == key).collect(Collectors.toList()).get(0) == key)
//                        .mapToInt(Map.Entry::getKey)
//                        .boxed()
//                        .collect(Collectors.toList());
//                vertexBelongings.add(vertexesWithBelongings.get(key).get(0));
//                adjacencyList.add(Collections.singletonMap(key, vertexBelongings));
//            }
            System.out.println(adjacencyMap);

//            for (int j = 0; j < adjacencyList.size(); j++) {
            var x = 0;
            var y = 0;
//            var randomVertexWithBelongings = adjacencyList.get(0);
            var centralVertexCandidates = adjacencyMap
                    .entrySet()
                    .stream()
                    .flatMap(vertexWithBelongings -> vertexWithBelongings
                                    .getValue()
                                    .stream()
                                    .filter(vertexBelonging ->
                                            adjacencyMap.entrySet().stream().anyMatch(vertex -> vertex.getValue().size() == 1)
                                                    ||
                                                    !vertexesWithBelongings
                                                            .containsKey(vertexBelonging)
                                    )
//                                            .collect(Collectors.toList())
                    )
                        .collect(Collectors.toSet());

                    var centralVertex = centralVertexCandidates
                            .stream()
                                .filter(candidate -> {
                                    var numberOfBelongings = 0;
                                    for (var belongings : adjacencyMap.values()) {
                                        if (belongings.contains(candidate)) {
                                            numberOfBelongings++;
                                        }
                                    }
                                   return numberOfBelongings > 1;
                                })
                                    .findFirst()
                                        .orElse(null);

                    var initialVertex = centralVertex != null ? centralVertex : centralVertexCandidates.iterator().next();

                    if (centralVertex != null) {
                        var belongings = adjacencyMap
                                .entrySet()
                                .stream()
                                .filter(vertex -> vertex
                                        .getValue()
                                        .contains(initialVertex))
                                .collect(Collectors.toList());
                        x = belongings.size() + 1;
                        y = (int)belongings.stream().filter(vertex -> !Objects.equals(vertex.getKey(), initialVertex)).count();
                    } else {
                        var edgeVertexBelonging = retrieveEdgeVertexBelongings(initialVertex);
                        y = edgeVertexBelonging.values().size() - 1;
                        var nextVertexInPath = edgeVertexBelonging.keySet().iterator().next();
//                        x = adjacencyList.stream().map(vertex -> vertex.values().iterator().next().get(
//                                retrieveVectorBelongings(nextVertexInPath)
//                                    .get(0)
//                                    .values()
//                                    .iterator()
//                                    .next()
//                                    .stream()
//                                    .filter(v -> vertexesWithBelongings
//                                            .getOrDefault(v, Collections.emptyList())
//                                            .size() > 1)
//                                        .iterator().next()
//                                )
//                        ).iterator().next();
                            x = retrieveEdgeVertexBelongings(nextVertexInPath).values().size();
//                        Integer finalCentralVertex = centralVertex;
//                        x = adjacencyList.stream().filter(vertex -> vertex.getOrDefault(finalCentralVertex, null) != null).iterator().next().values().iterator().next().size();
                    }
//                    .filter(belongings -> !belongings.isEmpty())
//                        .map(vertexBelonging -> Integer.parseInt(String.valueOf(vertexBelonging)))
//                            .findFirst()
//            System.out.println(initialVertex);
//            var edgeVertexNumber = edgeVertexIterator.next();
//            for (int j = 0; j < adjacencyList.size(); j++) {
//                if (adjacencyList.get(j).values().iterator().next().contains(edgeVertexNumber)) {
//                    edgeVertexNumber = edgeVertexIterator.next();
//                }
//            }

//            if (neighborsCount == 1) {
//                    var vertexSingleBelonging = randomVertexWithBelongings
//                            .values()
//                            .stream()
//                            .findAny()
//                            .orElse(null);
//                var vertexBelongingsIterator = randomVertexWithBelongings
//                        .entrySet()
//                        .iterator()
//                        .next()
//                        .getValue()
//                        .iterator();
//
////                var vertexSingleBelonging = 0;
//                if (vertexBelongingsIterator.hasNext()) {
//                    var vertexSingleBelonging = (int) vertexBelongingsIterator.next();
//                    y = vertexesWithBelongings
//                            .keySet()
//                            .stream().filter(el -> el == vertexSingleBelonging)
//                            .collect(Collectors.toList())
//                            .get(0);
//
//                    var centralVertex = 0;
//                    var vertexes = adjacencyList
//                            .stream()
//                            .mapToInt(vertex -> vertex.keySet().iterator().next())
//                            .boxed()
//                            .collect(Collectors.toSet());
//                    for (int j = 0; j < adjacencyList.size(); j++) {
//                        var vertexBelongings_ = new ArrayList<Integer>(adjacencyList.get(j).values().iterator().next());
////                        System.out.println(vertexBelongings);
//                        for (int k = 0; k < vertexBelongings_.size(); k++) {
//                            var currentVertex = (int)vertexBelongings_.get(k);
//                            if (!vertexes.contains(currentVertex)) {
//                                if (centralVertex != currentVertex)
//                                centralVertex = currentVertex;
//                                x++;
//                            }
//                        }
//                    }

//                    var anotherRandomVertexBelongingsIterator = adjacencyList
//                            .get(vertexSingleBelonging)
//                            .entrySet()
//                            .iterator()
//                            .next()
//                            .getValue()
//                            .iterator();

//                    var anotherRandomVertexBelongings = anotherRandomVertexBelongingsIterator.next();
//                    x = vertexesWithBelongings
//                            .keySet()
//                            .stream().filter(el -> el == anotherRandomVertexBelongings)
//                            .collect(Collectors.toList())
//                            .get(0);
//                }
                System.out.println(x + " " + y);
//            }
        }
    }
}

