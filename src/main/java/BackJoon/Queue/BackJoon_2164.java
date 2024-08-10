package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N +1; i++) {
            q.offer(i);
        }
        // 1 2 3 4
        while (q.size() > 1) {

            // 카드 버린다.
            q.poll();
            int poll = q.poll();
            q.offer(poll);
        }
        System.out.println(q.poll());
    }
}
