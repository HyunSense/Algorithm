package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_10026 {

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};
    static final int MAX = 110;
    static char[][] graph;
    static boolean[][] visited;
    static int countR;
    static int countG;
    static int countB;
    static int countRG;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 적록색약은 빨강구역과 초록구역이 인접해있을경우 합친다.
        // 2. 적록색약은 빨강과 초록은 처음부터 하나다.

        // R 인경우 G 인경우 B 인경우 를 나눠서 dfs를 돌린다?

        graph = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];


        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                char c = s.charAt(j-1);
                graph[i][j] = c;
            }
        }

        // (1,1) 부터 (N,N) 까지 모두 들려서 R,G,B 확인 후 카운트 증가
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (graph[i][j] == 'R' && !visited[i][j]) {
                    dfs(i, j, 'R');
                    countR++;
                } else if (graph[i][j] == 'G' && !visited[i][j]) {
                    dfs(i, j, 'G');
                    countG++;
                } else if (graph[i][j] == 'B' && !visited[i][j]) {
                    dfs(i, j, 'B');
                    countB++;
                }
            }
        }

        // 방문 초기화
        visited = new boolean[MAX][MAX];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if ((graph[i][j] == 'R' || graph[i][j] == 'G') && !visited[i][j]) {
                        dfsRG(i, j);
                        countRG++;
                }
//                if (graph[i][j] == 'R' || graph[i][j] == 'G') {
//                    if (!visited[i][j]) {
//                        dfsRG(i, j);
//                        countRG++;
//                    }
//                }
            }
        }


        System.out.println((countR + countG + countB) + " " + (countRG + countB));
    }

    static void dfs(int y, int x, char c) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (graph[newY][newX] == c && !visited[newY][newX]) {
                dfs(newY, newX, c);
            }
        }
    }

    static void dfsRG(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if ((graph[newY][newX] == 'R' || graph[newY][newX] == 'G') && !visited[newY][newX]) {
                dfsRG(newY, newX);
            }
//            if (graph[newY][newX] == 'R' || graph[newY][newX] == 'G') {
//                if (!visited[newY][newX]) {
//                    dfsRG(newY, newX);
//                }
//            }
        }
    }
}
