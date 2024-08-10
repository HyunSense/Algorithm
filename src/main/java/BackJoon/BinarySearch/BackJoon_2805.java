package BackJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //높이 H로 올라가서 일직선상 N개의 나무들을 절단한다.
        //이 때 N개의 나무들중 높이 H보다 높은 나무들은 잘리고 높이 H보다 낮은 나무들은 잘리지 않는다.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이

        st = new StringTokenizer(br.readLine(), " ");

        int max = 0;

        int[] search = new int[N];
        for (int i = 0; i < N; i++) {
            search[i] = Integer.parseInt(st.nextToken()); // N개의 나무의 높이들
            if (search[i] > max) {
                max = search[i];
            }
        }
        max++;
        long solve = solve(search, max, M);
        System.out.println(solve);
    }

    public static long solve(int[] search, long max, int M) {

        long min = 0;
        while (min < max) {

            long mid = min + (max - min) / 2;
            long length = 0;

            for (int i = 0; i < search.length; i++) {
                if (search[i] - mid < 0) { // 음수일 경우 넘긴다.
                    continue;
                }
                length += search[i] - mid;
                // 나무들을 중간값으로 자른다.
                // 중간값으로 자른 후 자른 길이를 합쳤을때 M이 아니라면 mid를 조정 여기서 M => key
            }

            if (length < M) { // length 가 M 보다 작으면, 절단 총 합이 Key보다 작다면? 높이를 낮춰야한다.
                max = mid;
            } else { // length >= M , 절단 총 합이 키보다 크거나 같으면 높이를 높여야한다.
                min = mid + 1;
            }
        }
        // 초과한값을 구한 것이기때문에 초과 전이 최대 값
        return min-1;

    }
}
