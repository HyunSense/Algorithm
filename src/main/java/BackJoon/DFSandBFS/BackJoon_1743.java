package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1743 {

    static int[][] graph;
    static boolean[][] visited;
    static int N, M, K;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 쓰레기 개수

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//            graph[r][c] = graph[c][r] = 1;
            graph[r][c] = 1;
        }

        // 쓰레기 대각선은 안됨 상하좌우

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    max = Math.max(count, max);
                    count = 0;
                }
            }
        }

        System.out.println(max);

    }


    static void dfs(int y, int x) {

        count = count + 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newY < 0 || newX < 0 || newY >= N + 1 || newX >= M + 1) {
                continue;
            }

            if (graph[newY][newX] == 1 && !visited[newY][newX]) {
                visited[newY][newX] = true;
//                count = count + 1;
                dfs(newY, newX);

            }
        }

    }
}
