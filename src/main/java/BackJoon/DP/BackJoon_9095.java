package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BackJoon_9095 {

    static Map<Integer, Integer> memo = new HashMap<>();
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 피보나치 조건
        // 첫째 둘째 항이 1이며, 이전 2항의 합이 다음 항과 같다.


        for (int i = 0; i < T; i++) {
            count = 0;
            int n = Integer.parseInt(br.readLine());
            count = count - 1;
            fibonacci(n);
        }

        System.out.println("count = " + count);
    }
    // 3 -> 1+1+1, 1+2, 2+1
    // f(2) + f(1)
    // f(1) + f(1) + f(1)
    // f(1) + f(2)

    // 4
    // f(3) + f(2) -> count 2
    // f(2) + f(1) + f(2) -> count 4
    // f(1) + f(0) + f(2) -> count
    //
    static int fibonacci(int n) {
        count = count + 1;
        if (n <= 1) {

            return 1;
        }


//        if (memo.containsKey(n)) {
//
//            return memo.get(n);
//        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
//        memo.put(n, result);

        return result;
    }

    static int fibonacci2(int n) {
        count = count + 1;
        if (n <= 1) {
            return 1;
        }

        int result = fibonacci(n - 2) + fibonacci(n - 1);

        return result;
    }
}
