package BackJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_10816_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());


        int[] search = new int[N];
        for(int i = 0; i < N; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(search);

        int M = Integer.parseInt(bf.readLine()); // 찾아야 하는 정수
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int findKey = Integer.parseInt(st.nextToken());
            sb.append(upperBound(search, findKey) - lowerBound(search, findKey)).append(" ");
        }

        System.out.println(sb);
    }
    public static int lowerBound(int[] search, int findKey) {

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

    public static int upperBound(int[] search, int findKey) {

        int low = 0;
        int high = search.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (findKey < search[mid]) {
                low = mid;
            } else { // findKey >= search[mid] 일때
                low = mid + 1; // 초과기 때문에 mid + 1
            }
        }

        return low;
    }

    // 1, 2, 3, 4, 5, 5, 6, 7
    public static int upperBound1(int[] arr, int value){
        int max = arr.length; // length-1 이라할때 max는 6, 0~6
        int min = 0;
        while(min<max){ // 7을 구하려고 할때
            int mid = (min+max)/2; // (1+6)/2 = 3, (4+6)/2 = 5, (6+6)/2 = 6, (7+6)
            if(value<arr[mid]){ // 7 < 4, 7 < 5, 7 < 6
                max = mid;
            }else{
                min = mid+1; // min => 3+1=4, 5+1=6, 6+1=7,
            }
        }
        return min-1;
    }
}
