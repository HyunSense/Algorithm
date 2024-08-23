package BackJoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BackJoon_1620 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static Map<String, String> map1 = new HashMap<>();
    static Map<String, String> map2 = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map1.put(String.valueOf(i + 1), s);
            map2.put(s, String.valueOf(i + 1));

        }

        for (int i = 0; i < M; i++) {

            solve(br.readLine());
        }

        System.out.println(sb);

    }

    public static void solve(String s) {

        String name = map1.get(s);

        if (name == null) {

            String num = map2.get(s);
            sb.append(num).append("\n");

        } else {
            sb.append(name).append("\n");
        }
    }
}
