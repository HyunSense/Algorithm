package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_31403 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int result = 0;
        String StringSum = "";
        for (int i = 0; i < 3; i++) {

            int n = Integer.parseInt(br.readLine());
            if (i < 2) {
                sum += n;
                String s = n + "";
                StringSum += s;
            }
            if (i == 2) {
                sum = sum - n;
                int num = Integer.parseInt(StringSum);
                result = num - n;
            }
        }

        System.out.println(sum);
        System.out.println(result);
    }
}
