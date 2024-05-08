package ui;


import collections.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", true);
        graph.addEdge("B", "C", true);


        //dfs
        System.out.println("dfs\n");

        List<String> dfsResult = graph.dfs("A");
        for (String node : dfsResult) {
            System.out.println("Node: " + node);
        }

        //bfs
        System.out.println(" \nbfs \n");
        HashMap<String, Integer> bfsResult = graph.bfs("A");
        for (Map.Entry<String, Integer> entry : bfsResult.entrySet()) {
            System.out.println("Node " + entry.getKey() + " is at distance: " + entry.getValue());
        }



        //adjacent matrix
        System.out.printf("\nadjacent matrix \n");

        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        //adjacent list
        System.out.println("\nadjacent list \n");

        HashMap<String, List<String>> adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println("Node " + entry.getKey() + " is connected to: " + entry.getValue());
        }

    }
}
