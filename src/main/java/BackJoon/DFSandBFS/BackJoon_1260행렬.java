package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1260행렬 {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 정점의 번호

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[y][x] = graph[x][y] = 1; // 애초에 작은것부터 담긴다.
        }
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        // 방문 초기화 필요
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);

    }

    static void dfs(int node) {

        visited[node] = true;
        sb.append(node).append(" ");

        for (int i = 1; i < N + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {

                dfs(i);
            }
        }
    }

    static void bfs(int node) {

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node); // 1. 최초로 노드를 넣는다.

        while (!queue.isEmpty()) {
            int poll = queue.poll(); // 2.노드를 뺀다.

            for (int i = 1; i < N + 1; i++) {
                if (graph[poll][i] == 1 && !visited[i]) { // 3. poll 노드를 기준으로 자식노드를 탐색
                    visited[i] = true;
                    queue.offer(i); // 4. 뺀 노드의 자식 노드를 넣는다.
                }
            }
            sb.append(poll).append(" ");
        }
    }
}
