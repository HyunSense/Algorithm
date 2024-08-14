package BackJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_2110 {

    static int[] house;
    static int N,C;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // 1 2 8 4 9
        // 1 2 4 8 9
        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 두 공유기 사이의 거리를 가능한 크게 설치한다.
        // 크게설치후, 인접한 공유기끼리의 거리를 구한다.

        // mid를 3개구한다?
        // 처음부터 끝까지의 중간1
        // 처음부터 중간1 까지의 중간2
        // 중간1부터 끝까지의 중간3

//        fori 를 C만큼 돌려야한다.

        int realLow = house[0];
        int realHigh = house[N - 1];

        int realMid = realLow + ((realHigh - realLow) / 2);
        System.out.println("realMid = " + realMid);
        // 실제 realMid와 가까운 mid배열을 찾는다.
        // 그럼 realMid를 house[]의 차이가 최소인 house[]를 구한다.

        int houseMin = 0;
        int minNum = 0;

        for (int i = 0; i < N; i++) {
            if (realMid > house[i]) {
                houseMin = realMid - house[i];
            } else {
                houseMin = house[i] - realMid;
            }

            if (houseMin < min) {
                min = houseMin;
                minNum = i;
            }
        }
        // 1 2 4 8 9
        System.out.println("minNum = " + minNum);
        int key = house[minNum];


    }

    // 실제 중간값을 찾으려면 처음부터 끝의 값을 더한후에 2를 나눈후 그에 가까운 중간위치를 찾아야한다.
    //
    public static void solve(int key) {

        int low = 0;
        int high = N - 1;

        while (low <= high) {

            int mid = low + ((high - low) / 2);

            if (house[mid] > key) { // 중간값보다 키가 작다면
                high = mid - 1;
            }

            if (house[mid] < key) {
                low = mid + 1;
            }
        }

    }
}
