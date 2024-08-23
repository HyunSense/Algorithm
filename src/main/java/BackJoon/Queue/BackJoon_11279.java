package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BackJoon_11279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                q.offer(x);
            } else {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int n = q.poll();
                    sb.append(n).append("\n");
                }

            }
        }

        System.out.println(sb);
    }
}
