package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_14502 {

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};
    static int[][] graph;
    static boolean[][] visited;

    static int N, M;

    static int wallCnt;
    static int totalWallCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 세로 y
        M = Integer.parseInt(st.nextToken()); // 가로 x

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 안전영역 최대 크기
        // 벽 3개를 세울 수 있는 모든 경우의 수
        // 3개를 세운 후 바이러스를 퍼트린다음에 바이러스의 최소값을 구하기

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j < M + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println("totalWallCnt = " + totalWallCnt);

    }

    static void dfs(int wallCnt) {

        if (wallCnt == 3) {
            totalWallCnt++;
            wallCnt = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {

                    visited[i][j] = true;
                    graph[i][j] = 1;
                    wallCnt = wallCnt + 1;
                    dfs(wallCnt);
                    graph[i][j] = 0;
                }
            }
        }
    }

}
