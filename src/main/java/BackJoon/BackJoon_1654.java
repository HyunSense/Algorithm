package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long min = 0;
        long max = 0;

        int[] search = new int[N];
        for (int i = 0; i < N; i++) {
            search[i] = Integer.parseInt(br.readLine());

            if (search[i] > max) {
                max = search[i];
            }
        }
        
        max++;

        while (min < max) {

            long mid = min + (max - min) / 2;
            
            long count = 0;

            for (int i = 0; i < search.length; i++) {
                count += (search[i] / mid);
            }

            if (count < K) {
                max = mid;
            } else {

                min = mid + 1;
            }

        }

        System.out.println(min - 1);

    }
}
