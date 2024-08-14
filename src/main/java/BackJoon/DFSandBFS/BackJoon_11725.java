package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_11725 {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        // 인접행렬이 아닌 인접리스트로 해야될꺼같은데
        graph[1][1] = 1;
        for (int i = 0; i <N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            graph[i1][i2] = graph[i2][i1] = 1;

        }

        // 부모 노드를 출력하라
        bfs();

        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {

        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);


        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int i = 1; i < N + 1; i++) {

                if (graph[cur][i] == 1 && !visited[i]) {

                    visited[i] = true;
                    parent[i] = cur;
                    queue.offer(i);
                }

            }

//            System.out.print(cur + " -> ");

        }

    }
}
