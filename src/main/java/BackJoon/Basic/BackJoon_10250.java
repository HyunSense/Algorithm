package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10250 {

    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        // 엘레베이터 행 추가 해야하므로 가로줄 + 1
        // 무조건 n-1,h-1 부터 n-1,h-2 n-1,h-3 순으로

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            graph = new int[W][H];

            int program = program(H, W, N);
            System.out.println(program);
        }

    }
//        1
//        10 10 100
    static int program(int H, int W, int N) {
        int room = 0;
        int count = 0;

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {

                if (graph[i][j] != 1) {
                    graph[i][j] = 1;
                    count++;
                    room = makeRoom(j, i);
//                    System.out.println("room = " + room);
                }
                if (count == N) {
                    return room;
                }
            }
        }

        return room;
    }

    static int makeRoom(int h, int w) {

        h = h + 1;
        w = w + 1;

        if (w >= 10 && h < 10) {
            h = h * 100;
            return h + w;
        }

        if (w >= 10) {
            h = h * 100;
            return h + w;
        }

        if (h >= 10) {
            h = h * 100;
            return h + w;
        }

        h = h * 100;

//        w = w + 1;
//        if (w >= 10) {
//            if (h + 1 >= 10) {
//                h = (h + 1) * 100;
//            } else {
//                h = (h + 1) * 1000;
//            }
//
//        } else {
//            h = (h + 1) * 100;
//        }


        return h+w;
    }
}
