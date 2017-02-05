package com.algorithms.search;

import java.util.*;

/**
 * Implemented Dijkstra's algorithm
 * Using to find out path less cost for a graph
 */
public class DijkstrasAlgorithm {

    public static final String START = "START";
    public static final String END = "END";

    public Set<String> printLowCostPath(final Map<String, Map<String, Integer>> graph){
        int cost;
        int newTotalCost;
        String node;
        Map<String, Integer> neighbors;

        if (isNegativeGraph(graph)){
            return new HashSet<>();
        }

        Map<String, Integer> costs = initCosts(graph);
        Map<String, String> parents = initParents(graph);
        List<String> processed = initProcessed();
        Optional<String> nodeLow = findLowestCostNode(costs, processed);

        while (nodeLow.isPresent()){
            node = nodeLow.get();
            cost = costs.get(node);
            neighbors = graph.get(node);
            for (String newNode : neighbors.keySet()){
                newTotalCost = cost + neighbors.get(newNode);
                if (newTotalCost < costs.getOrDefault(newNode, newTotalCost+1)){
                    costs.put(newNode, newTotalCost);
                    parents.put(newNode, node);
                }
            }
            processed.add(node);
            nodeLow = findLowestCostNode(costs, processed);
        }

        return printPath(parents);
    }


    private boolean isNegativeGraph(final Map<String, Map<String, Integer>> graph){
        for(String parent : graph.keySet()){
            for(String node : graph.get(parent).keySet()){
                if (graph.get(parent).get(node) < 0){
                    return true;
                }
            }
        }
        return false;
    }

    private Set<String> printPath (final Map<String, String> parents){

        Set<String> path = new HashSet<>();
        if (parents.containsKey(END)) {
            String node = END;
            while (!node.equals(START)) {
                System.out.print(node + "-->");
                path.add(node);
                node = parents.get(node);
            }
            System.out.println(node);
        }
        return path;
    }

    private Map<String, Integer> initCosts (final Map<String, Map<String, Integer>> graph){
        return graph.get(START);
    }

    private Map<String, String> initParents (final Map<String, Map<String, Integer>> graph){
        Map<String, Integer> startNode = graph.get(START);
        Map<String, String> parents = new HashMap<>();
        for(String node : startNode.keySet()){
            parents.put(node, START);
        }
        return parents;
    }

    private List<String> initProcessed(){
        List<String> processed = new ArrayList<>();
        processed.add(START);
        processed.add(END);
        return  processed;
    }

    private Optional<String> findLowestCostNode (final Map<String, Integer> costs, final List<String> processed){
        int lowCost = -1;
        Optional<String> lowCostNode = Optional.empty();
        for (String node : costs.keySet()){
            int cost = costs.get(node);
            if ((isFirstTime(lowCostNode) || cost < lowCost) && !isNodeProcessed(node, processed)){
                lowCost = cost;
                lowCostNode = Optional.of(node);
            }
        }
        return  lowCostNode;
    }

    private boolean isNodeProcessed(final String node, final List<String> processed){
        return processed.contains(node);
    }

    private boolean isFirstTime (final Optional<String> lowCostNode){
        return !lowCostNode.isPresent();
    }


}
