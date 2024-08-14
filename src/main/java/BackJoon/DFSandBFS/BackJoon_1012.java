package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon_1012 {

    static final int MAX = 60;
    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};
    static int count;

    static boolean[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            graph = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 간선

            for (int j = 1; j < K + 1; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y+1][x+1] = true;
            }


            count = 0; // 테스트마다 카운트 초기화
            // (1,1) 부터 (M, N) 까지 돌면서 dfs
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < M + 1; k++) {
                    if (graph[j][k] && !visited[j][k]) { // 배추가 존재하면서 방문했던적이 없다면
                        dfs(j, k);
                        count++;
                    }
                }
            }

            // T 가 한번 끝날때 마다 지렁이 마리수 출력
            System.out.println(count);
        }
    }

    private static void dfs(int y, int x) {

        visited[y][x] = true; // 방문여부 표시

        //인접한 곳을 구해야한다.
        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (graph[newY][newX] && !visited[newY][newX]) { // 배추 존재하면서 방문하지 않았다면
                dfs(newY, newX);
            }
        }
    }
}
