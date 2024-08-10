package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2178_dfs시간초과 {

    static int[][] graph;
    static boolean[][] visited;
    static int count;

    static int N, M;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        graph = new int[N + 10][M + 10];
//        visited = new boolean[N + 10][M + 10];

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '1') {
                    graph[i][j] = 1;
                }
            }
        }


        dfs(0, 0, 1);
        // 1. 최소의 칸수를 구해야한다.
        // (1,1) -> (4,6) 도달해야한다.
        System.out.println(minDistance);
    }

    static void dfs(int y, int x, int distance) {

        visited[y][x] = true;

        if (y == N - 1 && x == M - 1) {
            minDistance = Math.min(minDistance, distance);
            return;
        }

        count++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newX < 0 || newY < 0 || newY >= N || newX >= M) {
                continue;
            }

            if (graph[newY][newX] == 1 && !visited[newY][newX]) {
                dfs(newY, newX, distance + 1);
            }
        }

        visited[y][x] = false;
    }
}
