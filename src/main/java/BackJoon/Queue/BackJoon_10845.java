package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_10845 {
    static Deque<Integer> queue;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            String s = br.readLine();
            String solve = solve(s);
            if (!solve.equals("")) {
                System.out.println(solve);
            }
        }
    }


    static String solve(String s) {

        String result = "";
        StringTokenizer st = new StringTokenizer(s, " ");

        switch (st.nextToken()) {

            case "push":
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
                break;

            case "pop":
                Integer poll = queue.poll();
                if (poll == null) {
                    return "-1";
                }
                return String.valueOf(poll);

            case "size":
                return String.valueOf(queue.size());

            case "empty":
                boolean empty = queue.isEmpty();
                if (empty) {
                    return "1";
                } else {
                    return "0";
                }

            case "front":
                Integer peek = queue.peek();
                if (peek == null) {
                    return "-1";
                }
                return String.valueOf(peek);

            case "back":
                Integer peekLast = queue.peekLast();
                if (peekLast == null) {
                    return "-1";
                }
                return String.valueOf(peekLast);
        }


        return result;

    }
}
