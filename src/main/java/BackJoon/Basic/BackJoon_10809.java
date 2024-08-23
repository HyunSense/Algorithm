package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BackJoon_10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // backjoon 이라는 단어를 각각 26번 돌린다.
        // 26번 돌리는데 알파벳이있다면 그위치 표시 없다면 -1

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 97; j <= 122; j++) {
                if ((int) s.charAt(i) == j) {
                    if (arr[j - 97] == -1) {
                        arr[j - 97] = i;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
