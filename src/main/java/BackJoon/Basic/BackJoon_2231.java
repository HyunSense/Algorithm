package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        // 주어진 자연수보다 무조건 작다.
        // 포문으로 돌린다.
        int result = 0;

        for (int i = 1; i < N; i++) {
            String s = String.valueOf(i);
            String[] strArray = s.split("");

                int origin = Integer.parseInt(s);
                int sum = Integer.parseInt(s);
                for (int j = 0; j < strArray.length; j++) {

                    sum += Integer.parseInt(strArray[j]);
                }
                if (sum == N) {
                    result = origin;
                    break;
                }


        }

        System.out.println(result);
    }
}
