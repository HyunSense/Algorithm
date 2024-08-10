package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2664 {

    static int n, m, c1, c2;

    static int[][] graph;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

//        bfs(c1, c2);
        dfs(c1, c2);
        if (count[c2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count[c2]);
        }
    }


    static void dfs(int start, int end) {

        visited[start] = true;
        if (start == end) {
            return;
        }

        for (int i = 1; i < n + 1; i++) {

            if (graph[start][i] == 1 && !visited[i]) {

                visited[i] = true;
                count[i] = count[start] + 1;
                dfs(i, end);
            }
        }

    }

    static void bfs(int start, int end) {

        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 1.시작노드를 넣는다.

        while (!queue.isEmpty()) {

            int poll = queue.poll(); // 2. 노드를 꺼낸다.
            if (poll == end) {
                return;
            }

            // 3. 꺼낸 노드의 자식들을 넣는다.
            for (int i = 1; i < n + 1; i++) {
                if (graph[poll][i] == 1 && !visited[i]) {
                    visited[i] = true;

                    count[i] = count[poll] + 1;
                    queue.offer(i);
                }
            }

        }

    }
}
