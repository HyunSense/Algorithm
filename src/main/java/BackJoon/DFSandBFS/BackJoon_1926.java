package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1926 {

    static int[][] graph;
    static boolean[][] visited;

    static int n, m;

    static int maxArea = 0;
    static int area;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = count + 1;
                    dfs(i, j);
                    maxArea = Math.max(area, maxArea);
                    area = 0;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);


    }

    static void dfs(int y, int x) {

        area = area + 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
                continue;
            }

            if (graph[newY][newX] == 1 && !visited[newY][newX]) {

                visited[newY][newX] = true;
                dfs(newY, newX);
            }
        }
    }
}
