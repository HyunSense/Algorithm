package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2468 {

    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int max = 0;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        graph = new int[N][N];
        visited = new boolean[N][N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(graph[i][j], maxHeight);
            }
        }

        for (int h = 0; h < maxHeight + 1; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (graph[i][j] > h && !visited[i][j]) {
                        count = count + 1;
                        dfs(i, j, h);
                    }
                }
            }
            max = Math.max(count, max);
        }
            System.out.println(max);

    }

    static void dfs(int y, int x, int h) {

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];


            if (newY < 0 || newX < 0 || newY >= N || newX >= N) {
                continue;
            }

            if (graph[newY][newX] > h && !visited[newY][newX]) {
                visited[newY][newX] = true;
                dfs(newY, newX, h);
            }
        }

    }
}
