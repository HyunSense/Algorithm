package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2178_bfs {

    static int[][] graph;
    static boolean[][] visited;
//    static int count;

    static int N, M;

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '1') {
                    graph[i][j] = 1;
                }
            }
        }

        int distance = bfs(0, 0);
        System.out.println(distance);
    }

   static int bfs(int y, int x) {

       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{y,x,1}); // 1은 현재 거리
       visited[y][x] = true;


       while (!queue.isEmpty()) {

           int[] poll = queue.poll();
           int curY = poll[0];
           int curX = poll[1];
           int distance = poll[2];
           if (curY == N - 1 && curX == M - 1) {

               return distance;
           }

           for (int i = 0; i < 4; i++) {
               int newY = curY + dY[i];
               int newX = curX + dX[i];

               if (newY < 0 || newX < 0 || newY >= N || newX >= M) {
                   continue;
               }

               if (graph[newY][newX] == 1 && !visited[newY][newX]) {
                   queue.offer(new int[]{newY, newX, distance + 1});
                   visited[newY][newX] = true;

               }
           }
       }

       return -1; //경로가 없을 경우
   }
}
