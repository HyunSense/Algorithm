package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_11866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }
        sb.append("<");
        while (!queue.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                Integer num = queue.poll();
                queue.offer(num);
            }

            Integer poll = queue.poll();

            if (queue.isEmpty()) {
                sb.append(poll);
            } else {
                sb.append(poll).append(", ");
            }

        }

        sb.append(">");
        System.out.println(sb);
    }
}
