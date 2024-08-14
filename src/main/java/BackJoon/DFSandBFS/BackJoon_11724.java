package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11724 {

    static int[][] graph;
    static boolean[] visited;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            graph[i1][i2] = graph[i2][i1] = 1;
        }


        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                if (graph[i][j] == 1 && !visited[i]) {
                    count = count + 1;
                    dfs(i);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count = count + 1;
            }
        }

        System.out.println(count);

    }

    public static void dfs(int node) {

        visited[node] = true;

        for (int i = 1; i < N + 1; i++) {

            if (graph[node][i] == 1 && !visited[i]) {

                visited[i] = true;
                dfs(i);
            }

        }
    }

    public static void bfs() {


    }
}
