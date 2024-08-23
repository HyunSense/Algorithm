package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1부터 차례대로 어센딩
        // 8부터 아래로 디센딩
        // 둘다 아니면 믹스드

        int[] arr = new int[8];
        boolean[] check = new boolean[2];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 8 - 1; i++) {
            int n = arr[i] + 1;
            if (n != arr[i + 1]) {
                check[0] = false;
                break;
            } else {
                check[0] = true;
            }
        }

        for (int i = 0; i < 8 - 1; i++) {
            int n = arr[i] - 1;
            if (n != arr[i + 1]) {
                check[1] = false;
                break;
            } else {
                check[1] = true;
            }
        }
//        1 2 3 4 8 7 6 5

        if (check[0]) {
            System.out.println("ascending");
        } else if (check[1]) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");

        }
    }

}
