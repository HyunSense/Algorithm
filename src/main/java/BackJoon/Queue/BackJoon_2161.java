package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BackJoon_2161 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }

        List<Integer> list = new ArrayList<>();

        while (q.size() > 1) {

            int th = q.poll();// 버리는 카드
            list.add(th);
            int temp = q.poll();
            q.offer(temp);

        }


        for (int i : list) {
            System.out.printf("%d ", i);
        }
        System.out.print(q.poll());

    }
}
