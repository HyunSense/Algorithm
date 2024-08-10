package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_17298_1_미해결 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }
        String solve = solve(arr);
        System.out.println("solve = " + solve);
    }

    public static String solve(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0 ; i--) {
            stack.push(arr[i]);
        }

        int pop = stack.pop();

        for (int i = arr.length - stack.size(); i <= arr.length - 1; i++) {

            if (pop < arr[i]) {
                sb.append(arr[i]).append(" ");
                break;
            }

        }
        return sb.toString();
    }
}
