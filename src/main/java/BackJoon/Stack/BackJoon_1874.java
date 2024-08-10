package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackJoon_1874 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            list.add(Integer.parseInt(bf.readLine()));

        }
        System.out.println(solve(list));
    }

    public static String solve(List<Integer> list) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        int size = 1;

        for (int j = 0; j < list.size(); j++) {
            int x = list.get(j);
            // 1 2 5 3 4
            for (int i = size; i <= x; i++) {

                stack.push(i);
                size++;
                sb.append("+\n");
            }

            int pop = stack.pop();
            sb.append("-\n");

            if (pop != list.get(j)) {
                return "NO";
            }
        }
        return sb.toString();
    }
}
