package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_2606_인접리스트2 {

    static int count = 0;
    static ArrayList<ArrayList<Integer>> link = new ArrayList<>();
    static boolean[] marked;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine()); // 컴퓨터 수(노드)
        int L = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수(간선 수)


        // 노드 수만큼 ArrayList 생성 (1부터 시작이기 때문에 +1)
        for (int i = 0; i < C + 1; i++) {
            link.add(new ArrayList<>());
        }

        marked = new boolean[C + 1];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            link.get(i1).add(i2);
            link.get(i2).add(i1);
        }
        dfs(1);
        System.out.println(count - 1);
    }


    static void dfs(int n) {
        marked[n] = true;
        count++;
        for (int node : link.get(n)) {
            if (!marked[node]) {
                dfs(node);
            }
        }

    }
}

