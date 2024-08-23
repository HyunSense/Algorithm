package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon_1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서
            int count = 0;


            LinkedList<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");


            // 문서, 문서 중요도
            for (int j = 0; j < N; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});

            }

            while (!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;
                for (int j = 0; j < queue.size(); j++) {

                    // 처음 뽑은 원소보다 j번째 원소가 클경우
                    if (front[1] < queue.get(j)[1]) {

                        queue.offer(front);
                        for (int k = 0; k < j; k++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;

                    }
                }

                if (isMax == false) {
                    continue;
                }

                count++;
                if (front[0] == M) {
                    break;
                }

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}