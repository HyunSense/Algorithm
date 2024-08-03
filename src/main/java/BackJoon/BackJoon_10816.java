package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon_10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer Nst = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(bf.readLine()); // 찾아야 하는 정수
        StringTokenizer Mst = new StringTokenizer(bf.readLine());

//        int[] search = new int[N];
//        for (int i = 0; i < N; i++) {
//            search[i] = Integer.parseInt(Nst.nextToken());
//        }
//        Arrays.sort(search);

        List<Integer> searchList = new ArrayList<>();

//        for (int i = 0; i < search.length; i++) {
//            searchList.add(search[i]);
//        }
        for (int i = 0; i < N; i++) {
            searchList.add(Integer.parseInt(Nst.nextToken()));
        }

        Collections.sort(searchList);
        List<Integer> originSearchList = new ArrayList<>(searchList);


        // 6 3 2 10 10 10 -10 -10 7 3
        // 10 9 -5 2 3 4 5 -10 찾아야되는 수
        // 찾은후 중복된 값 제거가 필요
        int count = 0;
        for (int i = 0; i < M; i++) {
            // searchList 초기화 작업이 필요
            searchList.clear();
            searchList.addAll(originSearchList);
            int findKey = Integer.parseInt(Mst.nextToken());
            int solve = solve(searchList, findKey, count);
            sb.append(solve).append(" ");

        }

        System.out.println(sb);

    }
    public static int solve(List<Integer> searchList, int findKey, int count) {

        // 반례
        // 3
        // -1 0 1
        // 5
        // 1 0 -1 0 1

        //답
        // 1 1 1 1 1

        int low = 0;
        int high = searchList.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (searchList.get(mid) == findKey) {
                searchList.remove(mid);
                count++;
                return solve(searchList, findKey, count);
            }

            if (searchList.get(mid) > findKey) {

                high = mid - 1;
            }

            if (searchList.get(mid) < findKey) {

                low = mid + 1;
            }
        }


        return count;
    }

//    public static int solve(int[] search, int findKey) {
//
//        // 숫자카드 N개, 정수 M개
//        // M 을 찾아야 된다 M이 없다면 0
//        // M 이 여러개면 ++
//
//        int count = 0;
//        int low = 0;
//        int high = search.length - 1;
//
//        while (low <= high) {
//
//            int mid = low + (high - low) / 2;
//
//            if (search[mid] == findKey) {
//                return 1;
//            }
//
//            if (search[mid] > findKey) {
//
//                high = mid - 1;
//            }
//
//            if (search[mid] < findKey) {
//
//                low = mid + 1;
//            }
//        }
//
//        return 0;
//    }
}
