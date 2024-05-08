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
        List<String> dfsResult = graph.dfs("A");
        for (String node : dfsResult) {
            System.out.println("Node: " + node);
        }

        //bfs


        //adjacent matrix
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
