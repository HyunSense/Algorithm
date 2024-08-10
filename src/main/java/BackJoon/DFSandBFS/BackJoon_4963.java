package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_4963 {

    static int[][] map;
    static boolean[][] visited;
    static int w, h;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs();
        }
    }

    static void dfs() {


        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                visited[i][j] = true;

                if (map[i][j] == 1)
            }
        }

    }
}
