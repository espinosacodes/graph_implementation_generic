package collections;

import java.util.*;

/**
 * This class represents a generic Graph data structure.
 * @param <T> the type of elements in this Graph.
 */
public class Graph <T> {

    private HashMap<T, LinkedList<T>> map;
    private List<T> dfs_vis = new ArrayList<>();

    /**
     * Constructs an empty Graph.
     */
    public Graph() {
        map = new HashMap<>();
    }

    /**
     * Adds a vertex to the Graph.
     * @param label the vertex to be added.
     */
    public void addVertex(T label) {
        map.put(label, new LinkedList<T>());
    }

    /**
     * Adds an edge to the Graph.
     * @param init the initial vertex of the edge.
     * @param fin the final vertex of the edge.
     * @param undirected true if the edge is undirected, false otherwise.
     */
    public void addEdge(T init, T fin, boolean undirected) {
        if(!map.containsKey(init)) {
            addVertex(init);
        }

        if(!map.containsKey(fin)) {
            addVertex(fin);
        }

        map.get(init).add(fin);

        if(undirected) {
            map.get(fin).add(init);
        }
    }

    /**
     * Checks if a vertex is in the Graph.
     * @param v the vertex to check.
     * @return true if the vertex is in the Graph, false otherwise.
     */
    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    /**
     * Checks if an edge is in the Graph.
     * @param src the source vertex of the edge.
     * @param des the destination vertex of the edge.
     * @return true if the edge is in the Graph, false otherwise.
     */
    public boolean hasEdge(T src, T des) {
        return map.get(src).contains(des);
    }

    /**
     * Returns the number of vertices in the Graph.
     * @return the number of vertices in the Graph.
     */
    public int numVertices() {
        return map.keySet().size();
    }

    /**
     * Returns a string representation of the Graph.
     * @return a string representation of the Graph.
     */
    @Override
    public String toString() {
        String s = "";
        for(T i: map.keySet()) {
            s += i.toString() + ":";
            for(T j: map.get(i)) {
                s += j.toString() + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Performs a depth-first search (DFS) starting from a given vertex.
     * @param n the starting vertex.
     * @return a list of vertices visited during the DFS.
     */
    public List<T> dfs(T n) {
        dfs_vis.add(n);
        for(T i : map.get(n)) {
            if(!dfs_vis.contains(i)) {
                dfs(i);
            }
        }
        return dfs_vis;
    }

    /**
     * Performs a breadth-first search (BFS) starting from a given vertex.
     * @param n the starting vertex.
     * @return a map where the keys are the vertices and the values are the distances from the starting vertex.
     */
    public HashMap<T, Integer> bfs(T n) {
        int v = numVertices();
        Queue<T> q = new LinkedList<>();
        ArrayList<T> vis = new ArrayList<>();
        HashMap<T, Integer> dis = new HashMap<>();

        q.add(n);
        vis.add(n);
        dis.put(n, 0);

        while(!q.isEmpty()) {
            T cur = q.poll();
            for(T i : map.get(cur)) {
                if(!vis.contains(i)) {
                    vis.add(i);
                    dis.put(i, dis.get(cur) + 1);
                    q.add(i);
                }
            }
        }
        return dis;
    }



    /**
     * Checks if there is a path between two vertices.
     * @param src the source vertex.
     * @param des the destination vertex.
     * @return true if there is a path, false otherwise.
     */
    public boolean hasPath(T src, T des) {
        ArrayList<T> dfs_list = (ArrayList<T>) dfs(src);
        return dfs_list.contains(des);
    }

    /**
     * Returns the adjacency matrix of the Graph.
     * @return the adjacency matrix of the Graph.
     */
    public int[][] getAdjacencyMatrix() {
        int size = map.size();
        int[][] matrix = new int[size][size];
        List<T> nodes = new ArrayList<>(map.keySet());

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map.get(nodes.get(i)).contains(nodes.get(j))) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }


    /**
     * Returns the adjacency list of the Graph.
     * @return the adjacency list of the Graph.
     */
    public HashMap<T, List<T>> getAdjacencyList() {
        HashMap<T, List<T>> copy = new HashMap<>();
        for (Map.Entry<T, LinkedList<T>> entry : map.entrySet()) {
            copy.put(entry.getKey(), new LinkedList<>(entry.getValue()));
        }
        return copy;
    }


    //implementar bfs y dfs , listas de adyacencia y matrices de adyacencia


}