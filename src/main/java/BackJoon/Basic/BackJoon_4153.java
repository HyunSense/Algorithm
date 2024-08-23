package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        while (true) {
            String s = br.readLine();
            if (s.equals("0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s, " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            // 직각삼각형의 조건 -> 피타고라스
            // 가장긴변^2 = A^2 + B^2
            int length = arr[2] * arr[2];
            if (length == (arr[1] * arr[1]) + (arr[0] * arr[0])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }


        }

    }
}
