package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1158 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {

            if (queue.size() == 1) {
                Integer num = queue.poll();
                sb.append(num);
                break;
            }

            for (int i = 0; i < K - 1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }


            Integer num = queue.poll();
            sb.append(num).append(", ");

        }

        sb.append(">");

        System.out.println(sb);

    }
}
