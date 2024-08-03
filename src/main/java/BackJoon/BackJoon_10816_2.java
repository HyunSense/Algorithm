package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_10816_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] search = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(search);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int findKey = Integer.parseInt(st.nextToken());

            int solve = upperBound(search, findKey) - lowerBound(search, findKey);
            sb.append(solve).append(' ');
        }

        System.out.println(sb);
    }

    private static int upperBound(int[] search, int findKey) {

        int low = 0;
        int high = search.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (findKey < search[mid]) {
                high = mid;
            } else {
                low = mid + 1; // 중복된 찾고자하는 값보다 큰 값을 찾아야하기 때문에
            }
        }

        return low;
    }

    private static int lowerBound(int[] search, int findKey) {

        int low = 0;
        int high = search.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (findKey <= search[mid]) {
                high = mid;
            } else { // findKey > search[mid]
                low = mid + 1;
            }
        }

        return low;
    }
}
