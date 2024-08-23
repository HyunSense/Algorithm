package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        String s = br.readLine();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            String n = s.charAt(i) + "";
            int num = Integer.parseInt(n);
            sum += num;
        }
        System.out.println(sum);
    }
}
