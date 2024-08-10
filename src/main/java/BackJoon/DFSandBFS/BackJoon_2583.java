package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon_2583 {

    static int[][] graph;
    static boolean[][] visited;
    static int count;

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

        // 0,2 -> 4,4 도달
        // 1,1 -> 2,5 도달
        // 4,0 -> 6,2 도달

        // x: 4-0, y: 4-2 반복 4 * 2 = 8번 반복
        // 0,0 -> 1,1 이 하나의 사각형 이게 하나의 노드?
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
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    dfsR(i, j);
                    countList.add(count);
                }
            }
        }

        Collections.sort(countList);
        for (Integer count : countList) {
            System.out.print(count + " ");
        }

    }

    static void dfs(int y, int x) {

        visited[y][x] = true;
//        count++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newY < 0 || newX < 0 || newY >= M || newX >= N){
                continue;
            }

            if (graph[newY][newX] == 1 && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }

    }

    static void dfsR(int y, int x) {
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newY < 0 || newX < 0 || newY >= M || newX >= N){
                continue;
            }

            if (graph[newY][newX] == 0 && !visited[newY][newX]) {
                dfsR(newY, newX);
            }
        }
    }


}
