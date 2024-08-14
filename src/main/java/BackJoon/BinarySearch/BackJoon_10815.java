package BackJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_10815 {

    static int[] card;
    static int[] myCard;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        myCard = new int[M];
        for (int i = 0; i < M; i++) {
            myCard[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < myCard.length; i++) {
            int solve = solve(myCard[i]);
            System.out.println(solve);
        }
    }

    public static int solve(int findKey) {

        int low = 0;
        int high = N - 1;


        while (low <= high) {

            int mid = low + ((high - low) / 2);

            if (card[mid] == findKey) {
                return 1;
            }


            if (card[mid] < findKey) { // 찾고자 하는 값이 중간보다 크다. -> 처음부터 중간 까지를 모두 날림 -> 중간 다음이 low

                low = mid + 1;

            }

            if (card[mid] > findKey) { // 찾고자 하는값이 중간보다 작다. -> 중간부터 끝까지 모두 날름 -> 중간 이전이 high
                high = mid - 1;
            }

        }

        return 0;
    }
}
