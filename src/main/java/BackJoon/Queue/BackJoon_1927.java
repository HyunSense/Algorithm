package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BackJoon_1927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int p = q.poll();
                    sb.append(p).append("\n");
                }
            } else {
                q.offer(x);
            }
        }


        System.out.println(sb);
    }
}
