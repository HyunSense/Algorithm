package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_30802 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int TCount = 0;
        for (int i = 0; i < 6; i++) {
            TCount += size[i] / T;
            if (size[i] % T != 0) {
                TCount++;
            }
        }

        int x = N / P;
        int y = N % P;

        System.out.println(TCount);
        System.out.println(x + " " + y);

    }
}
