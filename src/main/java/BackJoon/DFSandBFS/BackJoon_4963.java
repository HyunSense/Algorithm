package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_4963 {

    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int count;
    static int totalCount;

//    static int[] dY = {0, 0, 0, 1, -1, 1, -1, 1, -1};
//    static int[] dX = {0, 1, -1, 0, 0, 1, -1, -1, 1};
    static int[] dY = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dX = {1, -1, 0, 0, 1, -1, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            findLand();
            System.out.println(count);
            count = 0;
        }
    }

    static void findLand() {

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
    }

//    static int dfs(int y, int x) {
//
//        for (int i = 0; i < 8; i++) {
//            int newY = y + dY[i];
//            int newX = x + dX[i];
//
//            if (newY < 0 || newX < 0 || newY >= h || newX >= w) {
//                continue;
//            }
//
//
//            if (map[newY][newX] == 1 && !visited[newY][newX]) {
//                visited[newY][newX] = true;
//                count = count + 1;
//                dfs(newY, newX);
//            }
//        }
//        return count;
//    }

    static void dfs(int y, int x) {

        for (int i = 0; i < 8; i++) {
            int newY = y + dY[i];
            int newX = x + dX[i];

            if (newY < 0 || newX < 0 || newY >= h || newX >= w) {
                continue;
            }


            if (map[newY][newX] == 1 && !visited[newY][newX]) {
                visited[newY][newX] = true;
                dfs(newY, newX);
            }
        }
    }
}
