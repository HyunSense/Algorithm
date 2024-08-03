package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer Nst = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(bf.readLine());
        StringTokenizer Mst = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();

        int[] search = new int[N];

        for (int i = 0; i < N; i++) {
            search[i] = Integer.parseInt(Nst.nextToken());
        }

        Arrays.sort(search);


        for (int i = 0; i < M; i++) {
            int solve = solve(search, Integer.parseInt(Mst.nextToken()));
            sb.append(solve).append("\n");
        }

        System.out.println(sb);


    }
    public static int solve(int[] search, int findKey) {

        int low = 0;
        int high = search.length - 1;

        while (low <= high) {

            // 찾고자 하는 값이 중간값 보다 크다면 중간 부터 이전 삭제 low = mid + 1
            // 찾고자 하는 값이 중간값 보다 작다면 중간 부터 이후 삭제 high = mid - 1

            int mid = low + (high - low) / 2;

            if (search[mid] == findKey) {

                return 1;
            }

            if (search[mid] < findKey) {

                low = mid + 1;
            }

            if (search[mid] > findKey) {

                high = mid - 1;
            }

        }

        return 0;
    }
}
