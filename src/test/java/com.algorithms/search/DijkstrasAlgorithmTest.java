package com.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by pep on 5/02/17.
 */
public class DijkstrasAlgorithmTest {

    DijkstrasAlgorithm algorithm = new DijkstrasAlgorithm();

    @Test
    public void test_TwoNodes_Graph (){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeStart = new HashMap<>();
        nodeStart.put("A", 6);
        nodeStart.put("B", 2);
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put(DijkstrasAlgorithm.END, 1);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("A", 3);
        nodeB.put(DijkstrasAlgorithm.END, 5);
        graph.put(DijkstrasAlgorithm.START, nodeStart);
        graph.put("A", nodeA);
        graph.put("B", nodeB);

        Set<String> path = algorithm.printLowCostPath(graph);

        Set<String> expected = new HashSet<String>(Arrays.asList(DijkstrasAlgorithm.END, "A", "B"));
        Assert.assertEquals(expected.size(), path.size());
        Assert.assertTrue(expected.containsAll(path));

    }

    @Test
    public void test_ThreeNodes_Graph (){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeStart = new HashMap<>();
        nodeStart.put("A", 10);
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put("B", 20);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("C", 1);
        nodeB.put(DijkstrasAlgorithm.END, 30);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put("A", 1);

        graph.put(DijkstrasAlgorithm.START, nodeStart);
        graph.put("A", nodeA);
        graph.put("B", nodeB);
        graph.put("C", nodeC);

        Set<String> path = algorithm.printLowCostPath(graph);

        Set<String> expected = new HashSet<String>(Arrays.asList(DijkstrasAlgorithm.END, "B", "A"));
        Assert.assertEquals(expected.size(), path.size());
        Assert.assertTrue(expected.containsAll(path));

    }

    @Test
    public void test_FourNodes_Graph (){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeStart = new HashMap<>();
        nodeStart.put("A", 5);
        nodeStart.put("C", 2);
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put("B", 4);
        nodeA.put("D", 2);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("D", 6);
        nodeB.put(DijkstrasAlgorithm.END, 3);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put("A", 8);
        nodeC.put("D", 7);
        Map<String, Integer> nodeD = new HashMap<>();
        nodeD.put(DijkstrasAlgorithm.END, 1);

        graph.put(DijkstrasAlgorithm.START, nodeStart);
        graph.put("A", nodeA);
        graph.put("B", nodeB);
        graph.put("C", nodeC);
        graph.put("D", nodeD);

        Set<String> path = algorithm.printLowCostPath(graph);

        Set<String> expected = new HashSet<String>(Arrays.asList(DijkstrasAlgorithm.END, "D", "A"));
        Assert.assertEquals(expected.size(), path.size());
        Assert.assertTrue(expected.containsAll(path));

    }


    @Test
    public void test_NoPath_Graph (){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeStart = new HashMap<>();
        nodeStart.put("A", 2);
        nodeStart.put("B", 2);
        Map<String, Integer> nodeA = new HashMap<>();
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("A", 2);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put("A", 2);
        nodeC.put(DijkstrasAlgorithm.END, 2);

        graph.put(DijkstrasAlgorithm.START, nodeStart);
        graph.put("A", nodeA);
        graph.put("B", nodeB);
        graph.put("C", nodeC);

        Set<String> path = algorithm.printLowCostPath(graph);

        Assert.assertEquals(0, path.size());

    }

    @Test
    public void test_Negative_Graph (){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeStart = new HashMap<>();
        nodeStart.put("A", 2);
        nodeStart.put("B", 2);
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put("C", 2);
        nodeA.put(DijkstrasAlgorithm.END, 2);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("A", 2);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put("B", -1);
        nodeC.put(DijkstrasAlgorithm.END, 2);

        graph.put(DijkstrasAlgorithm.START, nodeStart);
        graph.put("A", nodeA);
        graph.put("B", nodeB);
        graph.put("C", nodeC);

        Set<String> path = algorithm.printLowCostPath(graph);

        Assert.assertEquals(0, path.size());

    }

}
