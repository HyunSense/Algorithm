package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon_2583_bfs {

    static int[][] graph;
    static boolean[][] visited;
//    static int count;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        int K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // (0 2) (4 4)
            for (int k = y1; k < y2; k++) {
                for (int j = x1; j < x2; j++) {
                    graph[k][j] = 1; // 직사각형 위치
                }
            }
        }
        List<Integer> countList = new ArrayList<>();
        // 직사각형에서 인접한 직사각형으로 이동

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    int data = bfs(i, j);
                    countList.add(data);
                }
            }
        }

        Collections.sort(countList);
        System.out.println(countList.size());
        for (Integer count : countList) {
            System.out.print(count + " ");
        }

    }

    static int bfs(int y, int x) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            for (int i = 0; i < 4; i++) {
                int newY = curY + dY[i];
                int newX = curX + dX[i];

                if (newX < 0 || newY < 0 || newY >= M || newX >= N) {
                    continue;
                }

                if (graph[newY][newX] == 0 && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.offer(new int[]{newY, newX});
                    count++;
                }
            }
        }

        return count;

    }
}
