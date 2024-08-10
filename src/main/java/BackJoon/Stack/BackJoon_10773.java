package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackJoon_10773 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        int T = Integer.parseInt(bf.readLine());

        // 재현이가 0 을 부를때 재민이는 받아적은수를 pop 시킨다.
        // 최종적으로 stack의 합을 계산
        System.out.println(solve(T));

    }

    public static int solve(int T) throws IOException{


        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(bf.readLine());

            if (i == 0 && x == 0) {
                continue;
            }

            if (x == 0) {
                stack.pop();
                continue;
            }

            stack.push(x);
        }


        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;

    }
}
