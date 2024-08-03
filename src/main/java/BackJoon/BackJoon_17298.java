package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // Ai의 오큰수는 오른쪽에있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미
        // 오큰수가 없다면 -1 반환
        // ex: Ai = 3, [3 1 2 5] |> NGE(1) = 5, NGE(2) = 2, NGE(3) = 5, NGE(4) = -1

        // stack 생각

        // 맨 마지막은 무조건 -1
        // 3 을 꺼냇을때 1 2 5 중 왼쪽에서 부터 큰값
        // 1 을 꺼냇을때 2 5 중 왼쪽에서 부터 큰 값
        // 2 를 꺼냇을때 5 중 왼쪽에서 부터 큰 값 없다면 -1
        // 5 를 꺼냇을때 empty라면 -1

        // 배열을 받아서 거꾸로 넣는다.

        // 큐를 써도되지 않나?

        int N = Integer.parseInt(bf.readLine());

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        Queue<Integer> que = new LinkedList<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            que.offer(x);
            arr[i] = x;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int x = solve(que, arr);
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }

    public static int solve(Queue<Integer> que, int[] arr) {

//        StringBuilder sb = new StringBuilder();
//        Stack<Integer> stack = new Stack<>();
        // 3을 꺼낸다 5 2 7 -> 4 - 3 = 1 , 1 <= 3 -> 5
        // 5를 꺼낸다 2 7 -> 4 - 2 = 2 , 2 <= 3 ->

        Integer poll = que.poll();

        for (int i = arr.length - que.size(); i <= arr.length - 1; i++) {

            if (poll < arr[i]) {
                return arr[i];
            }

        }
        return -1;
    }
}
