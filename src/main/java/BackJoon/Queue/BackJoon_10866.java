package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_10866 {

    static Deque<Integer> deque;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        deque = new LinkedList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            solve(br.readLine());

        }

        System.out.println(sb);

    }


    static void solve(String s) {

        StringTokenizer st = new StringTokenizer(s, " ");

        switch (st.nextToken()) {

            case "push_front":
                deque.offerFirst(Integer.parseInt(st.nextToken()));
                break;

            case "push_back":
                deque.offerLast(Integer.parseInt(st.nextToken()));
                break;

            case "pop_front":
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.poll()).append("\n");
                }
                break;

            case "pop_back":
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
                break;

            case "size":
                sb.append(deque.size()).append("\n");
                break;

            case "empty":
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;

            case "front":
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peek()).append("\n");
                }
                break;

            case "back":
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
                break;
        }
    }
}
