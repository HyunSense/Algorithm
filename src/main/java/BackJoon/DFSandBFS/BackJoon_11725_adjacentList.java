package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_11725_adjacentList {

    static int N;
    static boolean[] visited;
    static int[] parent;

    static ArrayList<Integer>[] adjacent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        adjacent = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adjacent[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            adjacent[i1].add(i2);
            adjacent[i2].add(i1);
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

            for (int i = 0; i < adjacent[cur].size(); i++) {
                int node = adjacent[cur].get(i);
                if (!visited[node]) {

                    visited[node] = true;
                    parent[node] = cur;
                    queue.offer(node);
                }

            }
        }
    }
}
