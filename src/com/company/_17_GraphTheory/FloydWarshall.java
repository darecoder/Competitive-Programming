package com.company._17_GraphTheory;

public class FloydWarshall {
    public static void floydWarshall(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];
        int i, j, k;
        for (i = 0; i < graph.length; i++) {
            for (j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < graph.length; k++) {
            for (i = 0; i < graph.length; i++) {
                for (j = 0; j < graph.length; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE &&
                            dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    public static void printSolution(int[][] distance) {
        for (int[] dist : distance) {
            for (int j = 0; j < distance.length; ++j) {
                if (dist[j] == Integer.MAX_VALUE) {
                    System.out.print("-- ");
                } else {
                    System.out.print(dist[j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {
        int inf = Integer.MAX_VALUE;
        int[][] graph = {{0,   5,  inf, 10},
                         {inf, 0,   3, inf},
                         {inf, inf, 0,   1},
                         {inf, inf, inf, 0}};

        floydWarshall(graph);
    }
}
