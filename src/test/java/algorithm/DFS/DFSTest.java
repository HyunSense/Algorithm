package algorithm.DFS;

import org.junit.jupiter.api.Test;

public class DFSTest {

    static int[][] graph = {{}, {2, 3}, {4}, {5, 6}, {2}, {5, 7}, {3}, {7}};
    static boolean[] visited = new boolean[graph.length];

    @Test
    void start() {

        int start = 1;
        dfs(start);


    }

    static void dfs(int index) {

        visited[index] = true;

        System.out.print(index + " -> ");

        for (int node : graph[index]) {

            if (!visited[node]) {
                dfs(node);
            }
        }

    }


}
