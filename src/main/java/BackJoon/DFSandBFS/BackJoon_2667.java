package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackJoon_2667 {

    static final int MAX = 30;
    static boolean[][] graph;
    static boolean[][] visited;

    static int countPerDanji;
    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        graph = new boolean[N+1][N+1];
//        visited = new boolean[N+1][N+1];
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];


        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();

            for (int j = 1; j < N + 1; j++) {
                if (s.charAt(j - 1) == '1') {
                    graph[i][j] = true; // 집이 있다는것을 뜻한다. 없다면 false
                }
            }
        }

        // (1,1) 부터 (N, N)까지 돌면서 dfs
        List<Integer> countList = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (graph[i][j] && !visited[i][j]) { // graph[i][j] 에 집이있고 방문을 하지 않았다면
                    countPerDanji = 0; // 새로운 dfs가 시작했을때는 0으로 클리어
                    dfs(i, j);
                    countList.add(countPerDanji);
                }
            }
        }

        System.out.println(countList.size());

        Collections.sort(countList);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i));
        }

    }

    private static void dfs(int y, int x) {

        visited[y][x] = true; // 방문여부
        countPerDanji++;

        // 상하좌우를 갈 수있는지 체크
        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (!visited[newY][newX] && graph[newY][newX]) {
                dfs(newY, newX);
            }
        }

    }

}
